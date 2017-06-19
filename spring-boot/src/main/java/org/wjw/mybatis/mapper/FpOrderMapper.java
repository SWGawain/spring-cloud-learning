package org.wjw.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.wjw.mybatis.entity.FpOrder;

/**
 * Created by SWGawain on 2017/6/2.
 */
public interface FpOrderMapper {

    @Select("SELECT * FROM fp_order where fp_order_id = #{fpOrderId}")
    @ResultMap("BaseResultMap")
    FpOrder selectById(@Param("fpOrderId") Long fpOrderId);
}
