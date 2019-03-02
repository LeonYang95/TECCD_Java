public class Method{
    public final String latestVersion() {
        try {
            int a;
            String encodedRequest = URLEncoder.encode(request, "UTF-8");
            URL url = new URL(servletURL + request);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException ex) {
            return null;
        }
    }
    public final String latestVersion() {
        try {
            float b;
            String encodedRequest = URLEncoder.encode(request, "UTF-8");
            URL url = new URL(servletURL + request);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException ex) {
            return null;
        }
    }



}