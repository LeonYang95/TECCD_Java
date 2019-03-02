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
    public void access() {
        Authenticator.setDefault(new MyAuthenticator());
        try {
            URL url = new URL("http://localhost/ws/test");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

}
