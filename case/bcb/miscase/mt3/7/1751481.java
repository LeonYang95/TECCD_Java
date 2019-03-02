package guestbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.String;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class parsingSites {
    public static String createStringFromHtml(MyUrl url) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.getUrl().openStream(), "UTF-8"));
            String line;
            String xmlAsString = "";
            while ((line = reader.readLine()) != null) {
                xmlAsString += line;
            }
            reader.close();
            return xmlAsString;
        } catch (Exception e) {
            return null;
        }
    }
}
