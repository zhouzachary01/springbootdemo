package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/10/22 17:27
 * @comment: 备注
 * @version: V1.0
 */
@Service
public class Test2 extends Test{


    @Autowired
    Mythread mythread;

    @org.junit.Test
    public void test(){
        try {
            for(int i = 0;i < 1;i ++){
                System.out.println("11111111111111111111111111111");
                mythread.excute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("34222222222222222222222222222222222");
    }




}
