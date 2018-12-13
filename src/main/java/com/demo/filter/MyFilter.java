package com.demo.filter;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/7/21 22:36
 * @comment: 备注
 * @version: V1.0
 */
@Configuration
@WebFilter(urlPatterns = "/")
//@Order(Integer.MAX_VALUE -1)
public class MyFilter implements Filter {

    private FilterConfig config;

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
        ServletContext sc = filterConfig.getServletContext();//获取servletContext；
        WebApplicationContext wct = WebApplicationContextUtils.getWebApplicationContext(sc);//获取WebApplicationContext上下文；
        if(wct != null){
            userService = wct.getBean(UserServiceImpl.class);//获取bean；
        }
        System.out.println("Filter初始化中");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
       // System.out.println("开始进行过滤处理");
        InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
        String hostAddress = address.getHostAddress();
        String servletPath = req.getServletPath();//请求路径；
        String contextPath = req.getContextPath();

        String canshu = req.getQueryString();//获取的url后面的参数

        if(servletPath.matches(".*(\\.([a-z]|[A-Z])+)$")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else if(servletPath.contains("/login") || servletPath.contains("/admin")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            /*Object user  = SecurityUtils.getSubject().getPrincipal();
            if(user == null){//获取不到用户信息，则重定向到登录页面；
                res.sendRedirect(contextPath + "/admin");
            }else{*/
                filterChain.doFilter(servletRequest, servletResponse);
           /* }*/
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁中");
    }
}
