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
}
