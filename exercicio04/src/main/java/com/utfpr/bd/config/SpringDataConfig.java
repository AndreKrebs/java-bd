package com.utfpr.bd.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableJpaRepositories("com.utfpr.bd")
@EnableTransactionManagement
public class SpringDataConfig {

	@Bean
	public DataSource dataSource() {

	   BoneCPDataSource ds = new BoneCPDataSource(); 

	   ds.setUser("root");
	   ds.setPassword("12345");
	   ds.setJdbcUrl("jdbc:mysql://localhost/curso-spring-db");
	   ds.setDriverClass("com.mysql.cj.jdbc.Driver");
	   return ds;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
	   
	   LocalContainerEntityManagerFactoryBean factory =
	      new LocalContainerEntityManagerFactoryBean();

	   HibernateJpaVendorAdapter vendorAdapter = 
	      new HibernateJpaVendorAdapter(); 
	   vendorAdapter.setGenerateDdl(false); 
	   vendorAdapter.setShowSql(true);

	   factory.setDataSource(dataSource()); 
	   factory.setJpaVendorAdapter(vendorAdapter);
	   factory.setPackagesToScan("com.curso.entity");
	   factory.afterPropertiesSet();

	   return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactioMnanager() {

	   JpaTransactionManager manager = new JpaTransactionManager(); 
	   manager.setEntityManagerFactory(entityManagerFactory()); 
	   manager.setJpaDialect(new HibernateJpaDialect());
	   
	return manager;
	}
	
}
