package org.wjw.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@RequestMapping("/consume")
@RefreshScope
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ComputeService computeService;

    @Value("${your.name}")
    String name ;
    @Value("${aaa:defaultaaa}")
    String aaa ;
    @Value("${global.name:defaultName}")
    String globalName ;
    @Value("${demo.global.name:defaultDemoName}")
    String demoGlobalName;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addFail")
    public String add(String a,String b) {
        return restTemplate.getForEntity("http://config/add?a="+a+"&b="+b, String.class).getBody();
    }

    public String addFail(String a,String b){
        return "-999";
    }

    @RequestMapping("/addplus")
    public String addplus(Integer a,Integer b){
        return computeService.add(a,b)+"";
    }

    @RequestMapping("/getName")
    public String getName(){
        return name ;
    }

    @RequestMapping("/getglobal")
    public String getglobal(){
        return aaa +" " +globalName+" "+demoGlobalName;
    }
}
