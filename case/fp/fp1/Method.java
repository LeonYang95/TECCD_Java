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

    protected String runS(Commandline cmdline) {
        String   outV  = "opts.cc.runS.output" + pcnt++;
        ExecTask exe   = new ExecTask(this);
        Commandline.Argument arg = exe.createArg();

        exe.setExecutable(cmdline.getExecutable());
        arg.setLine(Commandline.toString(cmdline.getArguments()));
        exe.setOutputproperty(outV);
        exe.execute();

        return getProject().getProperty(outV);
    }


}