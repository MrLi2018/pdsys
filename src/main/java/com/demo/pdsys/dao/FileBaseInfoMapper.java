package com.demo.pdsys.dao;

import com.demo.pdsys.bean.FileBaseInfo;


public interface FileBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FileBaseInfo record);

    int insertSelective(FileBaseInfo record);

    FileBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileBaseInfo record);

    int updateByPrimaryKey(FileBaseInfo record);
}
