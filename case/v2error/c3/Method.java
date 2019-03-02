public class Method{
    //两个方法检测, 距离很小, 在数据集里跑, 距离变大
    //两个方法检测: 7.413027320715823e-07
    //在数据集里跑: 1.0625333622813177e-06
    private boolean doFileWasRemoved(Vector entries, String line) {
        if (ignoreRemoved) {
            return false;
        }
        int index = line.indexOf(FILE_WAS_REMOVED);
        if (index == -1) {
            return false;
        }
// it is a removed file
        String filename = line.substring(0, index);
        String rev = null;
        int indexrev = line.indexOf(REVISION, index);
        if (indexrev != -1) {
            rev = line.substring(indexrev + REVISION.length());
        }
        CvsTagEntry entry = new CvsTagEntry(filename, null, rev);
        entries.addElement(entry);
        log(entry.toString(), Project.MSG_VERBOSE);
        return true;
    }

    private boolean doFileIsNew(Vector entries, String line) {
        int index = line.indexOf(FILE_IS_NEW);
        if (index == -1) {
            return false;
        }
// it is a new file
// set the revision but not the prevrevision
        String filename = line.substring(0, index);
        String rev = null;
        int indexrev = line.indexOf(REVISION, index);
        if (indexrev != -1) {
            rev = line.substring(indexrev + REVISION.length());
        }
        CvsTagEntry entry = new CvsTagEntry(filename, rev);
        entries.addElement(entry);
        log(entry.toString(), Project.MSG_VERBOSE);
        return true;
    }


}