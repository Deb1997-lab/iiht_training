package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.entity.Product;
import org.example.factory.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {
	
	public ConnectionFactory connectionFactory;
	
	@Autowired
	public ProductDaoImpl(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public Session session;

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		session = connectionFactory.getConnection().openSession();
		session.getTransaction().begin();
		session.save(product);
		session.getTransaction().commit();
		return product;
	}

	@Override
	public List<Product> getProducts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		session = connectionFactory.getConnection().openSession();
	    String sql = "SELECT p FROM Product p WHERE p.id = :productId";
	    Query query = session.createQuery(sql);
	    query.setParameter("productId", id);
	    Product product = (Product) query.uniqueResult();
	    session.close();
	    return product;
	}

}
