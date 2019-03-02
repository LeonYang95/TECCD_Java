package client;

import changeServerPackage.ChangeCapsule;
import changeServerPackage.ApplyChangesServlet;
import java.net.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.vocab.OWLRDFVocabulary;
import fileManagerPackage.TagReader;

/**
 * Created by IntelliJ IDEA.
 * User: candidasa
 * Date: Feb 8, 2008
 * Time: 4:00:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectorClient {

    public static final String SERVERPROTOCOL = "http://";

    public static final String SERVERPORT = ":8080";

    public static final String SERVERCONTEXT = "/ChangeServer";

    protected URL serverURL;

    protected String serverBase;

    /** creates a new client connecting to a specific server hostname or IP-address (only the
     * hostname needs to be passed in, the methods adds the protocol, port, mapping, etc */
    public ConnectorClient(String serverHostname) throws MalformedURLException {
        String server = serverHostname;
        if (!serverHostname.startsWith(SERVERPROTOCOL)) server = SERVERPROTOCOL + server;
        this.serverBase = server + SERVERPORT;
        this.serverURL = new URL(server + SERVERPORT + SERVERCONTEXT);
    }

    /** Sends a capsule full of changes to the server and returns the response string */
    public String sendChangeToServer(ChangeCapsule changeCapsule) throws IOException {
        if (!changeCapsule.empty()) {
            return issueCommandToServer(ApplyChangesServlet.COMMIT, changeCapsule);
        } else {
            return "Error: no changes to send.";
        }
    }

    /** Sends a specific command and changecapsule to server and returns the result */
    protected String issueCommandToServer(String command, ChangeCapsule changeCapsule) throws IOException {
        URLConnection urlConn = serverURL.openConnection();
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        OutputStreamWriter wr = new OutputStreamWriter(urlConn.getOutputStream());
        String content = ApplyChangesServlet.PARAMETER_COMMAND + "=" + command;
        content += "&" + ApplyChangesServlet.PARAMETER_CAPSULE + "=" + URLEncoder.encode(changeCapsule.toJSON(), "UTF-8");
        wr.write(content);
        wr.flush();
        BufferedReader input = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        StringBuffer response = new StringBuffer();
        String str;
        while (null != ((str = input.readLine()))) {
            response.append(str);
        }
        wr.close();
        input.close();
        return response.toString();
    }

    /** returns the base hostname and port of the server */
    public String getServerBase() {
        return serverBase;
    }

    /** read the change sequence number of an ontology */
    protected Long getOntologySequenceNumber(OWLOntology ontology) {
        Long number = null;
        Set<OWLOntologyAnnotationAxiom> allAnnotations = ontology.getOntologyAnnotationAxioms();
        for (OWLOntologyAnnotationAxiom annotation : allAnnotations) {
            if (annotation.getAnnotation().getAnnotationURI().compareTo(OWLRDFVocabulary.OWL_VERSION_INFO.getURI()) == 0) {
                if (annotation.getAnnotation().getAnnotationValue() instanceof OWLConstant) {
                    String literal = ((OWLConstant) annotation.getAnnotation().getAnnotationValue()).getLiteral();
                    if (literal.startsWith(TagReader.CHANGEAXIOMPREFIX)) {
                        number = new Long(literal.substring(TagReader.CHANGEAXIOMPREFIX.length()));
                    }
                }
            }
        }
        return number;
    }
}
