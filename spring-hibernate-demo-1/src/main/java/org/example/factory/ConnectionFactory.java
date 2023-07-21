package org.example.factory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component("connectionFactory")
public class ConnectionFactory {
	private SessionFactory sessionFactory = null;
	private LocalSessionFactoryBean sessionFactoryBean;
	
	@Autowired
	public ConnectionFactory(LocalSessionFactoryBean sessionFactoryBean) {
		this.sessionFactoryBean = sessionFactoryBean;
	}
	public SessionFactory getConnection() {
		sessionFactory = sessionFactoryBean.getObject();
		return sessionFactory;
	}
	
}
