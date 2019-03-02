package games.midhedava.client.gui;

import games.midhedava.client.sprite.SpriteStore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 * Displays a credits dialog box
 */
public class CreditsDialog extends JDialog {

    private List<String> readCredits() {
        URL url = SpriteStore.get().getResourceURL("games/midhedava/client/gui/credits.txt");
        List<String> res = new LinkedList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = br.readLine();
            while (line != null) {
                res.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            res.add(0, "credits.txt not found");
        }
        return res;
    }

}
