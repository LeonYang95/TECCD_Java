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

    /**
	 * call an api in sso system. 
	 * @param api
	 * @param paramname
	 * @param paramvalue
	 * @return
	 */
    public static String callApi(String api, String paramname, String paramvalue) {
        String loginapp = SSOFilter.getLoginapp();
        String u = SSOUtil.addParameter(loginapp + "/api/" + api, paramname, paramvalue);
        u = SSOUtil.addParameter(u, "servicekey", SSOFilter.getServicekey());
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

    /**
	 * validate authticket and get corresponding session id
	 * @param request
	 * @param servicekey
	 * @return
	 */
    public static String validateAuthTicketAndGetSessionId(ServletRequest request, String servicekey) {
        String loginapp = SSOFilter.getLoginapp();
        String authticket = request.getParameter("authticket");
        String u = SSOUtil.addParameter(loginapp + "/api/validateauthticket", "authticket", authticket);
        u = SSOUtil.addParameter(u, "servicekey", servicekey);
        String sessionid = null;
        try {
            URL url = new URL(u);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sessionid = line.trim();
            }
            reader.close();
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        if ("error".equals(sessionid)) {
            return null;
        }
        return sessionid;
    }

    private static Logger log = Logger.getLogger(SSOUtil.class.getName());

    /**
	 * get latest session id from request cookie
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
    public static String getSessionIdFromCookie(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            throw new Exception("no cookies found");
        }
        List<Cookie> sessioncookie = new ArrayList<Cookie>();
        for (Cookie cookie : cookies) {
            if (SSOFilter.COOKIENAME.equals(cookie.getName())) {
                sessioncookie.add(cookie);
            }
        }
        Cookie session = null;
        for (Cookie c : sessioncookie) {
            if (session == null) {
                session = c;
                continue;
            }
            if (getTimeStamp(c) > getTimeStamp(session)) {
                String response = SSOUtil.callApi("invalidatesession", "sessionid", session.getValue());
                if (!"success".equals(response)) {
                    log.info("could not invalidate session with id " + session.getValue());
                }
                session = c;
            }
        }
        return session.getValue();
    }

    public static Long getTimeStamp(Cookie c) {
        String value = c.getValue();
        String timeval = value.substring(value.length() - 13);
        Long timestamp = Long.parseLong(timeval);
        return timestamp;
    }

    /**
	 * add parameter to a url
	 * @param URL
	 * @param name
	 * @param value
	 * @return
	 */
    public static String addParameter(String URL, String name, String value) {
        int qpos = URL.indexOf('?');
        int hpos = URL.indexOf('#');
        char sep = qpos == -1 ? '?' : '&';
        String seg = sep + encodeUrl(name) + '=' + encodeUrl(value);
        return hpos == -1 ? URL + seg : URL.substring(0, hpos) + seg + URL.substring(hpos);
    }

    /**
	 * encode a string so that it can be used in url query string
	 * @param url
	 * @return
	 */
    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            throw new IllegalArgumentException(uee);
        }
    }

    /**
	 * decode a url encoded string to its utf-8 vallue
	 * @param url
	 * @return
	 */
    public static String decodeUrl(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            throw new IllegalArgumentException(uee);
        }
    }

    /**
	 * get roles of a user as string with "::" seperation
	 * @param hrequest
	 * @param hresponse
	 * @param username
	 * @param servicekey
	 * @return
	 */
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
