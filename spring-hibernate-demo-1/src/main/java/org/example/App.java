package org.example;

import org.example.config.SpringConfig;
import org.example.dao.ProductDao;
import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		ProductDao prod = context.getBean("productDao", ProductDao.class);
		System.out.println(prod.findById("233"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
