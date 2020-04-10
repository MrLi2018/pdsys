package com.demo.pdsys.service;

import com.demo.pdsys.bean.SysUserInfo;
import com.demo.pdsys.bean.resultinfo.ResponseMessage;

/**
 * 系统用户信息业务操作接口
 *
 * @author MrLi2019
 */
public interface SysUserService {

    /**
     * 添加系统用户信息
     *
     * @param sysUserInfo 待添加的用户信息
     * @return 添加成功后的用户信息
     */
    ResponseMessage<SysUserInfo> saveUser(SysUserInfo sysUserInfo);

    /**
     * 根据登录名称查询用户
     *
     * @param loginame 登录名称
     * @return 查询到的用户信息
     */
    SysUserInfo findSysUserByLogiName(String loginame);
}
