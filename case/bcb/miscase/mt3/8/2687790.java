package au.edu.qut.yawl.engine.interfce;

import au.edu.qut.yawl.authentication.User;
import au.edu.qut.yawl.elements.YAWLServiceReference;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 /**
 * 
 * @author Lachlan Aldred
 * Date: 16/04/2004
 * Time: 16:15:02
 * 
 */
public class InterfaceA_EnvironmentBasedClient extends Interface_Client {

    private String executeUpload(String urlStr, String specification, String filename, String sessionHandle) {
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("YAWLSessionHandle", sessionHandle);
            connection.setRequestProperty("filename", filename);
            connection.setRequestProperty("Content-Type", "text/xml");
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(specification);
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
            out.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            InterfaceBWebsideController.logContactError(e, _backEndURIStr);
        }
        String msg = result.toString();
        return stripOuterElement(msg);
    }

}
