public class Method{
    public void testCircularReferenceCheck() throws IOException, SAXException {

        // catalog <--> catalog
        project.addReference("catalog", catalog);
        catalog.setRefid(new Reference(project, "catalog"));

        try {
            InputSource result = catalog.resolveEntity("PUBLIC ID ONE",
                    "i/dont/exist.dtd");
            fail("Can make XMLCatalog a Reference to itself.");
        } catch (BuildException be) {
            assertEquals("This data type contains a circular reference.",
                    be.getMessage());
        } catch (Exception e) {
            fail("resolveEntity() failed!" + e.toString());
        }

        // catalog1 --> catalog2 --> catalog3 --> catalog1
        XMLCatalog catalog1 = newCatalog();
        project.addReference("catalog1", catalog1);
        XMLCatalog catalog2 = newCatalog();
        project.addReference("catalog2", catalog2);
        XMLCatalog catalog3 = newCatalog();
        project.addReference("catalog3", catalog3);

        catalog3.setRefid(new Reference(project, "catalog1"));
        catalog2.setRefid(new Reference(project, "catalog3"));
        catalog1.setRefid(new Reference(project, "catalog2"));

        try {
            catalog1.resolveEntity("PUBLIC ID ONE",
                    "i/dont/exist.dtd");
            fail("Can make circular reference");
        } catch (BuildException be) {
            assertEquals("This data type contains a circular reference.",
                    be.getMessage());
        }
    }

    public void releaseIsUsedForJava9() {
        LogCapturingJavac javac = new LogCapturingJavac();
        Project p = new Project();
        javac.setProject(p);
        javac.setCompiler("javac9");
        javac.setSource("6");
        javac.setTarget("6");
        javac.setRelease("6");
        javac.setSourcepath(new Path(p));
        SourceTargetHelperNoOverride sth = new SourceTargetHelperNoOverride();
        sth.setJavac(javac);
        Commandline cmd = new Commandline();
        sth.setupModernJavacCommandlineSwitches(cmd);
        assertContains("Ignoring source, target and bootclasspath as "
                + "release has been set", javac.getLog());
        String[] args = cmd.getCommandline();
        assertEquals(5, args.length);
        assertEquals("-classpath", args[0]);
        assertEquals("-g:none", args[2]);
        assertEquals("--release", args[3]);
        assertEquals("6", args[4]);
    }



}