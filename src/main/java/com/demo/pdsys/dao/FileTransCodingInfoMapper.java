package com.demo.pdsys.dao;

import com.demo.pdsys.bean.FileTransCodingInfo;


public interface FileTransCodingInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FileTransCodingInfo record);

    int insertSelective(FileTransCodingInfo record);

    FileTransCodingInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileTransCodingInfo record);

    int updateByPrimaryKey(FileTransCodingInfo record);
}
