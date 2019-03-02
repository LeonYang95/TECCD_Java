package org.openremote.controller.protocol.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openremote.controller.event.Event;

/**
 * The Socket Event.
 *
 * @author Marcus 2009-4-26
 */
public class HttpGetEvent extends Event {

    @Override
    public void exec() {
        BufferedReader in = null;
        try {
            URL url = new URL(getUrl());
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer result = new StringBuffer();
            String str;
            while ((str = in.readLine()) != null) {
                result.append(str);
            }
            logger.info("received message: " + result);
        } catch (Exception e) {
            logger.error("HttpGetEvent could not execute", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("BufferedReader could not be closed", e);
                }
            }
        }
    }
}
