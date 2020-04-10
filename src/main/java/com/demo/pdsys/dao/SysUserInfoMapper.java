package com.demo.pdsys.dao;

import com.demo.pdsys.bean.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserInfo record);

    /**
     * 添加系统用户信息
     *
     * @param record 用户信息对象
     * @return 返回索引改动行数值
     */
    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    /**
     * 根据登录名查询用户
     *
     * @param userLogiName 用户登录名
     * @return 返回查询的用户信息
     */
    SysUserInfo selectByLogiName(String userLogiName);
}
