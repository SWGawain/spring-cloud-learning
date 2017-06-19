package org.wjw.redis;

import javafx.scene.shape.VLineTo;
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

    @RequestMapping("/hash/{map}/set_{key}_{value}")
    public String setHash(@PathVariable String map,@PathVariable String key,@PathVariable String value){
        logger.info("redis设置hash，map："+map+"，key："+key+"，value："+value);
        redisTemplate.opsForHash().put(map,key, value);
        return "success";
    }

    @RequestMapping("/hash/{map}/get_{key}")
    public String getHash(@PathVariable String map,@PathVariable String key){
        return redisTemplate.opsForHash().get(map,key).toString();
    }
}
