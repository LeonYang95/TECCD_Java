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

    private static final long serialVersionUID = 4312205320503928411L;

    private static final Logger logger = Logger.getLogger(CreditsDialog.class);

    private ScrollerPanel sp;

    private JPanel buttonPane = new JPanel();

    private JButton closeButton = new JButton("Close");

    private Color backgroundColor = Color.white;

    private Font textFont = new Font("SansSerif", Font.BOLD, 12);

    private Color textColor = new Color(85, 85, 85);

    /**
	 * creates a new credits dialog
	 *
	 * @param owner owner window
	 */
    public CreditsDialog(Frame owner) {
        super(owner, true);
        initGUI(owner);
        logger.debug("about dialog initialized");
        eventHandling();
        logger.debug("about dialog event handling ready");
        this.setTitle("Midhedava Credits");
        if (owner != null) {
            this.setLocationRelativeTo(owner);
            this.setSize(owner.getSize());
        } else {
            this.setLocationByPlatform(true);
            this.setSize(600, 420);
        }
        this.setVisible(true);
    }

    private void initGUI(Frame owner) {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(backgroundColor);
        List<String> creditsList = readCredits();
        String[] credits = creditsList.toArray(new String[creditsList.size()]);
        sp = new ScrollerPanel(credits, textFont, 0, textColor, backgroundColor, 20);
        buttonPane.setOpaque(false);
        buttonPane.add(closeButton);
        this.getContentPane().add(sp, BorderLayout.CENTER);
        this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    /**
	 * Reads the credits from credits.text
	 *
	 * @return list of lines
	 */
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

    /**
	 * setting up the listeners an event handling
	 */
    private void eventHandling() {
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    /**
	 * exit Credits Dialog
	 */
    protected void exit() {
        sp.stop();
        this.setVisible(false);
        this.dispose();
        logger.debug("about dialog closed");
    }
}
