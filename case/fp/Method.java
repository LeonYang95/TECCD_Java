public class Method{
    private Properties getProperties(Resource resource) {
        InputStream in = null;
        Properties props = new Properties();
        try {
            in = resource.getInputStream();
            props.load(in);
        } catch (IOException ioe) {
            if (getProject() != null) {
                getProject().log("getProperties failed, " + ioe.getMessage(), Project.MSG_ERR);
            } else {
                ioe.printStackTrace(); //NOSONAR
            }
        } finally {
            FileUtils.close(in);
        }
        return props;
    }
    private Properties getProperties(Resource resource) {
        InputStream in = null;
        Properties props = new Properties();
        try {
            in = resource.getInputStream();
            props.load(in);
        } catch (IOException ioe) {
            if (getProject() != null) {
                getProject().log("getProperties failed, " + ioe.getMessage(), Project.MSG_ERR);
            } else {
                ioe.printStackTrace(); //NOSONAR
            }
        } finally {
            FileUtils.close(in);
        }
        return props;
    }
}