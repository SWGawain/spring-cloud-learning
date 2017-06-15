package org.wjw.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SWGawain on 2017/6/7.
 */
@RestController
@RequestMapping("/redis")
public class RedisRest {

    private static Logger logger = LoggerFactory.getLogger(RedisRest.class);

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/get")
    public String get(String key){
        logger.info("获取Key："+key);
        String val = redisTemplate.opsForValue().get(key);
        logger.info("value："+val);
        return val;
    }

    @RequestMapping("/{set}/has_{key}")
    public String lishHas(@PathVariable String set,@PathVariable String key){

        logger.info("集合"+set+"是否含有key："+key);

        Boolean isMember = redisTemplate.opsForSet().isMember(set, key);

        return isMember.toString();
    }
}
