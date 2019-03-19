public class Method{
    public void test3() {


        File file = new File(buildRule.getProject().getBaseDir(), tempFile);
        if (file.exists()) {
            file.delete();
        }
        buildRule.executeTarget("test3");
        assertTrue(file.exists());
    }

    protected Task makeTask(UnknownElement ue, RuntimeConfigurable w) {


        Task task = getProject().createTask(ue.getTag());
        if (task != null) {
            task.setLocation(getLocation());
            task.setOwningTarget(getOwningTarget());
            task.init();
        }
        return task;
    }



}