package com.demo.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/12/12 14:08
 * @comment: 备注
 * @version: V1.0
 */
@ConfigurationProperties(prefix = JedisProperties.JEDIS_PREFIX)
public class JedisProperties {

    public static final String JEDIS_PREFIX = "redis.server";

    private String host;
    private int port;
    private String password;
    private int maxTotal;
    private int maxIdle;
    private int maxWaitMillis;
    private int timeOut;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
