package com.ibm.customer_project_v2.model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CustomerServiceImpl implements CustomerService {
	
	private Connection connection;
	
	

	public CustomerServiceImpl() {
		super();
	}
	
	
	

	public CustomerServiceImpl(Connection connection) {
		super();
		this.connection = connection;
	}




	@Override
	public void createTable(String table_name) throws SQLException {
		// TODO Auto-generated method stub
		try {
			String sql = "CREATE TABLE IF NOT EXISTS "+table_name+" ("+"id INT PRIMARY KEY,"+"first_name VARCHAR(255), "+"last_name VARCHAR(255), "+"email_id VARCHAR(255)"+")";
			try (Statement statement = connection.createStatement()){
				statement.executeUpdate(sql);
				System.out.println("Table "+table_name+" has been successfully created");
			}catch (SQLException e) {
				if (e.getErrorCode() == 1050) {
					System.out.println("A table with this name already exists");
				}else {
					throw e;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addCustomer(String table_name, CustomerDetails customer) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+table_name+" (id,first_name,last_name,email_id) VALUES (?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,customer.getCustomer_id());
			statement.setString(2, customer.getFirst_name());
			statement.setString(3, customer.getLast_name());
			statement.setString(4, customer.getMail_id());
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected > 0 ) {
				System.out.println("Employee added successfully");
			}else {
				System.out.println("Failed to add employee");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> viewCustomers(String table_name) throws SQLException {
		// TODO Auto-generated method stub
		List<String> customer_list  = new ArrayList<>();
		String sql = "SELECT * FROM " + table_name;
		try (Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(sql)){
			while(resultset.next()) {
				int id = resultset.getInt(1);
				String fname = resultset.getString(2);
				String lname = resultset.getString(3);
				String mail = resultset.getString(4);
				
				CustomerDetails customer = new CustomerDetails(id,fname,lname,mail);
				customer_list.add(customer.getDetails());
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer_list;
	}

	@Override
	public CustomerDetails viewCustomerbyId(String table_name, int id) throws SQLException {
		// TODO Auto-generated method stub
		CustomerDetails customer = new CustomerDetails();
		String sql = "SELECT * FROM "+table_name+" WHERE id= ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			try (ResultSet resultset = statement.executeQuery()){
				if (resultset.next()) {
					customer.setCustomer_id(resultset.getInt(1)); 
					customer.setFirst_name(resultset.getString(2));
					customer.setLast_name(resultset.getString(3));
					customer.setMail_id(resultset.getString(4));
				}else {
					System.out.println("Id not found");
				}
			}catch(SQLException e) {
				if(e.getErrorCode()==0) {
					System.out.println("Id not found");
				}else {
					throw e;
				}
			}
		}
		return customer;
	}

	@Override
	public List<String> viewCustomerbyName(String table_name, String first_name) {
		// TODO Auto-generated method stub
		List<String> customer_list = new ArrayList<>();
		String sql = "SELECT * FROM "+table_name+" WHERE first_name = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,first_name);
			try(ResultSet resultset = statement.executeQuery()){
				while (resultset.next()) {
					int id = resultset.getInt(1);
					String lname = resultset.getString(3);
					String mail = resultset.getString(4);
					
					CustomerDetails customer = new CustomerDetails(id,first_name,lname,mail);
					customer_list.add(customer.getDetails());
				}
				
			}catch(SQLException e) {
				if(e.getErrorCode()==1292) {
					System.out.println("Invalid Entry");
				}else {
					throw e;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer_list;
	}

	@Override
	public void deleteCustomerDetails(String table_name, int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM "+table_name+" WHERE id = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Failed to delete employee.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCustomerDetails(String table_name, CustomerDetails customer) {
		// TODO Auto-generated method stub
		String sql = "UPDATE "+table_name+" SET first_name=?,last_name=?, email_id=? WHERE id= "+customer.getCustomer_id();
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, customer.getFirst_name());
			statement.setString(2, customer.getLast_name());
			statement.setString(3, customer.getMail_id());
			int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("Failed to delete employee.");
            }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEntireTable(String table_name) {
		// TODO Auto-generated method stub
		String sql = "DROP TABLE "+table_name;
		try(Statement statement = connection.createStatement()){
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(e.getErrorCode()==1051) {
				System.out.println("No such table found"); 
			}else {
				e.printStackTrace();
			}
			 
		}

	}




	@Override
	public void clearTable(String table_name) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM "+table_name;
		try(Statement statement = connection.createStatement()){
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No such table found");  
		}
	}
	
	@Override
	public boolean tableExists(String tableName) {
	    boolean flag = false;
	    String sql = "SELECT 1 FROM " + tableName + " LIMIT 1";
	    try (Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {
	        flag = true; // If no SQLException occurs, the table exists
	    } catch (SQLException e) {
	        if (e.getErrorCode() == 1146) {
	            // Table does not exist
	            flag = false;
	        } else {
	            e.printStackTrace();
	        }
	    }
	    return flag;
	}


	

}
