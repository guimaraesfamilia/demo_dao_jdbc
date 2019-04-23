package com.model.services;

import java.util.Date;

public class HourContract {

	
	private Date date;
	private Double valueperhour;
	private Integer hours;
	
	public HourContract() {
		super();
	}

	public HourContract(Date date, Double valueperhour, Integer hours) {
		super();
		this.setDate(date);
		this.setValueperhour(valueperhour);
		this.setHours(hours);
	}

	public Date getDate() {
		return date;
	}

	private void setDate(Date date) {
		this.date = date;
	}

	public Double getValueperhour() {
		return valueperhour;
	}

	private void setValueperhour(Double valueperhour) {
		this.valueperhour = valueperhour;
	}

	public Integer getHours() {
		return hours;
	}

	private void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public Double totalValue() {
		
		return this.getValueperhour() * this.getHours();
	}
	
	
	
}
