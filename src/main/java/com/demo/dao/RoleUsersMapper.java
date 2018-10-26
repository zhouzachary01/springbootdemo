package com.demo.dao;

import com.demo.entity.RoleUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleUsers record);

    int insertSelective(RoleUsers record);

    RoleUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleUsers record);

    int updateByPrimaryKey(RoleUsers record);
}