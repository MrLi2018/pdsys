package com.demo.pdsys.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 基本操作类
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public static final long TOKEN_EXPIRES_SECOND = 1800;

    /**
     * @param key redis 存储的key值
     * @param val key对应的value值
     * @return 返回存储结果标识
     */
    public boolean set(String key, String val) {
        boolean flag = true;
        try {
            stringRedisTemplate.opsForValue().set(key, val);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * @param key         reds的key值
     * @param val         redis的value值
     * @param expirestime 过期时间
     * @return 存储结果标识
     */
    public boolean set(String key, String val, long expirestime) {
        boolean flag = true;
        try {
            stringRedisTemplate.opsForValue().set(key, val, expirestime);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * @param key 获取redis中对应key的值
     * @return 返回key对应的值
     */
    public String getByKey(String key) {
        String value = null;
        try {
            value = stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public boolean setKeyExpiriesTime(String key, long time) {
        boolean flag = true;
        try {
            if (time > 0) {
                stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 根据key删除对应value
     *
     * @param key key值
     * @return 删除的结果
     */
    public boolean remove(String key) {
        boolean result = false;
        try {
            stringRedisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*public boolean checkToken(){
        String userid =
    }*/
}
