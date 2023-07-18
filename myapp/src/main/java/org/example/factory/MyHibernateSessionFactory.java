package org.example.factory;

import org.example.entity.LeagueEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateSessionFactory {
	
	private static SessionFactory sessionFactory=null;
	
	private static Session session=null;
	
	
	public static Session getHibernateSession()throws Exception
	{
		sessionFactory=new Configuration().configure().addAnnotatedClass(LeagueEntity.class).buildSessionFactory();
		
		session=sessionFactory.openSession();
		return session;
	}

}