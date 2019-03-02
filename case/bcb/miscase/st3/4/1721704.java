package testws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;

/**
 *
 * @author Tmblue
 */
public class webservice {

    public String getResponse(String URLstring) {
        String str = "";
        try {
            URL url = new URL(URLstring);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String st = "";
            while ((st = in.readLine()) != null) {
                str += "\n" + st;
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return str;
    }


}
