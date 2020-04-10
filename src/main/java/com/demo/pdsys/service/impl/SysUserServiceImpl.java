package com.demo.pdsys.service.impl;

import com.demo.pdsys.bean.SysUserInfo;
import com.demo.pdsys.bean.resultinfo.ResponseMessage;
import com.demo.pdsys.dao.SysUserInfoMapper;
import com.demo.pdsys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public ResponseMessage<SysUserInfo> saveUser(final SysUserInfo sysUserInfo) {
        ResponseMessage<SysUserInfo> responseMessage;
        if (null!=sysUserInfo){
            sysUserInfo.setCreateTime(new Date());
        }
        int count = this.sysUserInfoMapper.insertSelective(sysUserInfo);
        if (count > 0) {
            responseMessage = new ResponseMessage<>(true);
            responseMessage.success("用户添加成功");
        } else {
            responseMessage = new ResponseMessage<>(false);
            responseMessage.error("用户添加失败");
        }
        return responseMessage;
    }

    @Override
    public SysUserInfo findSysUserByLogiName(String loginame) {

        return this.sysUserInfoMapper.selectByLogiName(loginame);
    }
}
