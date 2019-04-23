package com.model.services;

public interface IPaypalService {

	Double interestSimple(double amount, int month);

	Double taxPayment(double amount);

}
