package com.web.spittr.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/1 14:23
 * @Description:  数据库连接池代码
 */
@Configuration
@EnableTransactionManagement         //  开始事物
public class DruidDataSourceConfig {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Autowired
    private DruidDataSourceSettings druidSettings;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 配置数据源 注入到Spring中
     * @return
     * @throws SQLException
     */
    @Bean
   // @Profile("dev")
    public DataSource dataSource() {
        // BasicDataSource ds = new BasicDataSource();
        //DruidDataSource ds = new DruidDataSource();     // 将读取出来的数据设置到 DruidDataSource 中
        /**
         *  在每个连接请求时都会返回一个新建的连接
         *  与DBCP的BasicDataSource不同，由DriverManagerDataSource提供的连接并没有进行池化管理；
         */
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(druidSettings.getJdbcDriverClassName());
        ds.setUrl(druidSettings.getDruidUrl());
        ds.setUsername(druidSettings.getUsername());
        ds.setPassword(druidSettings.getPassword());
        //ds.setInitialSize(druidSettings.getInitialSize());
        //ds.setMinIdle(druidSettings.getMinIdle());
        //ds.setMaxActive(druidSettings.getMaxActive());
        //ds.setTimeBetweenEvictionRunsMillis(druidSettings.getTimeBetweenEvictionRunsMillis());
        //ds.setMinEvictableIdleTimeMillis(druidSettings.getMinEvictableIdleTimeMillis());
        //ds.setValidationQuery(druidSettings.getValidationQuery());
        //ds.setTestWhileIdle(druidSettings.isTestWhileIdle());
        //ds.setTestOnBorrow(druidSettings.isTestOnBorrow());
        //ds.setTestOnReturn(druidSettings.isTestOnReturn());
        //ds.setPoolPreparedStatements(druidSettings.isPoolPreparedStatements());
        //ds.setMaxPoolPreparedStatementPerConnectionSize(druidSettings.getMaxPoolPreparedStatementPerConnectionSize());
        //ds.setFilters(druidSettings.getFilters());
        //ds.setConnectionProperties(druidSettings.getConnectionProperties());
        logger.info(" druid datasource config : {} ", ds);
        System.out.println("数据库配置 DriverManagerDataSource："+ds);
         return ds;
    }

    @Bean
    @Profile("prd")
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource ds = new DruidDataSource();     // 将读取出来的数据设置到 DruidDataSource 中
        /**
         *  在每个连接请求时都会返回一个新建的连接
         *  与DBCP的BasicDataSource不同，由DriverManagerDataSource提供的连接并没有进行池化管理；
         */
        ds.setDriverClassName(druidSettings.getJdbcDriverClassName());
        ds.setUrl(druidSettings.getDruidUrl());
        ds.setUsername(druidSettings.getUsername());
        ds.setPassword(druidSettings.getPassword());
        ds.setInitialSize(druidSettings.getInitialSize());
        ds.setMinIdle(druidSettings.getMinIdle());
        ds.setMaxActive(druidSettings.getMaxActive());
        ds.setTimeBetweenEvictionRunsMillis(druidSettings.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(druidSettings.getMinEvictableIdleTimeMillis());
        ds.setValidationQuery(druidSettings.getValidationQuery());
        ds.setTestWhileIdle(druidSettings.isTestWhileIdle());
        ds.setTestOnBorrow(druidSettings.isTestOnBorrow());
        ds.setTestOnReturn(druidSettings.isTestOnReturn());
        ds.setPoolPreparedStatements(druidSettings.isPoolPreparedStatements());
        ds.setMaxPoolPreparedStatementPerConnectionSize(druidSettings.getMaxPoolPreparedStatementPerConnectionSize());
        ds.setFilters(druidSettings.getFilters());
        ds.setConnectionProperties(druidSettings.getConnectionProperties());
        logger.info(" druid datasource config : {} ", ds);
        System.out.println("数据库配置：druidDataSource "+ds);
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
           //实例化jpa适配器，由于使用的是hibernate所以用hibernatejpavendor
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
           //不生成sql
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.My5SQL5Dialect");
        return adapter;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean exampleEntityManager()  {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.valueOf("POSTGRESQL"));
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        // 更改为对应包名，包括 repository 及 pojo ，建议放到同级不同子目录
        factory.setPackagesToScan("com.web.spittr");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(jpaProperties());
        return factory;
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return properties;
    }


   // @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource,
                                                                           JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.web.spittr.data");
        return emfb;
    }
        //实例化jpa适配器，由于使用的是hibernate所以用hibernatejpavendor
        //HibernateJpaVendorAdapter japVendor = new HibernateJpaVendorAdapter();
        ////不生成sql
        //japVendor.setGenerateDdl(false);
        ////实例化管理工厂
        //LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        //entityManagerFactory.setDataSource(dataSource);
        //entityManagerFactory.setJpaVendorAdapter(japVendor);
        ////设置扫描包名
        //entityManagerFactory.setPackagesToScan("com.web.spittr");
        //return entityManagerFactory;



    /**
     * 开始事物
     * @return
     * @throws Exception
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}

