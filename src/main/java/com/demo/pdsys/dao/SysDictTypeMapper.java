package com.demo.pdsys.dao;


import com.demo.pdsys.bean.SysDictType;

public interface SysDictTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    SysDictType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);
}
