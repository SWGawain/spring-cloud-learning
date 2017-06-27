package org.wjw.creditRepayment;

import cn.facebank.common.exception.PlateformException;
import cn.facebank.fpmain.api.manage.service.CreditRepaymentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.wjw.SpringbootDemoApplicationTests;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * Created by SWGawain on 2017/6/19.
 */
public class TestCreditRepayment extends SpringbootDemoApplicationTests {

    @Autowired
    CreditRepaymentService creditRepaymentService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testHoliday(){
        try {

            LocalDateTime ipTime = LocalDateTime.of(2017, 6, 27, 0, 0);
            System.out.println(ipTime);
            long miles = ipTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            Long holiday = creditRepaymentService.getRepaymentEndDateByChannelHoliday("wecashChannel", "WCP001", miles);

            LocalDateTime opTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(holiday), ZoneId.systemDefault());

            System.out.println(opTime);

        } catch (PlateformException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSysHoliday(){
        Set fpmain_sysholiday_all = (Set) redisTemplate.opsForValue().get("fpmain_sysholiday_all");
        fpmain_sysholiday_all.stream().forEach(System.out::println);
    }

}
