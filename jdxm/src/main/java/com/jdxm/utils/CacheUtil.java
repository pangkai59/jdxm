package com.jdxm.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class CacheUtil {

    public static final String PLANSHOPCAR_PAGE = "planShopCar:page";

    @Autowired
    private static RedisTemplate<String,Object> redisTemplate;

    /**
     * 删除缓存
     * @param key 键
     */
    public static void deleteCache(String key){
        redisTemplate.delete(key);
    }

}
