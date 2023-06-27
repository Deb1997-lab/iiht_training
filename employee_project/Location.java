package employee_project;

public class Location {
	private String city_name;
	private String state_name;
	private String country_name;
	private String zip_code;
	
	
	
	public Location() {
		
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "Location [city_name=" + city_name + ", state_name=" + state_name + ", country_name=" + country_name
				+ ", zip_code=" + zip_code + "]";
	}

	

	
}
