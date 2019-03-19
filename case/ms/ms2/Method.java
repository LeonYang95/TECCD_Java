public class Method{
    public void test1() {
        Assume.assumeTrue(loginFailureMessage, loginSuceeded);
        Assume.assumeTrue("Could not change remote directory", changeRemoteDir(remoteTmpDir));
        FTP.FTPDirectoryScanner ds = myFTPTask.newScanner(ftp);
        ds.setBasedir(new File(buildRule.getProject().getBaseDir(), "tmp"));
        ds.setIncludes(new String[] {"alpha"});
        ds.scan();
        compareFiles(ds, new String[] {} ,new String[] {"alpha"});



    }

    public void testParentDiffersInCaseScanningSensitive() {
        Assume.assumeTrue(loginFailureMessage, loginSuceeded);
        Assume.assumeTrue("Could not change remote directory", changeRemoteDir(remoteTmpDir));
        FTP.FTPDirectoryScanner ds = myFTPTask.newScanner(ftp);
        ds.setBasedir(new File(buildRule.getProject().getBaseDir(), "tmp"));
        ds.setIncludes(new String[] {"alpha"});
        ds.scan();
        compareFiles(ds, new String[] {"alpha/beta/beta.xml",
                        "alpha/beta/gamma/gamma.xml"},
                new String[] {"alpha", "alpha/beta", "alpha/beta/gamma"});
    }



}