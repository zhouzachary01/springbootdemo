package com.demo.test;

import redis.clients.jedis.Jedis;

/**
 * @description: test类;
 * @author: zxb
 * @date: 2018/12/12 13:42
 * @comment: 备注
 * @version: V1.0
 */
public class TestJunit {

    @org.junit.Test
    public void test(){
        Jedis jedis = new Jedis("127.0.0.1");
        /*jedis.set("test","132424324");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");
        jedis.lpush("test1","12");*/
        jedis.select(2);
        jedis.set("test","132424324");
    }

}
