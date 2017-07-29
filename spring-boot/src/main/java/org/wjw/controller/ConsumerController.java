package org.wjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wjw.config.ComputeService;

/**
 * Created by SWGawain on 2017/6/30.
 */
@RestController
@RefreshScope
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ComputeService computeService;

    @Value("${your.name}")
    String name ;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(String a,String b) {
        return restTemplate.getForEntity("http://config/add?a="+a+"&b="+b, String.class).getBody();
    }

    @RequestMapping("/addplus")
    public String addplus(Integer a,Integer b){
        return computeService.add(a,b)+"";
    }

    @RequestMapping("getName")
    public String getName(){
        return name ;
    }
}
