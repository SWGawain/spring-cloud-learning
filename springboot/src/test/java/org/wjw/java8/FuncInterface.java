package org.wjw.java8;

import java.math.BigDecimal;

/**
 * Created by SWGawain on 2017/5/12.
 */
@FunctionalInterface
public interface FuncInterface {

    BigDecimal bal = BigDecimal.ZERO;

    void add(BigDecimal balance);

    default BigDecimal getBalance(){
        return bal;
    }

    static BigDecimal sum(BigDecimal num){
        return bal.add(num);
    }

}
