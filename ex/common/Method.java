public class Method{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public static void main(String args[]) {
        Frame f = new Frame("CardTest");
        CardTest cardTest = new CardTest();
        cardTest.init();
        cardTest.start();

        f.add("Center", cardTest);
        f.setSize(300, 300);
        f.show();
    }

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

    private JMenuBar constructMenuBar() {
        JMenu            menu;
        JMenuBar         menuBar = new JMenuBar();
        JMenuItem        menuItem;

        /* Good ol exit. */
        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = menu.add(new JMenuItem("Exit"));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});

        /* Tree related stuff. */
        menu = new JMenu("Tree");
        menuBar.add(menu);

        menuItem = menu.add(new JMenuItem("Add"));
        menuItem.addActionListener(new AddAction());

        menuItem = menu.add(new JMenuItem("Insert"));
        menuItem.addActionListener(new InsertAction());

        menuItem = menu.add(new JMenuItem("Reload"));
        menuItem.addActionListener(new ReloadAction());

        menuItem = menu.add(new JMenuItem("Remove"));
        menuItem.addActionListener(new RemoveAction());

        return menuBar;
    }
}