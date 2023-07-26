package org.example.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"org.example.factory","org.example.controller","org.example.config"})
public class SpringConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setUser("root");
		dataSource.setPassword("root");

		return dataSource;
	}
	
	
}
