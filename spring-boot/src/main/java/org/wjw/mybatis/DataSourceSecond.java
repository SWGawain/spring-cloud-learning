package org.wjw.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by SWGawain on 2017/6/21.
 */
@EnableTransactionManagement
@MapperScan(basePackages = "org.wjw.mybatis.mapper.write",sqlSessionTemplateRef = "secondSqlSessionTemplate")
@Component
public class DataSourceSecond {

    @Value("${datasource.second.jndi-name}")
    private String jndiName ;


    @Bean("secondDataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager1(@Qualifier("secondDataSource") DataSource secondDataSource){
        return new DataSourceTransactionManager(secondDataSource);
    }

    @Bean(name="secondDataSource")
    @ConfigurationProperties(prefix="datasource.second")
    public DataSource secondDataSource() {
        System.out.println("-------------------- secondDataSource init ---------------------");
        return new JndiDataSourceLookup().getDataSource(jndiName);
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(secondDataSource);
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
