package net.allblog.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import net.allblog.testbed.FeedAnalyst;
import net.allblog.testbed.SearchUtil;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.io.FeedException;

/**
 * 
 * @author zannavi
 *
 */
public class LoadSpeedChecker {

    public int doCheck(URL url) throws IOException {
        long start = (System.currentTimeMillis());
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        }
        in.close();
        long end = (System.currentTimeMillis());
        return (int) (end - start);
    }
}
