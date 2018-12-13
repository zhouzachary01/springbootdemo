package com.demo.test;

import com.demo.redis.RedisClient;
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

    @Autowired
    private RedisClient redisClient;

    @org.junit.Test
    public void test(){
        redisClient.setWithExpireTime("test2","23242",300);
    }




}
