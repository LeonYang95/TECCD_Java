package net.sourceforge.fo3d.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Utility class for JavaScript compression using the Closure Compiler.
 * 
 * @see http://code.google.com/closure/compiler/
 */
public class JSClosureCompilerHTTPService implements JSCompressor {

    /**
     * Logging instance
     */
    private static Log log = LogFactory.getLog(JSClosureCompilerHTTPService.class);

    /**
     * The URL where the JavaScript Closure Compiler Service is located.
     */
    protected static final String SERVICE_URL = "http://closure-compiler.appspot.com/compile";

    /**
     * Compilation Level: WHITESPACE_ONLY
     * Just removes whitespace and comments from your JavaScript.
     */
    protected static final String CL_WHITESPACE_ONLY = "WHITESPACE_ONLY";

    /**
     * Compilation Level: SIMPLE_OPTIMIZATIONS
     * Performs compression and optimization that does not interfere with the
     * interaction between the compiled JavaScript and other JavaScript. This
     * level renames only local variables.
     */
    protected static final String CL_SIMPLE_OPT = "SIMPLE_OPTIMIZATIONS";

    /**
     * Compilation Level: ADVANCED_OPTIMIZATIONS
     * Achieves the highest level of compression by renaming symbols in your
     * JavaScript. When using ADVANCED_OPTIMIZATIONS compilation you must
     * perform extra steps to preserve references to external symbols.
     */
    protected static final String CL_ADVANCED_OPT = "ADVANCED_OPTIMIZATIONS";

    /**
     * Output format: xml
     * The xml output format wraps the requested information in valid XML.
     */
    protected static final String OUTPUT_FORMAT_XML = "xml";

    /**
     * Output format: json
     * The json output format wraps the requested information in a JavaScript
     * Object Notation (JSON) string. Evaluation of this string as JavaScript
     * returns a JavaScript Object.
     */
    protected static final String OUTPUT_FORMAT_JSON = "json";

    /**
     * Output format: text
     * The text output format returns raw text without tags or JSON brackets. If
     * the output_info includes compiled_code, the text contains JavaScript. If
     * the output_info includes warnings, the text contains warning messages. If
     * the output_info includes statistics, the text contains statistics.
     */
    protected static final String OUTPUT_FORMAT_TEXT = "text";

    /**
     * Output info: compiled_code
     * A compressed and optimized version of your input JavaScript.
     */
    protected static final String OUTPUT_INFO_COMPILED_CODE = "compiled_code";

    /**
     * Output info: warnings
     * Messages that indicate possible bugs in your JavaScript.
     */
    protected static final String OUTPUT_INFO_WARNINGS = "warnings";

    /**
     * Output info: errors
     * Messages that indicate syntax errors or other errors in your JavaScript.
     */
    protected static final String OUTPUT_INFO_ERRORS = "errors";

    /**
     * Output info: statistics
     * Information about the degree of compression that the Closure Compiler
     * achieves.
     */
    protected static final String OUTPUT_INFO_STATISTICS = "statistics";

    /**
     * Standard constructor
     */
    public JSClosureCompilerHTTPService() {
    }

    /**
     * Builds the POST-Body for the Closure Compiler Service request.
     *
     * @param jsCode JavaScript code that should be compressed.
     * @param compilationLevel Compression/compilation level.
     * @param outputFormat The selected output format.
     * @param outputInfo The selected information.
     * @return The generated POST-Body string.
     */
    protected String buildPostData(String jsCode, String outputInfo) {
        final String charset = "UTF-8";
        StringBuffer sb = new StringBuffer();
        try {
            sb.append(URLEncoder.encode("compilation_level", charset));
            sb.append("=");
            sb.append(URLEncoder.encode(CL_SIMPLE_OPT, charset));
            sb.append("&");
            sb.append(URLEncoder.encode("output_format", charset));
            sb.append("=");
            sb.append(URLEncoder.encode(OUTPUT_FORMAT_XML, charset));
            sb.append("&");
            sb.append(URLEncoder.encode("output_info", charset));
            sb.append("=");
            sb.append(URLEncoder.encode(outputInfo, charset));
            sb.append("&");
            sb.append(URLEncoder.encode("js_code", charset));
            sb.append("=");
            sb.append(URLEncoder.encode(jsCode, charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Compresses the given JavaScript code with the Closure Compiler Service.
     * Errors will be prompted in the commanline.
     *
     * @see http://code.google.com/closure/compiler/
     * @param jsCode JavaScript code to be compressed
     * @return Compressed JavaScript code or given <code>jsCode</code> if any
     *         error occurs during compression.
     */
    public String compress(String jsCode) {
        String result = jsCode;
        try {
            String compressedCode = getCompressedCode(jsCode);
            if (compressedCode.length() != 0) {
                result = compressedCode;
            } else {
                if (log.isErrorEnabled()) {
                    ArrayList errors = getErrors(jsCode);
                    if (errors != null) {
                        StringBuffer eSB = new StringBuffer();
                        eSB.append(errors.size());
                        eSB.append(" JavaScript error(s):\n");
                        int cnt = 0;
                        for (Iterator it = errors.iterator(); it.hasNext(); ) {
                            eSB.append(++cnt);
                            eSB.append(".) ");
                            eSB.append((String) it.next());
                            eSB.append("\n\n");
                        }
                        log.error(eSB.toString());
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param jsCode
     * @return
     * @throws IOException
     */
    protected String getCompressedCode(String jsCode) throws IOException {
        String result = "";
        String response = doRawRequest(buildPostData(jsCode, OUTPUT_INFO_COMPILED_CODE));
        Document doc = parseXML(response);
        NodeList nl = doc.getElementsByTagName("compiledCode");
        if (nl.getLength() > 0) {
            result = ((Element) nl.item(0)).getTextContent();
        }
        return result;
    }

    /**
     * Uses the compression service to get some information of JavaScript
     * errors.
     *
     * @param jsCode JavaScript code that should be analyzed to find errors.
     * @return List of error messages (Strings) or null if no errors were found.
     * @throws IOException
     */
    protected ArrayList getErrors(String jsCode) throws IOException {
        ArrayList errors = null;
        String response = doRawRequest(buildPostData(jsCode, OUTPUT_INFO_ERRORS));
        Document doc = parseXML(response);
        NodeList nl = doc.getElementsByTagName("error");
        if (nl.getLength() > 0) {
            errors = new ArrayList();
            Element el = (Element) nl.item(0);
            StringBuffer eMsg = new StringBuffer();
            eMsg.append(el.getTextContent());
            eMsg.append(" at line ");
            eMsg.append(el.getAttribute("lineno"));
            eMsg.append(" character ");
            eMsg.append(el.getAttribute("charno"));
            eMsg.append("\n");
            eMsg.append(el.getAttribute("line"));
            eMsg.append("\n");
            for (int i = Integer.parseInt(el.getAttribute("charno")) - 1; i > 0; i--) {
                eMsg.append(" ");
            }
            eMsg.append("^");
            errors.add(eMsg.toString());
        }
        return errors;
    }

    /**
     * This method does the raw POST request to the Closure Compiler Service
     * interface.
     *
     * @param postData Aggregated and already encoded POST-Body
     * @return The response to the sent HTTP POST request.
     * @throws IOException
     */
    protected String doRawRequest(String postData) throws IOException {
        URL url = new URL(SERVICE_URL);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(postData);
        wr.flush();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        wr.close();
        rd.close();
        return sb.toString();
    }

    /**
     * Parses the given XML string and returns a W3C DOM document.
     *
     * @param xml String to transform into DOM document
     * @return W3C DOM document of given XML string
     */
    protected Document parseXML(String xml) {
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
