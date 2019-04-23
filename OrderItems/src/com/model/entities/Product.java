package com.model.entities;

public class Product {

	private String name;
	private Double price;
	
	public Product() {
		super();
	}

	public Product(String name, Double price) {
		super();
		this.setName(name);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	private void setPrice(Double price) {
		this.price = price;
	}
}
