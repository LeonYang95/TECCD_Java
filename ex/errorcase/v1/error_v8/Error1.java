public class Error1{
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





}