package com.model.entities;

public class OrderItem {

	
	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		super();
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	private void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		
		return this.getQuantity() * this.getPrice();
	}
	
}
