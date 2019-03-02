package au.edu.ausstage.mapping;

import java.io.*;
import java.sql.*;
import java.net.*;

/**
 * A class to manage all aspects of the Geocoding process
 */
public class GeocodeManager {
    /**
	  * A method to take a URL and return the response
	  *
	  * @param url the url to fetch
	  *
	  * @returns   the content returned
	  */
    private String fetchURL(String url) {
        StringBuilder content = new StringBuilder();
        String line;
        BufferedReader input = null;
        try {
            URL urlToFetch = new URL(url);
            input = new BufferedReader(new InputStreamReader(urlToFetch.openStream()));
            while ((line = input.readLine()) != null) {
                content.append(line);
            }
            input.close();
            return content.toString();
        } catch (java.io.IOException ex) {
            return null;
        }
    }
}
