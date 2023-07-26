package org.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;


@Component("jdbcConnect")
public class JDBCConnect {
	
	
	private DataSource dataSource;
	
	@Autowired
	public JDBCConnect(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public Connection getConnection() throws SQLException  {
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	
}
