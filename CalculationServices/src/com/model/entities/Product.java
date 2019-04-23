package com.model.entities;

public class Product implements Comparable<Product> {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		super();
		this.setName(name);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getName() + "," + String.format("%.2f", this.getPrice()));

		return sb.toString();
	}

	@Override
	public int compareTo(Product other) {
		
		return price.compareTo(other.getPrice());
	}

	
	
}