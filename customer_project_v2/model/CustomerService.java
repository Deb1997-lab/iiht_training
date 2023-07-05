package com.ibm.customer_project_v2.model;

import java.sql.SQLException;

import java.util.List;

public interface CustomerService {
	public void createTable(String table_name) throws SQLException;
	public void addCustomer(String table_name, CustomerDetails customer) throws SQLException;
	public List<String> viewCustomers(String table_name) throws SQLException;
	public CustomerDetails viewCustomerbyId(String table_name, int id) throws SQLException;
	public List<String> viewCustomerbyName(String table_name, String first_name);
	public void deleteCustomerDetails(String table_name, int id);
	public void updateCustomerDetails(String table_name, CustomerDetails customer);
	public void clearTable(String table_name);
	public void deleteEntireTable(String table_name);
	public boolean tableExists(String table_name);
}
