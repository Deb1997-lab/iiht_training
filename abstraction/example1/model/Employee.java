package abstraction.example1.model;

public class Employee {
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private long salary;
	
	
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String id, String email, long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	

	public String getLastName() {
		return lastName;
	}

	

	public String getId() {
		return id;
	}

	

	public String getEmail() {
		return email;
	}

	

	public long getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", email=" + email
				+ ", salary=" + salary + "]";
	}

		
	
	
	
}
