public class Method{
    public Properties getProperties(Resource propertyResource)
            throws BuildException {
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = propertyResource.getInputStream();
            props.load(in);
        } catch (IOException e) {
            String message = "Property resource (" + propertyResource.getName() + ") cannot be loaded.";
            throw new BuildException(message);
        } finally {
            FileUtils.close(in);
        }

        return props;
    }
    protected Properties loadPropFile(String relativeFilename)
            throws IOException {
        File f = createRelativeFile(relativeFilename);
        Properties props=new Properties();
        InputStream in=null;
        try  {
            in=new BufferedInputStream(new FileInputStream(f));
            props.load(in);
        } finally {
            if(in!=null) {
                try { in.close(); } catch(IOException e) {}
            }
        }
        return props;
    }

}