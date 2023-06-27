package employee_project;

public class Employee {
	//attributes
	private String emp_name;
	private String emp_gender;
	private String emp_id;
	private int emp_salary;
	private Department department;
	
	public Employee() {
		
	}
	
	public Employee(String emp_name,String emp_gender, String emp_id, int emp_salary, Department department) {
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_id = emp_id;
		if (emp_salary<1000) {
			this.emp_salary = 1000;
		}else {
		this.emp_salary = emp_salary;
		}
		this.department = department;
	}
	

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [emp_name=" + emp_name + ", emp_gender=" + emp_gender + ", emp_id=" + emp_id + ", emp_salary="
				+ emp_salary + ", department=" + department + "]";
	}
	
	
}
