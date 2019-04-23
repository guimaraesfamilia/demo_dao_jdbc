package com.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String name;
	private Double price;
	private Integer quantity;

	private List<Product> listproduct = new ArrayList<>();

	public Product() {
		super();
	}

	public Product(String name, Double price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Product> getListproduct() {
		return listproduct;
	}

	public void setListproduct(List<Product> listproduct) {
		this.listproduct = listproduct;
	}

	public void addProduct(Product product) {

		this.listproduct.add(product);
	}

	public void removeProduct(Product product) {

		this.listproduct.remove(product);
	}

	public Double totalValue() {

		return this.getPrice() * this.getQuantity();

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.getName() + "," + String.format("%.2f", totalValue()));

		return sb.toString();
	}

}
