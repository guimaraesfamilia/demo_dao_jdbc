package com.model.services;

public class PaypalServicePayment implements IPaypalService {

	private static double interestsimple = 0.01;
	private static double taxpayment = 0.02;

	@Override
	public Double interestSimple(double amount, int month) {
		// TODO Auto-generated method stub
		return amount * interestsimple * month;
	}

	@Override
	public Double taxPayment(double amount) {
		// TODO Auto-generated method stub
		return amount * taxpayment;
	}

}
