package org.wjw.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wjw.mybatis.entity.FpOrder;
import org.wjw.mybatis.mapper.FpOrderMapper;

/**
 * Created by SWGawain on 2017/6/2.
 */
@Component
public class FpOrderManager {

    @Autowired
    private FpOrderMapper mapper;

    @Transactional
    public FpOrder find(Long fpOrderId){
        return mapper.selectById(fpOrderId);
    }
}
