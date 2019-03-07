public class Method{
    public Properties getProperties(Resource propertyResource)
            throws BuildException {
        Properties props = new Properties();

        InputStream in = null;
        try {
            in = propertyResource.getInputStream();
            props.load(in);
        } catch (IOException e) {
            String message = "Property resource (" + propertyResource.getName()
                    + ") cannot be loaded.";
            throw new BuildException(message);
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