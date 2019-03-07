package gpsxml.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *  Connects to the given URL with the given request string and returns a String
 *  or stream.
 * @author PLAYER, Keith Ralph
 */
public class ServletConnector {

    public String getXML(String servletURL, String request) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String encodedRequest = URLEncoder.encode(request, "UTF-8");
            URL url = new URL(servletURL + request);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException ex) {
            return null;
        } catch (UnsupportedEncodingException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
        return stringBuffer.toString();
    }

}
