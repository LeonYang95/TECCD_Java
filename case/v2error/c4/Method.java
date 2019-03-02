public class Method{
    public void testInfinite() {
        String result = "@test@ line testvalue";
        String line = "@test@ line @test3@";
        FilterSet fs = new FilterSet();
        fs.addFilter("test", "@test1@");
        fs.addFilter("test1","@test2@");
        fs.addFilter("test2", "@test@");
        fs.addFilter("test3", "testvalue");
        fs.setBeginToken("@");
        fs.setEndToken("@");
        assertEquals(result, fs.replaceTokens(line));
    }

    public void ownedByIsTrueForSelf() throws Exception {
        Assume.assumeFalse(Os.isFamily("windows"));
        String self = System.getProperty("user.name");
        File file = folder.newFile("f.txt");
        UserPrincipal user = Files.getOwner(file.toPath());
        assertEquals(self, user.getName());
        OwnedBySelector s = new OwnedBySelector();
        s.setOwner(self);
        assertTrue(s.isSelected(null, null, file));
    }

}