package com.model.entities;

public class Vehicle {

	
	private String model;

	public Vehicle() {
		super();
	}

	public Vehicle(String model) {
		super();
		this.setModel(model);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
