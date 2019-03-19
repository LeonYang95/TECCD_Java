public class Method{
    protected void xmlSaveProperties(Properties props,
                                     OutputStream os) throws IOException {
        // create XML document
        Document doc = getDocumentBuilder().newDocument();
        Element rootElement = doc.createElement(PROPERTIES);
        List sorted = sortProperties(props);
        // output properties
        Iterator iten = sorted.iterator();
        while (iten.hasNext()) {
            Tuple tuple = (Tuple) iten.next();
            Element propElement = doc.createElement(PROPERTY);
            propElement.setAttribute(ATTR_NAME, tuple.key);
            propElement.setAttribute(ATTR_VALUE, tuple.value);
            rootElement.appendChild(propElement);
        }

        Writer wri = null;
        try {
            wri = new OutputStreamWriter(os, "UTF8");
            wri.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            (new DOMElementWriter()).write(rootElement, wri, 0, "\t");
            wri.flush();
        } catch (IOException ioe) {
            throw new BuildException("Unable to write XML file", ioe);
        } finally {
            FileUtils.close(wri);
        }
    }

    private static void copyUsingFileChannels(final File sourceFile,
                                              final File destFile)
            throws IOException {

        final File parent = destFile.getParentFile();
        if (parent != null && !parent.isDirectory()
                && !(parent.mkdirs() || parent.isDirectory())) {
            throw new IOException("failed to create the parent directory"
                    + " for " + destFile);
        }

        FileInputStream in = null;
        FileOutputStream out = null;
        FileChannel srcChannel = null;
        FileChannel destChannel = null;

        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destFile);

            srcChannel = in.getChannel();
            destChannel = out.getChannel();

            long position = 0;
            final long count = srcChannel.size();
            while (position < count) {
                final long chunk = Math.min(MAX_IO_CHUNK_SIZE, count - position);
                position +=
                        destChannel.transferFrom(srcChannel, position, chunk);
            }
        } finally {
            FileUtils.close(srcChannel);
            FileUtils.close(destChannel);
            FileUtils.close(out);
            FileUtils.close(in);
        }
    }

}