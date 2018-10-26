package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private MongoTemplate mongoTemplate;

    private int i = 0;
    @org.junit.Test
    public void test1(){

        List list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        for(int i = list.size();i >= 0;i --){
            list.remove(i);
            System.out.print(list.size());
        }
        /*try {
            //Query query = new Query(Criteria.where("fileName").is("FYWpFn5VRakJcOZm1gRCVjy9qtI2Lj74"));
            Query query = new Query();
            String collectionName = "";
            List<File1> f = mongoTemplate.find(query, File1.class);
            System.out.print("11111111111111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


}
