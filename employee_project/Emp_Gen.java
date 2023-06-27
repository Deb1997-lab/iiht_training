package employee_project;
import java.util.UUID;
import java.util.Scanner;

public class Emp_Gen {
	private Scanner scanner = new Scanner(System.in);
	
	public Employee createEmployee() {
		Employee emp = new Employee();
		System.out.println("Enter Employee Name: ");
		String emp_name = scanner.next();
		System.out.println("Enter Employee Gender: ");
		String emp_gender = scanner.next();
		System.out.println("Enter salary: ");
		int emp_sal = scanner.nextInt();
		System.out.println("Enter Department Name: ");
		String dept_name = scanner.next();
		Department dept = createDepartment(dept_name);
		emp.setEmp_name(emp_name);
		emp.setEmp_gender(emp_gender);
		emp.setEmp_id(UUID.randomUUID().toString());
		emp.setEmp_salary(emp_sal);
		emp.setDepartment(dept);
		return emp;
		
	}
	
	public Employee updateEmployee(String id) {
		Employee emp_up = new Employee();
		System.out.println("Enter Employee Name: ");
		String emp_name = scanner.next();
		System.out.println("Enter Employee Gender: ");
		String emp_gender = scanner.next();
		System.out.println("Enter salary: ");
		int emp_sal = scanner.nextInt();
		System.out.println("Enter Department Name: ");
		String dept_name = scanner.next();
		Department dept = createDepartment(dept_name);
		emp_up.setEmp_name(emp_name);
		emp_up.setEmp_gender(emp_gender);
		emp_up.setEmp_id(id);
		emp_up.setEmp_salary(emp_sal);
		emp_up.setDepartment(dept);
		return emp_up;
	}
	
	private Department createDepartment(String deptName) {
		Department dept = new Department();
		System.out.println("Enter city name: ");
		String city = scanner.next();
		System.out.println("Enter state name: ");
		String state = scanner.next();
		System.out.println("Enter zip code: ");
		String zip = scanner.next();
		System.out.println("Enter country name: :");
		String country = scanner.next();
		Location loc = createLocation(city,state,country,zip);
		dept.setDep_name(deptName);
		dept.setDep_id(UUID.randomUUID().toString());
		dept.setDep_loc(loc);
		return dept;
	}
	

	
	private Location createLocation(String city, String state, String country, String zip) {
		Location location = new Location();
		location.setCity_name(city);
		location.setState_name(state);
		location.setCountry_name(country);
		location.setZip_code(zip);
		return location;
	}
	

}
