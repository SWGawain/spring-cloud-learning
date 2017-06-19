package org.wjw.java8;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SWGawain on 2017/5/12.
 */
public class LambdaTest {

    @Test
    public void BasicTest(){
        Arrays.asList(1,2,3).forEach( e -> System.out.println(e));
    }

    @Test
    public void LamTest2(){

        Arrays.asList(1,2,3).forEach( e -> {
            System.out.print(e+" ");
            System.out.println(e+1+" ");

            //1 2
            //2 3
            //3 4
        });
    }

    @Test
    public void LamTest3(){
        int sault = 2 ;
        Arrays.asList(1,2,3).forEach( e -> {
            System.out.print(e+" ");
            System.out.println(e+sault+" ");

            //1 3
            //2 4
            //3 5
        });
    }

    @Test
    public void LamTest4(){
        List<Integer> integers = Arrays.asList(1, 3, 2);

        integers.sort( (e1,e2) -> e1.compareTo(e2));

        integers.forEach( E -> System.out.print(E));    //123

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @Test
    public void LamTest5(){
        //匿名内部类
        // （）表示无参数
        new Thread(()->System.out.println("Hello")).start();

        Runnable runnable = () ->{
            //这其实是在编写run方法
            System.out.println("简单了太多");
        };

        FuncInterface funcInterface = (bigDecimal)-> {
            //这里在编写add方法
            FuncInterface.bal.add(bigDecimal);
        };

        System.out.println(FuncInterface.sum(BigDecimal.ONE));

        funcInterface.add(BigDecimal.ONE);
        System.out.println(funcInterface.getBalance());

    }

}

