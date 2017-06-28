package org.wjw.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by SWGawain on 2017/6/27.
 */
public interface CreditRepaymentMapper {

    @Select("SELECT sum(remain_principal)+sum(remain_interest) amount,plan_date from credit_repayment GROUP BY plan_date")
    List<Map<Long,BigDecimal>> sumByChannel();

}
