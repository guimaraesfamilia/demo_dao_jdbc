package com.model.entities;

public class Product<T> implements Comparable<Product> {

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

		return this.getName() + "," + String.format("%.2f", this.getPrice());
	}

	@Override
	public int compareTo(Product other) {
		// TODO Auto-generated method stub
		return price.compareTo(other.getPrice());
	}

}
