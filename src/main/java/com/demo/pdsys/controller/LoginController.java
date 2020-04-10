package com.demo.pdsys.controller;

import com.demo.pdsys.bean.SysUserInfo;
import com.demo.pdsys.bean.resultinfo.ResponseMessage;
import com.demo.pdsys.component.RedisClient;
import com.demo.pdsys.service.SysUserService;
import com.demo.pdsys.utils.TokenUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录请求处理
 */
@Api("登录请求处理")
@RestController
public class LoginController {

    @Autowired
    private RedisClient redisClient;


    @Autowired
    private SysUserService sysUserService;

    @PostMapping("sys/login")
    public ResponseMessage login(HttpServletRequest request, @RequestBody SysUserInfo userInfo) {
        String loginame = userInfo.getUserLoginName();
        String password = userInfo.getUserPassword();
        String verycode = userInfo.getVerycode();
        SysUserInfo sysUserInfo = sysUserService.findSysUserByLogiName(loginame);
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (null==sysUserInfo){
            return responseMessage.error("用户不存在");
        }
        String redisCaptcha = redisClient.getByKey(("ip_"+request.getRemoteAddr()+"_captcha").replaceAll(":","."));
        if (verycode.trim().equals(redisCaptcha.trim())) {
            String token;
                if (password != null) {
                    if (sysUserInfo.getUserPassword().equals(password)) {
                        token = TokenUtils.buildToken(String.valueOf(sysUserInfo.getId()));
                        redisClient.set(sysUserInfo.getId() + "_token", token);
                        responseMessage.setData(token);
                        responseMessage.setCode(200);
                        responseMessage.setState(true);
                        return responseMessage;
                    }
                }
        }
        responseMessage.error("登陆失败！");
        return responseMessage;
    }
}
