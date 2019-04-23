package com.model.entities;

public class Invoice {

	private Double basicpayment;
	private Double tax;

	public Invoice() {
		super();
	}

	public Invoice(Double basicpayment, Double tax) {
		super();
		this.setBasicpayment(basicpayment);
		this.setTax(tax);
	}

	public Double getBasicpayment() {
		return basicpayment;
	}

	public void setBasicpayment(Double basicpayment) {
		this.basicpayment = basicpayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double totalPament() {

		return this.getBasicpayment() + this.getTax();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Basic payment: " + String.format("%.2f", this.getBasicpayment()) + "\n");
		sb.append("Tax: " + String.format("%.2f", this.getTax()) + "\n");
		sb.append("Total payment: " + String.format("%.2f", this.totalPament()) + "\n");
		return sb.toString();
	}

}
