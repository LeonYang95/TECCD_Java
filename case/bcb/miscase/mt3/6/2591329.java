package vi.crawl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringEscapeUtils;
import vi.Doc;
import vi.Link;
import vi.Repository;

/**
 * @author Michal Laclavik
 *
 */
public class SimpleCrawler {

    private static String readURL(URL url) {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                s += str;
            }
            in.close();
        } catch (Exception e) {
            s = null;
        }
        return s;
    }

}
