package org.wjw;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.wjw.filter.AccessFilter;

/**
 * Created by SWGawain on 2017/6/19.
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public ZuulFilter accessFilter(){
        return new AccessFilter();
    }
}
