public class Method{
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
    private void testNoRecreate(String secondTarget) {
        buildRule.executeTarget("test4");
        File jarFile = new File(getOutputDir(), tempJar);

        // move the modified date back a couple of seconds rather than delay the test on each run
        Assume.assumeTrue(jarFile.setLastModified(jarFile.lastModified()
                - (FileUtils.getFileUtils().getFileTimestampGranularity() * 3)));
        long jarModifiedDate = jarFile.lastModified();

        buildRule.executeTarget(secondTarget);
        assertEquals("jar has not been recreated in " + secondTarget,
                jarModifiedDate, jarFile.lastModified());
    }

}