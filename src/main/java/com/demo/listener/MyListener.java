package com.demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/7/27 10:54
 * @comment: 备注
 * @version: V1.0
 */
@WebListener
public class MyListener implements HttpSessionListener{

    private int count;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        System.out.println("created_count:" + count);
        httpSessionEvent.getSession().getServletContext().setAttribute("countsession",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count++;
        System.out.println("destroyed_count:" + count);
        httpSessionEvent.getSession().getServletContext().setAttribute("countsession",count);
    }
}
