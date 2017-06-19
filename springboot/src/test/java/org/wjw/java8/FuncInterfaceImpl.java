package org.wjw.java8;

import java.math.BigDecimal;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class FuncInterfaceImpl implements FuncInterface {

    BigDecimal bal = BigDecimal.ZERO;

    @Override
    public void add(BigDecimal balance) {
        bal.add(balance);
    }

}
