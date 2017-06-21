package org.wjw.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wjw.mybatis.entity.FpOrder;
import org.wjw.mybatis.mapper.read.FpOrderReadMapper;
import org.wjw.mybatis.mapper.write.FpOrderWriteMapper;

/**
 * Created by SWGawain on 2017/6/2.
 */
@Component
public class FpOrderManager {

    @Autowired
    private FpOrderReadMapper readMapper;

    @Autowired
    private FpOrderWriteMapper writeMapper ;

    @Transactional
    public FpOrder find(Long fpOrderId){
        return readMapper.selectById(fpOrderId);
    }

    public int update(Long fpOrderId,Long modifyTime){
        return writeMapper.update(fpOrderId,modifyTime);
    }
}
