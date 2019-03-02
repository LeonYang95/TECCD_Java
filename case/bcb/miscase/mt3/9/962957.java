package org.cheetah.core.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.cheetah.core.ServiceContextDefinition;
import org.cheetah.core.ServiceDefinition;

public abstract class JAXBUtils {
    public static void addClasses(URL url) {
        BufferedReader reader = null;
        String line;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if ((line.length() == 0) || line.startsWith(";")) {
                    continue;
                }
                try {
                    classes.add(Class.forName(line, true, cl));
                } catch (Throwable t) {
                }
            }
        } catch (Throwable t) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable t) {
                }
            }
        }
    }

}
