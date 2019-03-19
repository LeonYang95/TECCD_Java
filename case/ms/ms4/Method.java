public class Method{
    public void testEmptyElementIfIsReference() {
        FileList f = new FileList();
        f.setDir(buildRule.getProject().resolveFile("."));
        try {
            f.setRefid(new Reference(buildRule.getProject(), "dummyref"));
            fail("Can add reference to FileList with directory attribute set.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }

        f = new FileList();
        f.setFiles("foo.xml,c/d/bar.xml");
        try {
            f.setRefid(new Reference(buildRule.getProject(), "dummyref"));
            fail("Can add reference to FileList with file attribute set.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }

        f = new FileList();
        f.setRefid(new Reference(buildRule.getProject(), "dummyref"));
        try {
            f.setFiles("a/b/foo.java");
            fail("Can set files in FileList that is a reference.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }
        try {
            f.setDir(buildRule.getProject().resolveFile("."));
            fail("Can set dir in FileList that is a reference.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }
    }
    public void testEmptyElementIfIsReference() {
        Mapper m = new Mapper(project);
        m.setFrom("*.java");
        try {
            m.setRefid(new Reference(project, "dummyref"));
            fail("Can add reference to Mapper with from attribute set");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }

        m = new Mapper(project);
        m.setRefid(new Reference(project, "dummyref"));
        try {
            m.setFrom("*.java");
            fail("Can set from in Mapper that is a reference.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }

        m = new Mapper(project);
        m.setRefid(new Reference(project, "dummyref"));
        try {
            m.setTo("*.java");
            fail("Can set to in Mapper that is a reference.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }
        try {
            Mapper.MapperType mt = new Mapper.MapperType();
            mt.setValue("glob");
            m.setType(mt);
            fail("Can set type in Mapper that is a reference.");
        } catch (BuildException be) {
            assertEquals("You must not specify more than one attribute when using refid",
                    be.getMessage());
        }
    }


}