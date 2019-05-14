package com.web.spittr.config.database;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.sql.SQLException;

//@Configuration
@EnableJpaRepositories("com.web.spittr")
public class SpringDataJpaConfig {

  @Autowired
  private DruidDataSourceSettings druidSettings;


  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(druidSettings.getJdbcDriverClassName());
    ds.setUrl(druidSettings.getDruidUrl());
    ds.setUsername(druidSettings.getUsername());
    ds.setPassword(druidSettings.getPassword());
    System.out.println("数据库配置 DriverManagerDataSource："+ds);
    return ds;
  }
  
  //@Bean
  //public JpaTransactionManager transactionManager() {
  //  return new JpaTransactionManager(); // does this need an emf???
  //}
  //
  @Bean
  public HibernateJpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.MYSQL);
    adapter.setShowSql(false);
    adapter.setGenerateDdl(true);
    return adapter;
  }
  
  @Bean
  public Object emf() {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource());
  //  emf.setPersistenceUnitName("spitter");
    emf.setJpaVendorAdapter(jpaVendorAdapter());
    return emf;
  }
  
}
