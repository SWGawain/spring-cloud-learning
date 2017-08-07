package org.wjw.datasource;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface FpOrderMapper {

    @Select("select * from fp_order where fp_order_id = #{0}")
    @ResultType(Map.class)
    Map selectByPrimaryKey(Long fpOrderId);

}
