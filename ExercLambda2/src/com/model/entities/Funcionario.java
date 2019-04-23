package com.model.entities;

public class Funcionario {

	private String name;
	private String email;
	private Double salary;

	public Funcionario(String name, String email, Double salary) {
		super();
		this.setName(name);
		;
		this.setEmail(email);
		this.setSalary(salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getName() + "," + this.getEmail() + "," + this.getSalary());

		return sb.toString();
	}

}
