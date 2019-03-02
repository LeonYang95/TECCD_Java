package com.cantrill.ssofilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Util class
 * @author subin
 *
 */
public class SSOUtil {

    /**
	 * validate sessionid from cookie and get username if active . Else return "error" 
	 * @param sessionid
	 * @param servicekey
	 * @param request
	 * @return
	 */
    public static String validateSession(String sessionid, String servicekey, HttpServletRequest request) {
        if (sessionid == null) {
            return "error";
        }
        String loginapp = SSOFilter.getLoginapp();
        String u = SSOUtil.addParameter(loginapp + "/api/validatesessionid", "sessionid", sessionid);
        u = SSOUtil.addParameter(u, "servicekey", servicekey);
        u = SSOUtil.addParameter(u, "ip", request.getRemoteHost());
        u = SSOUtil.addParameter(u, "url", encodeUrl(request.getRequestURI()));
        u = SSOUtil.addParameter(u, "useragent", request.getHeader("User-Agent"));
        String response = "error";
        try {
            URL url = new URL(u);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response = line.trim();
            }
            reader.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        if ("error".equals(response)) {
            return "error";
        } else {
            return response;
        }
    }

    public static String getRolesString(HttpServletRequest hrequest, HttpServletResponse hresponse, String username, String servicekey) {
        String registerapp = SSOFilter.getRegisterapp();
        String u = SSOUtil.addParameter(registerapp + "/api/getroles", "username", username);
        u = SSOUtil.addParameter(u, "servicekey", servicekey);
        String roles = "";
        try {
            URL url = new URL(u);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                roles = line.trim();
            }
            reader.close();
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        if ("error".equals(roles)) {
            return "";
        }
        return roles.trim();
    }
}
