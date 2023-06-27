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
			 System.out.println("0. Exit------------------------------>");
			 System.out.print("Enter your choice: ");
			 choice = scanner1.nextInt();
			 
			 switch(choice) {
			 case(1):
				 e = gen.createEmployee();
				 v.add(e);
				 System.out.println("Employee created successfully.");
				 break;
			 case(2):
				 displayEmployee(v);
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

}
