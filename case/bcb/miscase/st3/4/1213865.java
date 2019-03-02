package com.m4f.alive;

import java.util.TimerTask;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AliveTask extends TimerTask {

    private static final Logger LOGGER = Logger.getLogger(AliveTask.class.getName());

    public void run() {
        try {
            URL url = new URL("http://mydiversite.appspot.com/version.html");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
