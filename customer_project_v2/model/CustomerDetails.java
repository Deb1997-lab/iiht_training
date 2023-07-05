package com.ibm.customer_project_v2.model;

public class CustomerDetails {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String mail_id;
	
	public CustomerDetails() {

	}

	public CustomerDetails(int customer_id, String first_name, String last_name, String mail_id) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mail_id = mail_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getDetails() {
		return "\n<<<----- id: "+customer_id+" name: "+first_name+" "+last_name+" email id: "+mail_id+" ----->>>";
	}
	
	
	
	
	
	
}
