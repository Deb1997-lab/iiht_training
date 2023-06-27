package employee_project;

public class Department {
	private String dep_name;
	private String dep_id;
	private Location dep_loc;
	
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_id() {
		return dep_id;
	}
	public void setDep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	public Location getDep_loc() {
		return dep_loc;
	}
	public void setDep_loc(Location dep_loc) {
		this.dep_loc = dep_loc;
	}
	@Override
	public String toString() {
		return "Department [dep_name=" + dep_name + ", dep_loc=" + dep_loc + "]";
	}
	
	
	
}
