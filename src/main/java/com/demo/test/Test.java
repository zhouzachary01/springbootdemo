package com.demo.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/7/24 18:48
 * @comment: 备注
 * @version: V1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest//启动springboot测试
//@SpringBootTest
@WebAppConfiguration//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class Test {

    @Before
    public void before(){//test方法前执行
        System.out.println("测试start");
    }

    @After
    public void after(){//test方法后执行
        System.out.println("测试end");
    }

    @BeforeClass//所有方法前执行，且方法为static修饰
    public static void beforeClass(){
        System.out.println("beforeClass测试start");
    }

    @AfterClass//所有方法后执行，且方法为static修饰
    public static void afterClass(){
        System.out.println("afterClass测试start");
    }
}
