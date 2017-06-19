package org.wjw.java8;

import com.google.common.base.Converter;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class MethodUse {

    @Test
    public void testMethod(){

        StudentFactory factory = Student::new;

        Student aaa = factory.create("aaa", 2);

    }

    @Test
    public void testMethod2(){
        new Thread(Student::print).start();
    }

    @Test
    public void testMethod3(){
        Arrays.asList(1,2,3).forEach(System.out::print);
    }


    @Test
    public void test() throws UnsupportedEncodingException {

        String aa = "中国";

        System.out.println(aa.getBytes("UTF-8").length);
        System.out.println(aa.getBytes("GBK").length);
        System.out.println(aa.getBytes("ISO-8859-1").length);
        System.out.println(new String(aa.getBytes("ISO-8859-1"),"ISO-8859-1"));
        System.out.println(new String(aa.getBytes("UTF-8"),"UTF-8"));
        System.out.println(new String(aa.getBytes("GBK"),"GBK"));

    }

}
