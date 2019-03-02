package org.openremote.controller.protocol.test.mockup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openremote.controller.command.ExecutableCommand;
import org.openremote.controller.command.StatusCommand;
import org.openremote.controller.component.EnumSensorType;

/**
 * A mockup command via HTTP.
 * 
 * @author handy.wang 2010-03-18
 *
 */
public class MockupCommand implements ExecutableCommand, StatusCommand {
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
