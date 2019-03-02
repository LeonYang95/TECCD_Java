package se.kb.fedora.oreprovider.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class ResourceIndexServer {

    private String baseurl;

    public ResourceIndexServer(String baseurl) {
        this.baseurl = baseurl;
    }

    public List<String> query(String query) throws IOException {
        List<String> list = new LinkedList<String>();
        query = URLEncoder.encode(query, "UTF-8");
        String queryurl = baseurl + "?type=tuples&lang=itql&format=csv&query=" + query;
        URL url = new URL(queryurl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        reader.close();
        return list;
    }
}
