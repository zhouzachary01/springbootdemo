package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.util.UUID;


/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/10 17:25
 * @comment: 备注
 * @version: V1.0
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserService userService;


    @RequestMapping("/test")
    public String test(){
        User user = new User();
        user.getClass();
        Class clazz = user.getClass();
        String tableName = "";
        Annotation[] s1 =  clazz.getAnnotations();
        Table annotation = (Table) clazz.getAnnotation(Table.class);
        for(int i = 0;i < s1.length;i ++){
            Class c1 = s1[i].annotationType();
            String s2 = s1[i].toString();
            if(s2.indexOf("Table") >= 0){
                Table annotation1 = (Table) c1.getAnnotation(Table.class);
                tableName = s2.substring(s2.indexOf("=")+1,s2.indexOf(","));
            }
        }


      // String tablename =  annotation.
        return tableName;
    }

    @RequestMapping("/insert")
    public String insertUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setLoginName("zxb3");
        user.setPass("123456");
        user.setName("zhouxiaobai3");
        userService.insertUser(user);
        return "success";
    }

}
