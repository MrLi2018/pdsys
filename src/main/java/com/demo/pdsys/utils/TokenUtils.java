package com.demo.pdsys.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;

/**
 * @author MrLi2019
 * @date 20200407
 * token的相关工具方法
 * <p>
 * JWT 由3部分组成: header(Map集合),playload(负载,也可以把它看做请求体body,也是一个map集合),signature(签名,有header和playload加密后再跟secrect加密生成)
 * header:有2个值,一个是类型,一个是算法,类型就是JWT,不会变,算法有2种选择,HMAC256和RS256,基本选择HMAC256
 * playload:类似于post请求的请求体,是一个map集合,可以存很多很多值,如存用户的信息
 * signature:由header(Base64加密后)和playload(Base64加密后)再加上secrect(秘钥生成)
 * Base64加密是可逆的,所以存在header和playload的数据不能是敏感数据
 * *  playload有一些值定义:
 * <p>
 * iss: jwt签发者
 * <p>
 * sub: jwt所面向的用户
 * <p>
 * aud: 接收jwt的一方
 * <p>
 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
 * <p>
 * nbf: 定义在什么时间之前，该jwt都是不可用的.
 * <p>
 * iat: jwt的签发时间
 * <p>
 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
 */
public class TokenUtils {

    /**
     * 过期时间
     * 单位：s
     */
    private static final int EXPIRY_TIME = 5;
    private static final String SECRET_KEY = "9bc822?af1611@41f6_884$bb005?343YH-Gcd36e";

    /**
     * @param userid 用户id
     * @return 生成的令牌 token
     */
    public static String buildToken(String userid) {
        Date date = new Date();
        //过期时间
        Date expiryDate = DateUtils.addSeconds(date, EXPIRY_TIME);
        //填充头部
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("type", "JWT");
        headMap.put("alg", "HS256");
        //填充载荷
        JWTCreator.Builder builder = JWT.create();
        builder.withHeader(headMap);
        builder.withClaim("userid", userid);
        builder.withIssuedAt(date);
        builder.withExpiresAt(expiryDate);
        return builder.sign(Algorithm.HMAC256(SECRET_KEY.getBytes()));
    }

    /**
     * @param token 生成后的token
     * @return 解码的jwt对象信息
     */
    public static DecodedJWT decodeToken(String token) {
        DecodedJWT decodedJwt = null;
        try {

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY.getBytes())).build();
            decodedJwt = jwtVerifier.verify(token);
            return decodedJwt;
        } catch (JWTVerificationException e) {
            System.out.println("token已过期");
            return null;
        }

    }

    public static String getUserId(DecodedJWT decodedJWT) {
        String payload = decodedJWT.getPayload();
        JSONArray objects = JSON.parseArray(payload);
        return (String) objects.get(0);
    }



}
