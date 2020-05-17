package com.example.iphone_code_by_redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtil {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 获取redis中的值
     * @param key
     * @return
     */
    public String get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 向redis中set值
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key,String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
