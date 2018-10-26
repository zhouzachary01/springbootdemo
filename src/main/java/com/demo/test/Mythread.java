package com.demo.test;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/10/22 22:23
 * @comment: 备注
 * @version: V1.0
 */
@Service
public class Mythread{

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userdao;

    public void excute(){
        new Thread1().start();
    }



    //多线程要注入外部服务，可以建立内部类
    private class Thread1 extends Thread{
        @Override
        public void run(){
            try {
                System.out.println("222222222222222222");
                User user = new User();
                user.setId(UUID.randomUUID().toString().replace("-",""));
                user.setLoginName("zxb3");
                user.setPass("123456");
                user.setName("zhouxiaobai3");
                //List<User> list = userService.getUsers();
                userdao.insert(user);
               // userService.insertUser(user);
                System.out.println("333333333333333333333333");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
