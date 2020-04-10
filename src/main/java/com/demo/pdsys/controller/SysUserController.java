package com.demo.pdsys.controller;

import com.demo.pdsys.bean.SysUserInfo;
import com.demo.pdsys.bean.resultinfo.ResponseMessage;
import com.demo.pdsys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiXuChen
 * @Description 系统用户信息操作类
 * @Date 11:49 2020/4/7
 **/
@RequestMapping("/sys")
@RestController
@Api("用户信息的基本处理")

public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation("添加或注册用户信息")
    @PostMapping(path = "/users")
    public ResponseMessage<SysUserInfo> addUser(@RequestBody SysUserInfo sysUserInfo) {

        return sysUserService.saveUser(sysUserInfo);
    }

}
