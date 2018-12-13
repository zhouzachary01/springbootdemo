package com.demo.service;

import com.demo.entity.User;

import java.util.List;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/10 11:03
 * @comment: 备注
 * @version: V1.0
 */
public interface UserService {

    public List<User> getUsers();

    User getUserByLoginName(String loginName);

    public void insertUser(User user);

    public void test1();
}
