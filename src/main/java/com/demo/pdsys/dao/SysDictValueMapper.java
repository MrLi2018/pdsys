package com.demo.pdsys.dao;


import com.demo.pdsys.bean.SysDictValue;

public interface SysDictValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDictValue record);

    int insertSelective(SysDictValue record);

    SysDictValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictValue record);

    int updateByPrimaryKey(SysDictValue record);
}
