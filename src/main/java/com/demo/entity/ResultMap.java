package com.demo.entity;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/13 17:44
 * @comment: 备注
 * @version: V1.0
 */
public class ResultMap {

    private String status;
    private String resultmessage;
    private Object obj;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultmessage() {
        return resultmessage;
    }

    public void setResultmessage(String resultmessage) {
        this.resultmessage = resultmessage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
