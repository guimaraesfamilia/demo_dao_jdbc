package com.model.entities;

public class Department {

	private String name;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

}
