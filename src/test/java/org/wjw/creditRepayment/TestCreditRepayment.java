package org.wjw.creditRepayment;

import cn.facebank.common.exception.PlateformException;
import cn.facebank.fpmain.api.manage.service.CreditRepaymentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wjw.SpringbootDemoApplicationTests;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by SWGawain on 2017/6/19.
 */
public class TestCreditRepayment extends SpringbootDemoApplicationTests {

    @Autowired
    CreditRepaymentService creditRepaymentService;

    @Test
    public void testHoliday(){
        try {

            LocalDateTime ipTime = LocalDateTime.of(2016, 9, 16, 0, 0);
            System.out.println(ipTime);
            long miles = ipTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            Long holiday = creditRepaymentService.getRepaymentEndDateByChannelHoliday("finlink", "fcp001", miles);

            LocalDateTime opTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(holiday), ZoneId.systemDefault());

            System.out.println(opTime);

        } catch (PlateformException e) {
            e.printStackTrace();
        }
    }
}
