package abstraction.example1.model;
import java.util.Scanner;

public abstract class EmployeeService {
	public EmployeeService() {
		
	}
	public Scanner scanner = new Scanner(System.in);
	
	public Employee createEmployee() {
		System.out.println("Enter the first name: ");
		String fname = scanner.next();
		System.out.println("Enter the last name: ");
		String lname = scanner.next();
		System.out.println("Enter the id: ");
		String id = scanner.next();
		System.out.println("Enter email: ");
		String email = scanner.next();
		System.out.println("Enter salary: ");
		long salary = scanner.nextLong();
		Employee e1 = new Employee(fname, lname, id, email, salary);
		return e1;
	}
	
	public Employee updateEmployee(String id) {
		System.out.println("Enter the first name: ");
		String fname = scanner.next();
		System.out.println("Enter the last name: ");
		String lname = scanner.next();
		System.out.println("Enter email: ");
		String email = scanner.next();
		System.out.println("Enter salary: ");
		long salary = scanner.nextLong();
		Employee e1_up = new Employee(fname, lname, id, email, salary);
		return e1_up;
	}

	
	
	
	
	
}
