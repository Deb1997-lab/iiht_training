package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = {"org.example.dao","org.example.factory"})
public class SpringConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProps());
		sessionFactoryBean.setPackagesToScan("org.example.entity");
		return sessionFactoryBean;
	}

	public Properties hibernateProps() {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty("hibernate.show_sql", "true");
		return props;
	}
	
	@Bean
	public DataSource dataSource() {
		// TODO Auto-generated method stub
		ComboPooledDataSource  dataSource =  new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setMaxPoolSize(15);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxIdleTime(5000);
		return dataSource;
	}
}
