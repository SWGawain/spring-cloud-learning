package org.wjw.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjw.mybatis.entity.FpOrder;

import javax.sql.DataSource;
import javax.swing.*;
import java.util.Optional;

/**
 * Created by SWGawain on 2017/6/1.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisRest {

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    FpOrderManager fpOrderManager;

    @RequestMapping("/getDataSource")
    public String getDataSource(){
        return dataSourceTransactionManager.toString();
    }

    @RequestMapping("/get")
    public String get(Long id){
        FpOrder fpOrder = Optional.ofNullable(fpOrderManager.find(id)).orElse(new FpOrder());
        return fpOrder.toString();
    }

}
