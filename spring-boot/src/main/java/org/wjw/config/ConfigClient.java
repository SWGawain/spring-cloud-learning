package org.wjw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SWGawain on 2017/6/20.
 */
@RestController
@RequestMapping("/config")
public class ConfigClient {

    @Value("${env}")
    private String env ;

    @Value("${your.name}")
    private String name ;

    @RequestMapping("/getEnv")
    public String getEnv(){
        return env;
    }

    @RequestMapping("/getName")
    public String getName(){
        return name ;
    }

}
