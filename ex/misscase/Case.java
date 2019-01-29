public class Case{
    public static void main(String args[]) {
        Frame f = new Frame("SymbolTest");
        SymbolTest symbolTest = new SymbolTest();

        symbolTest.init();
        symbolTest.start();

        f.add("Center", symbolTest);
        f.pack();
        f.setSize(400, 500);
        f.show();

        f.addWindowListener(new MyAdapter());
    }

    public static void main(String args[]) {
        Frame f = new Frame("DitherTest");
        DitherTest	ditherTest = new DitherTest();

        ditherTest.init();

        f.add("Center", ditherTest);
        f.pack();
        f.show();

        ditherTest.start();
    }

    //2
    public String[][] getParameterInfo() {
        String[][] info = {
                {"model", "path string", "The path to the model to be displayed."},
                {"scale", "float", "The scale of the model.  Default is 1."}
        };
        return info;
    }
    public String[][] getParameterInfo() {
        String[][] info = {
                {"level", "int", "Maximum number of recursions.  Default is 1."},
                {"incremental","boolean","Whether or not to repaint between recursions.  Default is true."},
                {"delay","integer","Sets delay between repaints.  Default is 50."},
                {"startAngle","float","Sets the starting angle.  Default is 0."},
                {"rotAngle","float","Sets the rotation angle.  Default is 45."},
                {"border","integer","Width of border.  Default is 2."},
                {"normalizeScale","boolean","Whether or not to normalize the scaling.  Default is true."},
                {"pred","String","Initializes the rules for Context Sensitive L-Systems."},
                {"succ","String","Initializes the rules for Context Sensitive L-Systems."},
                {"lContext","String","Initializes the rules for Context Sensitive L-Systems."},
                {"rContext","String","Initializes the rules for Context Sensitive L-Systems."}
        };
        return info;
    }

    //3
    protected JMenu buildViewsMenu() {
        JMenu views = new JMenu("Views");

        JMenuItem inBox = new JMenuItem("Open In-Box");
        JMenuItem outBox = new JMenuItem("Open Out-Box");
        outBox.setEnabled(false);

        inBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openInBox();
            }});

        views.add(inBox);
        views.add(outBox);
        return views;
    }
    protected JMenu buildEditMenu() {
        JMenu edit = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem prefs = new JMenuItem("Preferences...");

        undo.setEnabled(false);
        copy.setEnabled(false);
        cut.setEnabled(false);
        paste.setEnabled(false);

        prefs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPrefsWindow();
            }});

        edit.add(undo);
        edit.addSeparator();
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(prefs);
        return edit;
    }
    //4
    public void init() {
        mdname = getParameter("model");
        try {
            scalefudge = Float.valueOf(getParameter("scale")).floatValue();
        }catch(Exception e){};
        amat.yrot(20);
        amat.xrot(20);
        if (mdname == null)
            mdname = "model.obj";
        resize(getSize().width <= 20 ? 400 : getSize().width,
                getSize().height <= 20 ? 400 : getSize().height);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void init() {
        mdname = getParameter("model");
        try {
            scalefudge = Float.valueOf(getParameter("scale")).floatValue();
        } catch(Exception e) {
        };
        amat.yrot(20);
        amat.xrot(20);
        if (mdname == null)
            mdname = "model.obj";
        resize(getSize().width <= 20 ? 400 : getSize().width,
                getSize().height <= 20 ? 400 : getSize().height);
        newBackBuffer();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //6
    public void actionPerformed(ActionEvent e) {
        JTextComponent target = getTextComponent(e);
        if (target != null) {
            Keymap map = target.getKeymap( keymapName );
            if( map != null )
                target.setKeymap( map );
        }
    }

    public void actionPerformed(ActionEvent e) {
        JTextComponent target = getTextComponent(e);
        if (target != null) {
            target.replaceSelection(s);
        }
    }
    //7
    public static void main(String args[]) {

/*****************
 DataTable dt = new JDBCAdapter(
 "jdbc:sybase://dbtest:1455/spring",
 // "SELECT * FROM test",
 "SELECT * FROM COFFEES",
 "connect.sybase.SybaseDriver",
 "guest",
 "trustworthy");
 ****************************/


        String url = "jdbc:sybase://dbtest:1455/spring";
        Connection con;
        Statement stmt;
        String query = "select SUP_NAME, SUP_ID from SUPPLIERS";

        try {
            Class.forName("connect.sybase.SybaseDriver");

        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url,
                    "guest", "trustworthy");

            stmt = con.createStatement();

            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(49, 'Superior Coffee', '1 Party Place', " +
                    "'Mendocino', 'CA', '95460')");

            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(101, 'Acme, Inc.', '99 Market Street', " +
                    "'Groundsville', 'CA', '95199')");

            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(150, 'The High Ground', '100 Coffee Lane', " +
                    "'Meadows', 'CA', '93966')");

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Suppliers and their ID Numbers:");
            while (rs.next()) {
                String s = rs.getString("SUP_NAME");
                int n = rs.getInt("SUP_ID");
                System.out.println(s + "   " + n);
            }

            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }


    public static void main(String args[]) {

/****************
 DataTable dt = new JDBCAdapter(
 "jdbc:sybase://dbtest:1455/spring",
 "SELECT * FROM test",
 "connect.sybase.SybaseDriver",
 "guest",
 "trustworthy");
 *******************************/

        String url = "jdbc:sybase://dbtest:1455/spring";
        Connection con;
        String createString;
        createString = "create table COFFEES " +
                "(COF_NAME varchar(32), " +
                "SUP_ID int, " +
                "PRICE float, " +
                "SALES int, " +
                "TOTAL int)";
        Statement stmt;

        try {
            Class.forName("connect.sybase.SybaseDriver");

        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url,
                    "guest", "trustworthy");

            stmt = con.createStatement();
            stmt.executeUpdate(createString);

            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

//8
    void init() {
        tracker = new MediaTracker(owner);
        currentFrame = 0;
        loadAnimationMedia();
        startPlaying();
    }
    public void mouseReleased(MouseEvent e) {
        cls = new ContextLSystem(this);
        savedPath = null;
        start();
        e.consume();
    }



}