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

	public void setPrice(Double price) {
		this.price = price;
	}

	public static boolean staticProductPredicate(Product p) {

		return p.getPrice() >= 100.0;
	}
	
	public boolean nonStaticProductPredicate() {
		
		return getPrice() >= 100.0;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
