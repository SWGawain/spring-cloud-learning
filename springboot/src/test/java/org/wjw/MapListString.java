package org.wjw;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class MapListString {

    @Test
    public void testMapKey(){

        Map<List,BigDecimal> par = Maps.newHashMap();

        List parList = new ArrayList();
        parList.add("1");
        parList.add(2);
        parList.add(new BigDecimal(100));

        par.put(parList,BigDecimal.ONE);

        List parList2 = new ArrayList();
        parList2.add("1");
        parList2.add(2);
        parList2.add(new BigDecimal(100));

        BigDecimal num = par.get(parList2);

        System.out.println(num);

    }
}
