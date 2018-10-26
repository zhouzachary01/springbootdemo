package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/10 11:03
 * @comment: 备注
 * @version: V1.0
 */
@Service
//@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userdao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUsers() {
        try {
            List list = jdbcTemplate.queryForList("select * from user");
            //return userdao.getUsers();
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByLoginName(String loginName) {
        /*try {
            List<User> list = userdao.getUserByLoginName(loginName);
            if(list != null && list.size() > 0){
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public void insertUser(User user) {
        try {
            userdao.insert(user);
            /*User u = null;
            u.setLoginName("1");*/
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.print("出现异常！");
           // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        /*try {
            userdao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
