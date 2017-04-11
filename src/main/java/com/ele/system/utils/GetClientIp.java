package com.ele.system.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author wangping-ds5
 *
 */
public class GetClientIp {
    private static String[] PROXY_HEAD_TAGS = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "ORIG_CLIENT_IP" };

    public static String getIpAddr(HttpServletRequest request) {
        if (hasProxy(request)) {
            String ip = null;
            boolean proxyHeadHasIp = false;
            for (int i = 0; i < PROXY_HEAD_TAGS.length; i++) {
                ip = request.getHeader(PROXY_HEAD_TAGS[i]);
                if (!isNull(ip)) {
                    proxyHeadHasIp = true;
                    break;
                }
            }
            if (!proxyHeadHasIp) {
                ip = request.getRemoteAddr();
            }
            if (ip != null && ip.length() > 0) {
                String[] tempIps = ip.split(",");
                if (tempIps != null && tempIps.length > 1) {
                    ip = tempIps[0];
                }
            }
            return ip;
        } else {
            return request.getRemoteAddr();
        }
    }

    public static boolean isNull(String ip) {
        // 有些是unknown，为有些可能是其他的比如unknown.unknown.
        // 严格来讲，需要判断ip地址是否是数字加点号。
        // 有些使用了反向代理后，会显示本机的127.0.0.1
        // 严格来讲，需要判断ip是否是保留的ip地址。
        return ip == null || ip.trim().length() == 0 || ip.indexOf("u") != -1 || ip == "127.0.0.1";
    }

    private static boolean hasProxy(HttpServletRequest request) {
        for (int i = 0; i < PROXY_HEAD_TAGS.length; i++) {
            if (request.getHeader(PROXY_HEAD_TAGS[i]) != null) {
                return true;
            }
        }
        return false;
    }
}
