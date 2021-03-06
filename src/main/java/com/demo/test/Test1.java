package com.demo.test;

import com.demo.service.UserService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/7/24 19:33
 * @comment: 备注
 * @version: V1.0
 */
@Service
public class Test1 extends Test {

    /*@Autowired
    private MongodbServiceImpl mongoTemplate;*/

    @Autowired
    UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    private int i = 0;
    @org.junit.Test
    public void test1(){
        try {
            String QUEUE_NAME = "hello";
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "hello world";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        //userService.test1();

    }


}
