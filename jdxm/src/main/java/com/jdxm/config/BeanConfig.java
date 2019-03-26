package com.jdxm.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import javax.servlet.MultipartConfigElement;


/**
 * Created by admin on 2019/3/22.
 */
@Configuration
public class BeanConfig {

    @Autowired
    private Environment environment;

    @Bean
    public RequestDumperFilter dumperFilter() {
        return new RequestDumperFilter();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("10MB"); //KB,MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize("30MB");
        return factory.createMultipartConfig();
    }


    /*@Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }*/

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        //set value serializer
        template.setDefaultSerializer(jackson2JsonRedisSerializer);

        //template.setConnectionFactory(jedisConnectionFactory());
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();
        return template;
    }


    /*@Bean
    public RedisTemplate<String, List<UserDicCode>> dicCodeRedis(RedisConnectionFactory factory) {
        RedisTemplate<String, List<UserDicCode>> redis = new RedisTemplate<>();
        redis.setConnectionFactory(factory);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new DicCodeSerializer());
        redis.setHashKeySerializer(new StringRedisSerializer());
        redis.setHashValueSerializer(new DicCodeSerializer());
        return redis;
    }*/

}
