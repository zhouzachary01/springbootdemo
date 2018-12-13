package com.demo.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/11/5 16:19
 * @comment: 备注
 * @version: V1.0
 */
public class Send {

    @org.junit.Test
    public void test(){
        try {
            String QUEUE_NAME = "hello12";
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "hello world3451323";
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
