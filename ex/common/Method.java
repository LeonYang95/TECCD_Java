public class Method{
    public void init() {
        setLayout(new BorderLayout());

        Panel panel = new Panel();

        panel.add(new Label("Font:"));
        Choice fontList = new Choice();

        String[] fontNames = getToolkit().getFontList();

        for (int i = 0; i < fontNames.length; i++) {
            fontList.addItem(fontNames[i]);
        }
        fontList.addItemListener(this);
        panel.add(fontList);
        Font defaultFont = new Font(fontNames[0], Font.PLAIN, 16);

        panel.add(new Label("Unicode base:"));
        baseText = new TextField(Integer.toHexString(DINGBAT_BASE), 4);
        baseText.setFont(new Font("Monospaced", Font.PLAIN, 12));
        baseText.addActionListener(this);
        panel.add(baseText);
        add("North", panel);

        ScrollPane sp = new ScrollPane();
        symbols = new SymbolCanvas(defaultFont, DINGBAT_BASE);
        sp.add(symbols);
        add("Center", sp);

        add("South", new Label("Symbols=0x2200, Dingbats=0x2700, Greek=0x0370"));
    }

    protected JMenu buildSpeedMenu() {
        JMenu speed = new JMenu("Drag");
        JRadioButtonMenuItem normal = new JRadioButtonMenuItem("Normal");
        JRadioButtonMenuItem fast = new JRadioButtonMenuItem("Fast");
        JRadioButtonMenuItem outline = new JRadioButtonMenuItem("Outline");

        ButtonGroup group = new ButtonGroup();
        group.add(normal);
        group.add(fast);
        group.add(outline);

        normal.setSelected(true);

        normal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                desktop.putClientProperty("JDesktopPane.dragMode", null);}});

        fast.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                desktop.putClientProperty("JDesktopPane.dragMode", "faster");}});

        outline.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                desktop.putClientProperty("JDesktopPane.dragMode", "outline");}});

        speed.add(normal);
        speed.add(fast);
        speed.add(outline);
        return speed;
    }







}