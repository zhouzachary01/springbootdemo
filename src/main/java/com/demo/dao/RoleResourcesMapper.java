package com.demo.dao;

import com.demo.entity.RoleResources;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResources record);

    int insertSelective(RoleResources record);

    RoleResources selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResources record);

    int updateByPrimaryKey(RoleResources record);
}