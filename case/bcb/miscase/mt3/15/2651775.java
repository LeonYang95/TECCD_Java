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
}
