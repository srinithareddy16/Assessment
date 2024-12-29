package com.example.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void addToCache(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void deleteFromCache(String key) {
        redisTemplate.delete(key);
    }
}
