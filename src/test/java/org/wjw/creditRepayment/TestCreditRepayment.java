package org.wjw.creditRepayment;

import cn.facebank.common.exception.PlateformException;
import cn.facebank.fpmain.api.manage.service.CreditRepaymentService;
import cn.facebank.fpmain.api.manage.service.SystemPropService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.wjw.SpringbootDemoApplicationTests;
import org.wjw.mybatis.mapper.CreditRepaymentMapper;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by SWGawain on 2017/6/19.
 */
public class TestCreditRepayment extends SpringbootDemoApplicationTests {

    @Autowired
    CreditRepaymentService creditRepaymentService;
    @Autowired
    CreditRepaymentMapper creditRepaymentMapper;

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
    public void testSQl(){
        List<Map<Long, BigDecimal>> maps = creditRepaymentMapper.sumByChannel();
        maps.stream().forEach((map)->{
            System.out.println("日期："+ map.get("plan_date")+"，金额："+map.get("amount"));
        });
    }
}
