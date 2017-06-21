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
 * Created by SWGawain on 2017/6/1.
 */
@EnableTransactionManagement
@MapperScan(basePackages = "org.wjw.mybatis.mapper.read",sqlSessionTemplateRef = "primarySqlSessionTemplate")
@Component
public class DataSourcePrimary {

    @Value("${datasource.primary.jndi-name}")
    private String jndiName ;

    @Bean("primaryDataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager1(@Qualifier("primaryDataSource") DataSource datasource){
        return new DataSourceTransactionManager(datasource);
    }

    @Bean(name="primaryDataSource")
    @Primary
    public DataSource primaryDataSource() {
        System.out.println("-------------------- primaryDataSource init ---------------------");
        return new JndiDataSourceLookup().getDataSource(jndiName);
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
