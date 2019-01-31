public class Error1{
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





}