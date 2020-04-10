package com.demo.pdsys.dao;


import com.demo.pdsys.bean.SysFileOperatorLog;

public interface SysFileOperatorLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysFileOperatorLog record);

    int insertSelective(SysFileOperatorLog record);

    SysFileOperatorLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysFileOperatorLog record);

    int updateByPrimaryKey(SysFileOperatorLog record);
}
