package com.demo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/7/27 23:19
 * @comment: 备注
 * @version: V1.0
 */
public class HostUtils {

    /** 
     * @description : 获取客户机的实际地址ip;
     * @author : 周海涛
     * @date : 2018/7/27 23:21
     * @param : [request]
     * @return : java.lang.String
     * @throws :可能抛出的异常;
     */
    public static String getRealIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
