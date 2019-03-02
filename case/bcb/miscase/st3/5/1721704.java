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

    public String sendPOSTRequest(String URLstring) {
        String str = "";
        try {
            String data = URLEncoder.encode("data[User][username]", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
            data += "&" + URLEncoder.encode("data[User][password]", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");
            URL url = new URL(URLstring);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                str += line;
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
        }
        return str;
    }

    public void sendCookie(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Cookie", "User.username=tmblue; User.password=maleand");
            conn.connect();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

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

    public class MyAuthenticator extends Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            String promptString = getRequestingPrompt();
            String hostname = getRequestingHost();
            InetAddress ipaddr = getRequestingSite();
            int port = getRequestingPort();
            String username = "toan";
            String password = "nguyen";
            return new PasswordAuthentication(username, password.toCharArray());
        }
    }
}
