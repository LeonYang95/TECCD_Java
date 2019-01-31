public class Error1{
    public void setSelection( String selection  ) {
        Enumeration e = group.getElements();

        while( e.hasMoreElements() ) {
            JRadioButton b = (JRadioButton)e.nextElement();
            if( b.getActionCommand().equals(selection) ) {
                b.setSelected(true);
            }
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();

        if (e.getPropertyName().equals(Action.NAME)) {
            String text = (String) e.getNewValue();
            menuItem.setText(text);
        } else if (propertyName.equals("enabled")) {
            Boolean enabledState = (Boolean) e.getNewValue();
            menuItem.setEnabled(enabledState.booleanValue());
        }
    }

    //2
    JPanel createLogo() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        ImageIcon logo = loadImageIcon("images/AboutSwing.jpg","Swing!");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.getAccessibleContext().setAccessibleName("Swing!");
        p.add(logoLabel, BorderLayout.CENTER);
        p.setBorder(new MatteBorder(6,6,6,6,SwingSet.sharedInstance().loadImageIcon("images/AboutBorder.gif","About Box Border"))
        );

        return p;
    }
    private JPanel buildAddressPanel() {
        JPanel p = new JPanel();
        p.setLayout( new LabeledPairLayout() );
        JLabel toLabel = new JLabel("To: ", JLabel.RIGHT);
        JTextField toField = new JTextField(25);
        p.add(toLabel, "label");
        p.add(toField, "field");
        JLabel subLabel = new JLabel("Subj: ", JLabel.RIGHT);
        JTextField subField = new JTextField(25);
        p.add(subLabel, "label");
        p.add(subField, "field");
        JLabel ccLabel = new JLabel("cc: ", JLabel.RIGHT);
        JTextField ccField = new JTextField(25);
        p.add(ccLabel, "label");
        p.add(ccField, "field");
        return p;
    }

    //3
    public String getExtension(File f) {
        if(f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if(i>0 && i<filename.length()-1) {
                return filename.substring(i+1).toLowerCase();
            };
        }
        return null;
    }
    public boolean accept(File f) {
        if(f != null) {
            if(f.isDirectory()) {
                return true;
            }
            String extension = getExtension(f);
            if(extension != null && filters.get(getExtension(f)) != null) {
                return true;
            };
        }
        return false;
    }
    //4
    public void itemStateChanged(ItemEvent e) {
        AbstractButton b = (AbstractButton) e.getSource();
        String label = b.getText();
        if(label.equals("Button")) {
            if(b.isSelected()) {
                button.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintButton = true;
            } else {
                button.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintButton = false;
            }
        } else if(label.equals("RadioButton")) {
            if(b.isSelected()) {
                radio.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintRadio = true;
            } else {
                radio.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintRadio = false;
            }
        } else if(label.equals("Checkbox")) {
            if(b.isSelected()) {
                check.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintCheck = true;
            } else {
                check.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintCheck = false;
            }
        } else if(label.equals("Slider")) {
            if(b.isSelected()) {
                slider.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintSlider = true;
            } else {
                slider.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintSlider = false;
            }
        } else if(label.equals("ScrollBar")) {
            if(b.isSelected()) {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintScrollBar = true;
            } else {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintScrollBar = false;
            }
        } else {
        }
    }

    public void itemStateChanged(ItemEvent e) {
        JRadioButtonMenuItem rb = (JRadioButtonMenuItem) e.getSource();
        if (rb.isSelected()) {
            String selected = rb.getText();
            ComponentOrientation orientation;
            if (selected.equals("Left To Right")) {
                orientation = ComponentOrientation.LEFT_TO_RIGHT;
            } else  {
                orientation = ComponentOrientation.RIGHT_TO_LEFT;
            }
            Container swingRoot = SwingSet.sharedInstance().getRootComponent();
            applyOrientation( swingRoot, orientation );
            fireActionPerformed(new ActionEvent(this,0,"OrientationChanged"));
            swingRoot.validate();
            swingRoot.repaint();
        }
    }

    //5
    public void itemStateChanged(ItemEvent e) {
        AbstractButton b = (AbstractButton) e.getSource();
        String label = b.getText();
        if(label.equals("Button")) {
            if(b.isSelected()) {
                button.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintButton = true;
            } else {
                button.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintButton = false;
            }
        } else if(label.equals("RadioButton")) {
            if(b.isSelected()) {
                radio.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintRadio = true;
            } else {
                radio.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintRadio = false;
            }
        } else if(label.equals("Checkbox")) {
            if(b.isSelected()) {
                check.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintCheck = true;
            } else {
                check.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintCheck = false;
            }
        } else if(label.equals("Slider")) {
            if(b.isSelected()) {
                slider.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintSlider = true;
            } else {
                slider.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintSlider = false;
            }
        } else if(label.equals("ScrollBar")) {
            if(b.isSelected()) {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintScrollBar = true;
            } else {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintScrollBar = false;
            }
        } else {
        }
    }

    public void actionPerformed(ActionEvent e) {
        JCheckBox cb = (JCheckBox) e.getSource();
        String label = cb.getText();
        if(!cb.isSelected()) {

            if(label.equals("Fast Food")) {
                fastfoodShown = false;
                for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                    model.removeElementAt(fastfoodIndex);
                }
                fastfoodRadioButton.setEnabled(false);
                dessertIndex -= 5;
                fruitIndex -= 5;
                veggieIndex -= 5;
                scrollPane.validate();
            } else if(label.equals("Desserts")) {
                for(int i = dessertIndex; i < dessertIndex+5; i++) {
                    model.removeElementAt(dessertIndex);
                }
                dessertRadioButton.setEnabled(false);
                fruitIndex -= 5;
                veggieIndex -= 5;
                scrollPane.validate();
            } else if(label.equals("Fruits")) {
                for(int i = fruitIndex; i < fruitIndex+5; i++) {
                    model.removeElementAt(fruitIndex);
                }
                fruitRadioButton.setEnabled(false);
                veggieIndex -= 5;
                scrollPane.validate();
            } else if(label.equals("Vegetables")) {
                for(int i = veggieIndex; i < veggieIndex+5; i++) {
                    model.removeElementAt(veggieIndex);
                }
                veggieRadioButton.setEnabled(false);
                scrollPane.validate();
            }
            if(model.getSize() < 1)
                listBox.getParent().repaint();
        } else {
            if(label.equals("Fast Food")) {
                model.insertElementAt(new Integer(4), 0);
                model.insertElementAt(new Integer(3), 0);
                model.insertElementAt(new Integer(2), 0);
                model.insertElementAt(new Integer(1), 0);
                model.insertElementAt(new Integer(0), 0);
                dessertIndex += 5;
                fruitIndex += 5;
                veggieIndex += 5;
                fastfoodRadioButton.setEnabled(true);
                scrollPane.validate();
            } else if(label.equals("Desserts")) {
                model.insertElementAt(new Integer(9), dessertIndex);
                model.insertElementAt(new Integer(8), dessertIndex);
                model.insertElementAt(new Integer(7), dessertIndex);
                model.insertElementAt(new Integer(6), dessertIndex);
                model.insertElementAt(new Integer(5), dessertIndex);
                fruitIndex += 5;
                veggieIndex += 5;
                dessertRadioButton.setEnabled(true);
                scrollPane.validate();
            } else if(label.equals("Fruits")) {
                model.insertElementAt(new Integer(14), fruitIndex);
                model.insertElementAt(new Integer(13), fruitIndex);
                model.insertElementAt(new Integer(12), fruitIndex);
                model.insertElementAt(new Integer(11), fruitIndex);
                model.insertElementAt(new Integer(10), fruitIndex);
                veggieIndex += 5;
                fruitRadioButton.setEnabled(true);
                scrollPane.validate();
            } else if(label.equals("Vegetables")) {
                model.insertElementAt(new Integer(19), veggieIndex);
                model.insertElementAt(new Integer(18), veggieIndex);
                model.insertElementAt(new Integer(17), veggieIndex);
                model.insertElementAt(new Integer(16), veggieIndex);
                model.insertElementAt(new Integer(15), veggieIndex);
                veggieRadioButton.setEnabled(true);
                scrollPane.validate();
            }
        }
    }

    //6
    public void itemStateChanged(ItemEvent e) {
        AbstractButton b = (AbstractButton) e.getSource();
        String label = b.getText();
        if(label.equals("Button")) {
            if(b.isSelected()) {
                button.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintButton = true;
            } else {
                button.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintButton = false;
            }
        } else if(label.equals("RadioButton")) {
            if(b.isSelected()) {
                radio.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintRadio = true;
            } else {
                radio.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintRadio = false;
            }
        } else if(label.equals("Checkbox")) {
            if(b.isSelected()) {
                check.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintCheck = true;
            } else {
                check.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintCheck = false;
            }
        } else if(label.equals("Slider")) {
            if(b.isSelected()) {
                slider.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintSlider = true;
            } else {
                slider.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintSlider = false;
            }
        } else if(label.equals("ScrollBar")) {
            if(b.isSelected()) {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
                repaintScrollBar = true;
            } else {
                scrollbar.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
                repaintScrollBar = false;
            }
        } else {
        }
    }

    public void itemStateChanged(ItemEvent e) {

        JRadioButtonMenuItem rb = (JRadioButtonMenuItem) e.getSource();
        if (rb.isSelected()) {
            String selected = rb.getText();
            ComponentOrientation orientation;
            if (selected.equals("Left To Right")) {
                orientation = ComponentOrientation.LEFT_TO_RIGHT;
            } else  {
                orientation = ComponentOrientation.RIGHT_TO_LEFT;
            }
            Container swingRoot = SwingSet.sharedInstance().getRootComponent();
            applyOrientation( swingRoot, orientation );
            fireActionPerformed(new ActionEvent(this,0,"OrientationChanged"));
            swingRoot.validate();
            swingRoot.repaint();
        }

    }

    //7
    public void addCustomEntriesToTable(UIDefaults table) {
        super.addCustomEntriesToTable(table);

        final int internalFrameIconSize = 30;
        table.put("InternalFrame.closeIcon", MetalIconFactory.getInternalFrameCloseIcon(internalFrameIconSize));
        table.put("InternalFrame.maximizeIcon", MetalIconFactory.getInternalFrameMaximizeIcon(internalFrameIconSize));
        table.put("InternalFrame.iconizeIcon", MetalIconFactory.getInternalFrameMinimizeIcon(internalFrameIconSize));
        table.put("InternalFrame.minimizeIcon", MetalIconFactory.getInternalFrameAltMaximizeIcon(internalFrameIconSize));


        Border blackLineBorder = new BorderUIResource( new MatteBorder( 2,2,2,2, Color.black) );
        Border textBorder = blackLineBorder;

        table.put( "ToolTip.border", blackLineBorder);
        table.put( "TitledBorder.border", blackLineBorder);


        table.put( "TextField.border", textBorder);
        table.put( "PasswordField.border", textBorder);
        table.put( "TextArea.border", textBorder);
        table.put( "TextPane.font", textBorder);

        table.put( "ScrollPane.border", blackLineBorder);

        table.put( "ScrollBar.width", new Integer(25) );



    }

    void createStyles() {
// no attributes defined
        Style s = styles.addStyle(null, null);
        runAttr.put("none", s);
        s = styles.addStyle(null, null);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s, new Color(153,153,102));
        runAttr.put("cquote", s); // catepillar quote

        s = styles.addStyle(null, null);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s, new Color(51,102,153));
        runAttr.put("aquote", s); // alice quote

        try {
            ResourceBundle resources = ResourceBundle.getBundle("resources.Stylepad",
                    Locale.getDefault());
            s = styles.addStyle(null, null);
            Icon alice = new ImageIcon(resources.getString("aliceGif"));
            StyleConstants.setIcon(s, alice);
            runAttr.put("alice", s); // alice

            s = styles.addStyle(null, null);
            Icon caterpillar = new ImageIcon(resources.getString("caterpillarGif"));
            StyleConstants.setIcon(s, caterpillar);
            runAttr.put("caterpillar", s); // caterpillar

            s = styles.addStyle(null, null);
            Icon hatter = new ImageIcon(resources.getString("hatterGif"));
            StyleConstants.setIcon(s, hatter);
            runAttr.put("hatter", s); // hatter


        } catch (MissingResourceException mre) {
// can't display image
        }

        Style def = styles.getStyle(StyleContext.DEFAULT_STYLE);

        Style heading = styles.addStyle("heading", def);
        StyleConstants.setFontFamily(heading, "SansSerif");
        StyleConstants.setBold(heading, true);
        StyleConstants.setAlignment(heading, StyleConstants.ALIGN_CENTER);
        StyleConstants.setSpaceAbove(heading, 10);
        StyleConstants.setSpaceBelow(heading, 10);
        StyleConstants.setFontSize(heading, 18);

// Title
        Style sty = styles.addStyle("title", heading);
        StyleConstants.setFontSize(sty, 32);

// edition
        sty = styles.addStyle("edition", heading);
        StyleConstants.setFontSize(sty, 16);

// author
        sty = styles.addStyle("author", heading);
        StyleConstants.setItalic(sty, true);
        StyleConstants.setSpaceBelow(sty, 25);

// subtitle
        sty = styles.addStyle("subtitle", heading);
        StyleConstants.setSpaceBelow(sty, 35);

// normal
        sty = styles.addStyle("normal", def);
        StyleConstants.setLeftIndent(sty, 10);
        StyleConstants.setRightIndent(sty, 10);
        StyleConstants.setFontFamily(sty, "SansSerif");
        StyleConstants.setFontSize(sty, 14);
        StyleConstants.setSpaceAbove(sty, 4);
        StyleConstants.setSpaceBelow(sty, 4);
    }
//8
static void isWon(int pos) {
    for (int i = 0 ; i < DONE ; i++) {
        if ((i & pos) == pos) {
            won[i] = true;
        }
    }
}

void sort(int a[]) throws Exception {
    for (int i = a.length; --i>=0; ) {
        boolean swapped = false;
        for (int j = 0; j<i; j++) {
            if (stopRequested) {
                return;
            }
            if (a[j] > a[j+1]) {
                int T = a[j];
                a[j] = a[j+1];
                a[j+1] = T;
                swapped = true;
            }
            pause(i,j);
        }
        if (!swapped)
            return;
    }
}



}