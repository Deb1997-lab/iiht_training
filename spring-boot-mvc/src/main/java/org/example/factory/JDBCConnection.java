package org.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component("jdbcConnect")
public class JDBCConnection {
	
	@Autowired
	private DataSource dataSource;
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	
	
	
}
