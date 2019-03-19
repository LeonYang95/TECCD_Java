public class Method{
    private InputSource urlLookup(ResourceLocation matchingEntry) {
        String uri = matchingEntry.getLocation();
        URL baseURL = null;
        if (matchingEntry.getBase() != null) {
            baseURL = matchingEntry.getBase();
        } else {
            try {
                baseURL = FILE_UTILS.getFileURL(getProject().getBaseDir());
            } catch (MalformedURLException ex) {
                throw new BuildException("Project basedir cannot be converted to a URL");
            }
        }
        InputSource source = null;
        URL url = null;
        try {
            url = new URL(baseURL, uri);
        } catch (MalformedURLException ex) {
        }
        if (url != null) {
            try {
                InputStream is = null;
                URLConnection conn = url.openConnection();
                if (conn != null) {
                    conn.setUseCaches(false);
                    is = conn.getInputStream();
                }
                if (is != null) {
                    source = new InputSource(is);
                    String sysid = url.toExternalForm();
                    source.setSystemId(sysid);
                    log("catalog entry matched as a URL: '"
                            + sysid + "'", Project.MSG_DEBUG);
                }
            } catch (IOException ex) {
            }
        }
        return source;
    }



    public ClassFile getNextClassFile() {
        ZipEntry jarEntry;
        ClassFile nextElement = null;
        try {
            jarEntry = jarStream.getNextEntry();
            while (nextElement == null && jarEntry != null) {
                String entryName = jarEntry.getName();
                if (!jarEntry.isDirectory() && entryName.endsWith(".class")) {
                    ClassFile javaClass = new ClassFile();
                    javaClass.read(jarStream);
                    nextElement = javaClass;
                } else {
                    jarEntry = jarStream.getNextEntry();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            String text = e.getClass().getName();
            if (message != null) {
                text += ": " + message;
            }
            throw new BuildException("Problem reading JAR file: " + text);
        }
        return nextElement;
    }
}