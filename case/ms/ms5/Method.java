public class Method{
    public void testFileList() {
        Path p = new Path(project);
        FileList f = new FileList();
        f.setProject(project);
        f.setDir(project.resolveFile("."));
        f.setFiles("build.xml");
        p.addFilelist(f);
        String[] l = p.list();
        assertEquals(1, l.length);
        assertEquals(project.resolveFile("build.xml").getAbsolutePath(), l[0]);
    }

    public void testOverwriteFalse() {
        buildRule.executeTarget("testSimpleScale");
        AntAssert.assertContains("Processing File", buildRule.getLog());
        File f = new File(buildRule.getOutputDir(), LARGEIMAGE);
        long lastModified = f.lastModified();
        buildRule.executeTarget("testOverwriteFalse");
        AntAssert.assertContains("Processing File", buildRule.getLog());
        f = new File(buildRule.getOutputDir(), LARGEIMAGE);
        long overwrittenLastModified = f.lastModified();
        assertTrue("File was overwritten.",
                lastModified == overwrittenLastModified);
    }
}