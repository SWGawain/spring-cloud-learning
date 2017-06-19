package org.wjw.loan;

import cn.facebank.fpmain.api.manage.service.LoanService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.wjw.SpringbootDemoApplicationTests;
import org.wjw.rollback.Rollback;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SWGawain on 2017/5/11.
 */
public class TestLimit extends SpringbootDemoApplicationTests {

    @Autowired
    LoanService mainService ;
    @Autowired
    cn.facebank.asset.api.service.LoanService assetService; 

    @Autowired
    Rollback rollback;

    @Test
    public void testRol(){
        System.out.println(rollback);
    }

    @Test
    public void testSum(){
        List<Integer> list = Lists.newArrayList(
                1,2,3,4,5,6
        );
        BigDecimal sum = mainService.sumLoanAmount(list);
        System.out.println(sum);
    }
    
    @Test
    public void testBeyond(){

        BigDecimal less = assetService.isBeyondLimit("12313123131","wecashChannel","WCP001");

        System.out.println(less);

    }
    
}
