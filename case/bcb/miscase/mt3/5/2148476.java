package org.yehongyu.websale.common.networker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ����˵������ݴ���URL�õ���ҳԭ����Ϣ����
 * @author yehongyu.org
 * @version 1.0 Dec 4, 2007 11:56:51 PM
 */
public class UrlSession {

    /**
     * �������ܡ����ҳ��Դ��(����������ISO-8859-1���봦��)
     * @param urlString ҳ���ַ
     * @return String ҳ��Դ��
     */
    public String getHtmlCode(String urlString) {
        StringBuffer result = new StringBuffer();
        BufferedReader in = null;
        try {
            URL url = new URL((urlString));
            URLConnection con = url.openConnection();
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "ISO-8859-1"));
            String line = null;
            while ((line = in.readLine()) != null) {
                result.append(line + "\r\n");
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Unable to connect to URL: " + urlString);
        } catch (IOException e) {
            System.out.println("IOException when connecting to URL: " + urlString);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {
                    System.out.println("Exception throws at finally close reader when connecting to URL: " + urlString);
                }
            }
        }
        return result.toString();
    }

}
