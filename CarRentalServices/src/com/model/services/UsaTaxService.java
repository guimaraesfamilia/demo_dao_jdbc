package com.model.services;

public class UsaTaxService implements ITaxService {

	@Override
	public double tax(double amount) {
		
		
		
		if(amount <= 100.00) {
			
			return amount * 0.25;
		}
		else {
			
			return amount * 0.20;
		}
	}
}
