package com.hyk.proxy.server.gae.rpc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.appengine.api.datastore.QueryResultIterable;
import com.hyk.proxy.common.Version;
import com.hyk.proxy.common.rpc.service.MasterNodeService;
import com.hyk.proxy.server.gae.appid.AppIdShareItem;
import com.hyk.proxy.server.gae.util.EMailUtil;
import com.hyk.proxy.server.gae.util.ServerUtils;

/**
 *
 */
public class MasterNodeServiceImpl implements MasterNodeService, Serializable {

    private boolean verifyAppId(String appid) {
        try {
            String urlstr = "http://" + appid + ".appspot.com";
            URL url = new URL(urlstr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buf = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line);
            }
            reader.close();
            return buf.toString().contains("hyk-proxy");
        } catch (Exception e) {
        }
        return false;
    }


}
