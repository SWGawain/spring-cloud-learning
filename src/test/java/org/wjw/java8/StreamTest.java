package org.wjw.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by SWGawain on 2017/5/27.
 */
public class StreamTest {

    @Test
    public void testBasic(){

        List list = Lists.newArrayList(1,2,3,4,5,6);

        list.stream().filter(a -> (Integer)a>2).forEach(System.out::println);

    }

}
