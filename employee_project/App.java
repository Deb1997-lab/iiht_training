package employee_project;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.Vector;


public class App {

	public static void main(String[] args) {
		Vector<Employee> v = new Vector<Employee>();
		Scanner scanner1 = new Scanner(System.in);
		Emp_Gen gen = new Emp_Gen();
		Employee e;
		
		int choice=0;
		 do {
			 System.out.println("1. Enter new employee details-------->");
			 System.out.println("2. View employee details------------->");
			 System.out.println("3. Update employee information------->");
			 System.out.println("4. Delete employee------------------->");
			 System.out.println("0. Exit------------------------------>");
			 System.out.print("Enter your choice: ");
			 String choice_1 = scanner1.next();
			 choice = Integer.valueOf(choice_1);
			 
			 switch(choice) {
			 case(1):
				 e = gen.createEmployee();
				 v.add(e);
				 System.out.println("Employee created successfully.");
				 break;
			 case(2):
				 displayEmployee(v);
			 	 break;
			 case (3):
				 updateEmployee(v);
			 	 break;
			 case (4):
				 deleteEmployee(v);
			 	 break;
			 case(0):
				 System.out.println("<--Good Bye!-->");
			 	 System.exit(0);
			 	 break;
			 default:
				 System.out.println("Invalid choice!");
				 break;
			 }
		 }while(choice!=0);
		 scanner1.close();
		 
	}
	private static void displayEmployee(Vector<Employee> v) {
        if (v.isEmpty()) {
            System.out.println("No employees found.");
        } else {
           Enumeration<Employee> emp1 = v.elements();
           while(emp1.hasMoreElements()) {
        	   System.out.println("========= "+emp1.nextElement()+" ===========");
           }
           
        }
    }
	 private static void updateEmployee(Vector<Employee> v) {
		 if (v.isEmpty()) {
	            System.out.println("No employees found.");
	        } else {
	            Scanner scanner = new Scanner(System.in);
	            Emp_Gen gen1 = new Emp_Gen();
	            Employee updated_emp;
	            System.out.print("Enter the ID of the employee to update: ");
	            String employeeId = scanner.next();
	            updated_emp = gen1.updateEmployee(employeeId); 
	            boolean found = false;

	            Enumeration<Employee> e1 = v.elements();
	            while (e1.hasMoreElements()) {
	                Employee employee = e1.nextElement();
	                String e_id = employee.getEmp_id();
	                if (e_id.equals(employeeId)) {
	                    v.remove(employee);
	                    found = true;
	                    break;
	                }
	            }
	            v.add(updated_emp);
	            if (found) {
	                System.out.println("Employee with ID " + employeeId + " updated successfully.");
	            } else {
	                System.out.println("Employee with ID " + employeeId + " not found.");
	            }
	            
	            

	        }
	 }

	 private static void deleteEmployee(Vector<Employee> v) {
	        if (v.isEmpty()) {
	            System.out.println("No employees found.");
	        } else {
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter the ID of the employee to delete: ");
	            String employeeId = scanner.next();
	            boolean found = false;

	            Enumeration<Employee> e1 = v.elements();
	            while (e1.hasMoreElements()) {
	                Employee employee = e1.nextElement();
	                String e_id = employee.getEmp_id();
	                if (e_id.equals(employeeId)) {
	                    v.remove(employee);
	                    found = true;
	                    break;
	                }
	            }

	            if (found) {
	                System.out.println("Employee with ID " + employeeId + " deleted successfully.");
	            } else {
	                System.out.println("Employee with ID " + employeeId + " not found.");
	            }
	            scanner.close();
	        }
	    }

}
