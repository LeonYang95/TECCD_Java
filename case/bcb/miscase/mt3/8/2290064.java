package au.edu.qut.yawl.engine.interfce;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 * @author Lachlan Aldred
 * Date: 22/03/2004
 * Time: 17:49:42
 * 
 */
public class Interface_Client {

    public static String executePost(String urlStr, Map paramsMap) throws IOException {
        StringBuffer result = new StringBuffer();
        HttpURLConnection connection = null;
        URL url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        Iterator paramKeys = paramsMap.keySet().iterator();
        while (paramKeys.hasNext()) {
            String paramName = (String) paramKeys.next();
            out.print(paramName + "=" + paramsMap.get(paramName));
            if (paramKeys.hasNext()) {
                out.print('&');
            }
        }
        out.flush();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();
        out.close();
        connection.disconnect();
        String msg = result.toString();
        return stripOuterElement(msg);
    }
}
