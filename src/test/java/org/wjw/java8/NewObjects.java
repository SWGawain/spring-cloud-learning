package org.wjw.java8;

import com.google.common.collect.Maps;
import org.assertj.core.util.Strings;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class NewObjects {
    @Test
    public void testOptional(){

        Optional<BigDecimal> balance = Optional.ofNullable(getBal());

        //取值，为空抛出异常
        BigDecimal bigDecimal1 = balance.orElseThrow(RuntimeException::new);

        //如果不为空，则执行
        balance.ifPresent(bigDecimal -> System.out.println(bigDecimal));

        BigDecimal bal = balance.isPresent()? balance.get() : balance.orElseGet(()->BigDecimal.ZERO);
        System.out.println(bal);

        //map可以返回任意类型
        Optional<Integer> up_bal = balance.map((value) -> value.add(BigDecimal.ONE).intValue());
        System.out.println(up_bal.get());

        //flatMap必须返回Optional
        Optional<BigDecimal> upbal2 = balance.flatMap((val) -> Optional.of(val.add(BigDecimal.ONE)));

        System.out.println(upbal2.get());

        upbal2.filter( val -> val.compareTo(BigDecimal.valueOf(10))!=1);

        System.out.println(upbal2.isPresent());
    }

    public BigDecimal getBal(){
        return BigDecimal.ZERO;
    }

    @Test
    public void testN(){

        Integer i = 1 ;

        System.out.println(i==1);
    }
    @Test
    public void testDecimal(){
        BigDecimal aa = new BigDecimal(-1);
        BigDecimal bb = new BigDecimal(-1);
        System.out.println(aa.equals(bb));

    }

    @Test
    public void testNullToString(){
        Map<String,Object> map = Maps.newHashMap();

        String haha = Optional.ofNullable((String)map.get("haha")).orElse("");

        System.out.println("haha:"+haha);

        String heihei = (String)map.get("heihei");

        heihei = Strings.isNullOrEmpty(heihei) ? "" : heihei ;

        System.out.println("heihei:"+heihei);



    }

}
