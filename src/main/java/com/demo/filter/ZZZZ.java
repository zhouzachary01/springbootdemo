package com.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 过滤器注册器;
 * @author: 周海涛
 * @date: 2018/8/10 15:59
 * @comment: 备注
 * @version: V1.0
 */
@Configuration
public class ZZZZ {

        @Bean
        public FilterRegistrationBean filterRegistrationBean1(){
            FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
            filterRegistrationBean.setFilter(new MyFilter());
            filterRegistrationBean.addUrlPatterns("");
            filterRegistrationBean.setOrder(2);//order的数值越小 则优先级越高
            return filterRegistrationBean;
        }
       /* @Bean
        public FilterRegistrationBean filterRegistrationBean2(){
            FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
            filterRegistrationBean.setFilter(new MyFilter1());
            filterRegistrationBean.addUrlPatterns("*//*");
            filterRegistrationBean.setOrder(-1);
            return filterRegistrationBean;
        }*/


    }
