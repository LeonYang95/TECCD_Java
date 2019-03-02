package org.openremote.controller.protocol.test.mockup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openremote.controller.command.ExecutableCommand;

/**
 * 
 * @author handy.wang 2010-03-18
 *
 */
public class MockupExecutableCommand extends MockupCommand implements ExecutableCommand {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void send() {
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(getUrl());
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                result.append(str);
            }
        } catch (ConnectException ce) {
            logger.error("MockupExecutableCommand excute fail: " + ce.getMessage());
        } catch (Exception e) {
            logger.error("MockupExecutableCommand excute fail: " + e.getMessage());
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
