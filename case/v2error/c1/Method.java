public class Method{
    public void testPreserveEscapeName() throws Exception {
        LayoutPreservingProperties lpf = new LayoutPreservingProperties();
        File unusual = new File(System.getProperty("root"),
                "src/etc/testcases/util/unusual.properties");
        FileInputStream fis = new FileInputStream(unusual);
        lpf.load(fis);

        lpf.setProperty("prop:seven", "new value for seven");
        lpf.setProperty("prop=eight", "new value for eight");
        lpf.setProperty("prop eleven", "new value for eleven");

        lpf.setProperty("alpha", "new value for alpha");
        lpf.setProperty("beta", "new value for beta");

        File tmp = File.createTempFile("tmp", "props");
        tmp.deleteOnExit();
        lpf.saveAs(tmp);

// and check that the resulting file looks okay
        String s = readFile(tmp);

        assertTrue(s.indexOf("prop\\:seven=new value for seven") > -1);
        assertTrue(s.indexOf("prop\\=eight=new value for eight") > -1);
        assertTrue(s.indexOf("prop\\ eleven=new value for eleven") > -1);
        assertTrue(s.indexOf("alpha=new value for alpha") > -1);
        assertTrue(s.indexOf("beta=new value for beta") > -1);

        assertTrue(s.indexOf("prop\\:seven=contains\\:colon") == -1);
        assertTrue(s.indexOf("prop\\=eight=contains\\=equals") == -1);
        assertTrue(s.indexOf("alpha:set with a colon") == -1);
        assertTrue(s.indexOf("beta set with a space") == -1);
    }

    private void printUnknownDefinition(PrintWriter out, String componentName, String dirListing) {
        boolean isAntlib = componentName.startsWith(MagicNames.ANTLIB_PREFIX);
        String uri = ProjectHelper.extractUriFromComponentName(componentName);
        out.println("Cause: The name is undefined.");
        out.println("Action: Check the spelling.");
        out.println("Action: Check that any custom tasks/types have been declared.");
        out.println("Action: Check that any <presetdef>/<macrodef>"
                + " declarations have taken place.");
        if (uri.length() > 0) {
            final List<AntTypeDefinition> matches = findTypeMatches(uri);
            if (matches.size() > 0) {
                out.println();
                out.println("The definitions in the namespace " + uri + " are:");
                for (AntTypeDefinition def : matches) {
                    String local = ProjectHelper.extractNameFromComponentName(def.getName());
                    out.println("    " + local);
                }
            } else {
                out.println("No types or tasks have been defined in this namespace yet");
                if (isAntlib) {
                    out.println();
                    out.println("This appears to be an antlib declaration. ");
                    out.println("Action: Check that the implementing library exists in one of:");
                    out.println(dirListing);
                }
            }
        }
    }


}