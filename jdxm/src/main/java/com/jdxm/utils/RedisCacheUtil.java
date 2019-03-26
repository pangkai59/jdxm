package com.jdxm.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author PK
 * @date 2018/3/25.
 */
@Component
public class RedisCacheUtil {
    protected Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private RedisTemplate redisTemplate;

    public  void set(final String key,final String val, final int cacheTime)
    {
        logger.info("Set To Redis:key="+key+",val="+val+",cacheTime=" + cacheTime);
        redisTemplate.opsForValue().set(key, val, cacheTime, TimeUnit.SECONDS);
    }

    public void set(String key,String val)
    {
        logger.info("Set To Redis:key="+key+",val="+val);
        redisTemplate.opsForValue().set(key, val);
    }

    public void del(final String key)
    {
        logger.info("Del Redis:key="+key);
        redisTemplate.delete(key);

    }

    public Object get(String key)
    {
        Object val =  redisTemplate.opsForValue().get(key);
        logger.info("Get From Redis:key="+key+",val="+val);
        return val;
    }

    public String getString(String key)
    {
        if (redisTemplate.opsForValue() == null ) {
            return "";
        }else {
            String val = redisTemplate.opsForValue().get(key) == null ? "" : redisTemplate.opsForValue().get(key).toString();
            logger.info("Get From Redis:key="+key+",val="+val);
            return val;
        }
    }

    /**
     * 判断是否存在
     * @param key
     * @return
     */

    public boolean has(final String key)
    {
        return redisTemplate.hasKey(key);
    }


    /**
     * 缓存时间
     * @param key
     * @param cacheTime
     */
    public void expire(final String key,final int cacheTime)
    {
        logger.info("Expire Redis:key="+key+",cacheTime="+cacheTime);
        redisTemplate.expire(key, cacheTime, TimeUnit.SECONDS);
    }
}