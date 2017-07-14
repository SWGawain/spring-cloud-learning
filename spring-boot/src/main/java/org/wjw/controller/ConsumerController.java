package org.wjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wjw.config.ComputeService;

/**
 * Created by SWGawain on 2017/6/30.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ComputeService computeService;

    @Value("${your.name}")
    String name ;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://config-service/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping("/addplus")
    public String addplus(){
        return computeService.add(10,20)+"";
    }

    @RequestMapping("getName")
    public String getName(){
        return name ;
    }
}
