package redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class TestRedis {

    @Resource(name = "redisTemplate")
    private static RedisTemplate<String, String> redisTemplate; // inject the template as ListOperations


    public static void main(String[] args) {

        redisTemplate.opsForValue().set("key", "value");



    }

}
