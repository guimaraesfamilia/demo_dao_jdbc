package com.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date duedate;
	private Double amount;

	public Installment() {
		super();
	}

	public Installment(Date duedate, Double amount) {
		super();
		this.setDuedate(duedate);
		this.setAmount(amount);
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {

		return sdf.format(this.getDuedate()) + " - " + String.format("%.2f", this.amount);
	}
}
