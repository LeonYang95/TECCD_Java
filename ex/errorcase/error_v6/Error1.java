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




}