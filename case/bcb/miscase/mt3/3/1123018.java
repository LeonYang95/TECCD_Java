package jmIrcWordGamesBot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.jibble.pircbot.DccFileTransfer;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;

public class JmIrcWordGamesBot extends PircBot {


    private void translate(String sender, String message) {
        StringTokenizer st = new StringTokenizer(message, " ");
        message = message.replaceFirst(st.nextToken(), "");
        String typeCode = st.nextToken();
        message = message.replaceFirst(typeCode, "");
        try {
            String data = URLEncoder.encode(message, "UTF-8");
            URL url = new URL("http://babelfish.altavista.com/babelfish/tr?doit=done&urltext=" + data + "&lp=" + typeCode);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                if (line.contains("input type=hidden name=\"q\"")) {
                    String[] tokens = line.split("\"");
                    sendMessage(sender, tokens[3]);
                }
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
        }
    }

}
