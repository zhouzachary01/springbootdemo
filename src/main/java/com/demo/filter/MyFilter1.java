package com.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/8/10 15:46
 * @comment: 备注
 * @version: V1.0
 */
/*@WebFilter(urlPatterns = "*//*", filterName = "myfilter1")
@Order(Integer.MAX_VALUE -0)*/
public class MyFilter1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1111111111111");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
