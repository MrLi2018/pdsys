package com.demo.pdsys.component;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.pdsys.annotion.AuthByToken;
import com.demo.pdsys.bean.resultinfo.ResponseMessage;
import com.demo.pdsys.utils.TokenUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MrLi2019
 */
@Api("登录拦截器组件")
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            return true;
        }
        AuthByToken annotation = handler.getClass().getAnnotation(AuthByToken.class);
        if (null != annotation) {
            //验证token
            String keyinfo = request.getHeader("authorization");
            if (null != keyinfo && !"".equals(keyinfo)) {
                DecodedJWT decodedJWT = TokenUtils.decodeToken(keyinfo);
                if (null != decodedJWT) {
                    String userid = TokenUtils.getUserId(decodedJWT);
                    String value = redisClient.getByKey(userid + "_token");
                    if (keyinfo.equals(value)) {
                        ResponseMessage responseMessage = new ResponseMessage(true);
                        responseMessage.setCode(200);
                        return true;
                    }
                }
            }


        }
        ResponseMessage responseMessage = new ResponseMessage(false);
        responseMessage.setCode(402);
        responseMessage.setMessage("token认证失败！");
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(responseMessage));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
