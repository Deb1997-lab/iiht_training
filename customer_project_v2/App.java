package com.ibm.customer_project_v2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibm.customer_project_v2.model.*;

public class App 
{
	
	public static void main(String[] args) {
        try {
            // Establishing the connection to the 'hr' database
            Connection connection = MyConnectionFactory.getConnection();

            // Creating an instance of CustomerServiceImpl with the established connection
            CustomerService customerService = new CustomerServiceImpl(connection);

            // Creating a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Menu
            while (true) {
                System.out.println("\n========== Menu ==========");
                System.out.println("1. Create a new table");
                System.out.println("2. Open existing table");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                String choice = scanner.next();
                int temp_ch = Integer.parseInt(choice);
                try {
                    switch (temp_ch) {
                        case 1:
                            System.out.print("Enter table name: ");
                            String tableName = scanner.next();
                            customerService.createTable(tableName);
                            break;
                        case 2:
                        	System.out.print("Enter table name: ");
                        	String table_name = scanner.next();
                        	if(customerService.tableExists(table_name)) {
                        		editTable(customerService, table_name);
                        	}else {
                        		System.out.println("Table doesn't exist");
                        	}
                            break;
                        case 0:
                            System.out.println("Exiting the program.");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (SQLException e) {
                    if (e.getErrorCode() == 1146) {
                        System.out.println("Table does not exist.");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private static void editTable(CustomerService customerService, String table_name) {
		// TODO Auto-generated method stub
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("\\n========== Menu ==========");
		System.out.println("1. View table");
		System.out.println("2. Add customer");
		System.out.println("3. Search customer by id");
		System.out.println("4. Search customer by name");
		System.out.println("5. Delete customer by id");
		System.out.println("6. Update customer by id");
		System.out.println("7. Clear table");
		System.out.println("8. Delete table");
		String ch1 = scanner2.next();
		int temp_ch = Integer.parseInt(ch1);
		try {
		switch(temp_ch) {
		case 1: 
			System.out.println(customerService.viewCustomers(table_name));
			break;
		case 2:
			addCustomer(table_name,customerService);
			break;
		case 3:
			viewById(table_name,customerService);
			break;
		case 4:
			viewByName(table_name,customerService);
			break;
		case 5:
			deleteCustomer(table_name,customerService);
			break;
		case 6:
			updateCustomer(table_name,customerService);
			break;
		case 7:
			customerService.clearTable(table_name);
			break;
		case 8:
			customerService.deleteEntireTable(table_name);
			break;
			default:
				System.out.println("Invalid entry");
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void updateCustomer(String table_name, CustomerService customerService) {
		// TODO Auto-generated method stub
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter the id");
		String tempid = scanner3.next();
		int id = Integer.parseInt(tempid);
		System.out.println("Enter the first name");
		String tempfname = scanner3.next();
		System.out.println("Enter the last name");
		String templname = scanner3.next();
		System.out.println("Enter the email id");
		String tempmail = scanner3.next();
		CustomerDetails customer = new CustomerDetails(id,tempfname,templname,tempmail);
		customerService.updateCustomerDetails(table_name, customer);
		
		
	}

	private static void deleteCustomer(String table_name, CustomerService customerService) {
		// TODO Auto-generated method stub
		Scanner scanner6 = new Scanner(System.in);
		System.out.println("Enter the id: ");
		String id = scanner6.next();
		int uid = Integer.parseInt(id);
		customerService.deleteCustomerDetails(table_name, uid);
		
	}

	private static void viewByName(String table_name, CustomerService customerService) {
		// TODO Auto-generated method stub
		Scanner scanner5 = new Scanner(System.in);
		System.out.println("Enter the name: ");
		String name = scanner5.next();
		System.out.println(customerService.viewCustomerbyName(table_name, name));
	}

	private static void viewById(String table_name, CustomerService customerService) {
		// TODO Auto-generated method stub
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("Enter the id: ");
		String choice  = scanner4.next();
		int ch = Integer.parseInt(choice);
		try {
			System.out.println(customerService.viewCustomerbyId(table_name, ch).getDetails());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addCustomer(String table_name, CustomerService customerService) {
		// TODO Auto-generated method stub
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter the id");
		String tempid = scanner3.next();
		int id = Integer.parseInt(tempid);
		System.out.println("Enter the first name");
		String tempfname = scanner3.next();
		System.out.println("Enter the last name");
		String templname = scanner3.next();
		System.out.println("Enter the email id");
		String tempmail = scanner3.next();
		
		CustomerDetails customer = new CustomerDetails(id,tempfname,templname,tempmail);
		try {
			customerService.addCustomer(table_name, customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}

