package org.wjw.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by SWGawain on 2017/6/1.
 */
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource datasource){
        return new DataSourceTransactionManager(datasource);
    }


}
