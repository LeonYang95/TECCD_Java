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

    public void testCreatePropertiesCacheViaCustomSelector() {
        File cachefile = FILE_UTILS.createTempFile("tmp-cache-", ".properties", null, false, false);
        ExtendSelector s = new ExtendSelector();
        s.setClassname("org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector");
        s.addParam(createParam("update", "true"));
        s.addParam(createParam("cache.cachefile", cachefile.getAbsolutePath()));
        s.addParam(createParam("cache", "propertyfile"));
        selectorRule.selectionString(s);
        assertTrue("Cache file is not created.", cachefile.exists());
        cachefile.delete();

    }


}