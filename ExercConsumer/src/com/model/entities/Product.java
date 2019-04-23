package com.model.entities;

public class Product {

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

	public static void staticConsumerProduct(Product p) {

		 p.setPrice(p.getPrice() * 1.1);
	}
	public void nonStaticConsumerProduct() {
		
		this.setPrice(getPrice()*1.1);
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getName() + ", " + String.format("%.2f", this.getPrice()));

		return sb.toString();
	}

}
