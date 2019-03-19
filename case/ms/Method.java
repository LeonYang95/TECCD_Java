public class Method{
    protected RecorderEntry getRecorder(String name, Project proj)
            throws BuildException {
        Object o = recorderEntries.get(name);
        RecorderEntry entry;

        if (o == null) {
            // create a recorder entry
            entry = new RecorderEntry(name);

            if (append == null) {
                entry.openFile(false);
            } else {
                entry.openFile(append.booleanValue());
            }
            entry.setProject(proj);
            recorderEntries.put(name, entry);
        } else {
            entry = (RecorderEntry) o;
        }
        return entry;
    }
}