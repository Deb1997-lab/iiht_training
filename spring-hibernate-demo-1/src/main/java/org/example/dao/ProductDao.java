package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.entity.Product;

public interface ProductDao {
	public Product addProduct(Product product) throws SQLException;
	public List<Product> getProducts() throws SQLException;
	public Product findById(String id) throws SQLException;
	
}
