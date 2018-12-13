package com.demo.test;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/11/5 16:20
 * @comment: 备注
 * @version: V1.0
 */
public class Recv {

    @org.junit.Test
    public void test(){
        try {
            String QUEUE_NAME = "hello2";
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            final Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(System.currentTimeMillis() + "Customer Received '" + message + "'");
                }
            };
            channel.basicConsume(QUEUE_NAME, false, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
