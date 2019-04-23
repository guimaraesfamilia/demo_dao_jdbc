package com.model.entities;

import java.util.Date;

public class Client {

	
	private String name;
	private String email;
	private Date birthdate;
	
	public Client() {
		super();
	}

	public Client(String name, String email, Date birthdate) {
		super();
		this.setName(name);
		this.setEmail(email);
		this.setBirthdate(birthdate);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	private void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
