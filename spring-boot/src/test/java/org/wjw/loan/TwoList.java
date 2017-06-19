package org.wjw.loan;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.security.access.method.P;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by SWGawain on 2017/6/9.
 */
public class TwoList {

    public static void main(String[] args) {

        List<Order> orders = Stream.of(
                new Order(1, new BigDecimal(150)),
                new Order(2, new BigDecimal(200)),
                new Order(3, new BigDecimal(400)),
                new Order(4, new BigDecimal(500)),
                new Order(6, new BigDecimal(100))
        ).sorted(Comparator.comparing(Order::getOrderAmount)).collect(Collectors.toList());

        List<Loan> loans = Stream.of(
                new Loan(1,new BigDecimal(10)),
                new Loan(2,new BigDecimal(90)),
                new Loan(3,new BigDecimal(60)),
                new Loan(4,new BigDecimal(40)),
                new Loan(5,new BigDecimal(50)),
                new Loan(6,new BigDecimal(100)),
                new Loan(7,new BigDecimal(60)),
                new Loan(8,new BigDecimal(20))
        ).sorted(Comparator.comparing(Loan::getLoanAmount).reversed()).collect(Collectors.toList());

        orders.forEach(System.out::println);
        loans.forEach(System.out::println);

        List<String> maper = Lists.newArrayList();

        for (Loan loan : loans) {
            BigDecimal loanAmount = loan.getLoanAmount();
            for (Order order : orders){
                BigDecimal orderAmount = order.getOrderAmount();
                if(orderAmount.compareTo(loanAmount)<0){
                   continue;
                }
                order.setOrderAmount(orderAmount.subtract(loanAmount));
                maper.add("o:"+order.getId()+"_l:"+loan.getId()+"_la:"+loan.getLoanAmount()+"_oa:"+order.getOrderAmount());
                break;
            }
        }

        maper.forEach(System.out::println);


    }

}
class Order{
    private int id ;
    private BigDecimal orderAmount ;

    public Order(int id, BigDecimal orderAmount) {
        this.id = id;
        this.orderAmount = orderAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
class Loan{
    private int id ;
    private BigDecimal loanAmount ;

    public Loan(int id, BigDecimal loanAmount) {
        this.id = id;
        this.loanAmount = loanAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
