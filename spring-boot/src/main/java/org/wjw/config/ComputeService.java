package org.wjw.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by SWGawain on 2017/7/7.
 */
@FeignClient(name = "config",fallback = ComputeService.ComputeServiceImpl.class)
public interface ComputeService {

    @RequestMapping("/add")
    Integer add(@RequestParam("a") Integer a ,@RequestParam("b") Integer b);

    @Component
    class ComputeServiceImpl implements ComputeService{

        @Override
        public Integer add(Integer a, Integer b) {
            return -999;
        }
    }
}
