package org.wjw.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by SWGawain on 2017/6/30.
 */
@Component
public class RestConfig {

    @Bean
    @LoadBalanced
    RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
