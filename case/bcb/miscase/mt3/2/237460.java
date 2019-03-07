package eu.annocultor.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

/**
 * Various utilities.
 * 
 * @author Borys Omelayenko
 * 
 */
public class Utils {

    public static String loadURLToString(String url, String EOL) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader((new URL(url)).openStream()));
        String result = "";
        String str;
        while ((str = in.readLine()) != null) {
            result += str + EOL;
        }
        in.close();
        return result;
    }
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
