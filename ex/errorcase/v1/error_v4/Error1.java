public class Error1{
    public static void unzip2(String strZipFile, String folder) throws IOException, ArchiveException {
        FileUtil.fileExists(strZipFile, true);
        final InputStream is = new FileInputStream(strZipFile);
        ArchiveInputStream in = new ArchiveStreamFactory().createArchiveInputStream("zip", is);
        ZipArchiveEntry entry = null;
        OutputStream out = null;
        while ((entry = (ZipArchiveEntry) in.getNextEntry()) != null) {
            File zipPath = new File(folder);
            File destinationFilePath = new File(zipPath, entry.getName());
            destinationFilePath.getParentFile().mkdirs();
            if (entry.isDirectory()) {
                continue;
            } else {
                out = new FileOutputStream(new File(folder, entry.getName()));
                IOUtils.copy(in, out);
                out.close();
            }
        }
        in.close();
    }

    public static String downloadWebpage2(String address) throws MalformedURLException, IOException {
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        HttpURLConnection.setFollowRedirects(true);
        String encoding = conn.getContentEncoding();
        InputStream is = null;
        if(encoding != null && encoding.equalsIgnoreCase("gzip")) {
            is = new GZIPInputStream(conn.getInputStream());
        } else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
            is = new InflaterInputStream(conn.getInputStream());
        } else {
            is = conn.getInputStream();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String page = "";
        while((line = br.readLine()) != null) {
            page += line + "\n";
        }
        br.close();
        return page;
    }


}