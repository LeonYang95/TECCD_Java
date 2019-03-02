public class Method{
    public void testOverwrite() throws Exception {
        File unusual = new File(System.getProperty("root"),
                "src/etc/testcases/util/unusual.properties");
        FileInputStream fis = new FileInputStream(unusual);
        LayoutPreservingProperties lpf = new LayoutPreservingProperties();
        lpf.load(fis);

        lpf.setProperty(" prop one ", "new one");
        lpf.setProperty("prop\ttwo", "new two");
        lpf.setProperty("prop\nthree", "new three");

        File tmp = File.createTempFile("tmp", "props");
        tmp.deleteOnExit();
        lpf.saveAs(tmp);

// and check that the resulting file looks okay
        String s = readFile(tmp);

        assertTrue(s.indexOf("\\ prop\\ one\\ =\\ \\ leading and"
                + " trailing spaces ") == -1);
        assertTrue(s.indexOf("\\ prop\\ one\\ =new one") > -1);
        assertTrue(s.indexOf("prop\\ttwo=contains\\ttab") == -1);
        assertTrue(s.indexOf("prop\\ttwo=new two") > -1);
        assertTrue(s.indexOf("prop\\nthree=contains\\nnewline") == -1);
        assertTrue(s.indexOf("prop\\nthree=new three") > -1);
    }
    public void testRemoveAtFrontWhenSizeEqualsCapacity() {
        v = new VectorSet(3, 1);
        v.add(O);
        Object a = new Object();
        v.add(a);
        Object b = new Object();
        v.add(b);
        assertEquals(3, v.size());
        assertEquals(3, v.capacity());
        assertTrue(v.remove(O));
        assertEquals(2, v.size());
        assertFalse(v.remove(O));
        assertSame(a, v.elementAt(0));
        assertSame(b, v.elementAt(1));
    }
}