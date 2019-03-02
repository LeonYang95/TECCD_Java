package jimo.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import jimo.impl.agents.ChatBot;
import jimo.impl.common.Constants;
import jimo.impl.common.UtilXMLReader;
import jimo.spi.log.LogUtil;

/**
 * TODO Introduce Thread and JIMOContainer as Thread Container
 * @author <a href="mailto:wgdo@msn.com">Mark</a>
 */
public class JIMO {

    public final String latestVersion() {
        String latestVersion = "";
        try {
            URL url = new URL(Constants.officialSite + ":80/LatestVersion");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                latestVersion = str;
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return latestVersion;
    }
}
