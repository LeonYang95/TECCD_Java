public class Method{
    public void testRestrictedGlobMapper() {
        DependSelector s = new DependSelector();
        File subdir = new File(selectorRule.getBeddir(), "tar/bz2");
        s.setTargetdir(subdir);

        Mapper.MapperType glob = new Mapper.MapperType();
        glob.setValue("glob");

        Mapper m = s.createMapper();
        m.setType(glob);
        m.setFrom("*.bz2");
        m.setTo("*.tar.bz2");
        String results = selectorRule.selectionString(s);
        assertEquals("FFFFFFFFFTTF", results);
    }
    public void testContentsExcluded() {
        DirectoryScanner ds = new DirectoryScanner();
        ds.setBasedir(new File("."));
        ds.setIncludes(new String[] {"**"});
        ds.addDefaultExcludes();
        ds.ensureNonPatternSetsReady();
        File f = new File(".svn");
        TokenizedPath p = new TokenizedPath(f.getAbsolutePath());
        assertTrue(ds.contentsExcluded(p));
    }

}