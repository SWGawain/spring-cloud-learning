package org.wjw.mybatis.mapper.write;

import org.apache.ibatis.annotations.*;
import org.wjw.mybatis.entity.FpOrder;

/**
 * Created by SWGawain on 2017/6/2.
 */
public interface FpOrderWriteMapper {

    @Update("UPDATE fp_order SET modify_time = #{modifyTime,jdbcType=BIGINT} " +
            "WHERE fp_order_id = #{fpOrderId}")
    int update(@Param("fpOrderId") Long fpOrderId, @Param("modifyTime") Long modifyTime);
}
