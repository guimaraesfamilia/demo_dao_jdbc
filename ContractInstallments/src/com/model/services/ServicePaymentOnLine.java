package com.model.services;

import java.util.Calendar;
import java.util.Date;

import com.model.entities.Contract;
import com.model.entities.Installment;

public class ServicePaymentOnLine {

	private static double basicinstallment;
	private IPaypalService ipaypalservice;

	public ServicePaymentOnLine() {
		super();
	}

	public ServicePaymentOnLine(IPaypalService ipaypalservice) {
		super();
		this.setIpaypalservice(ipaypalservice);
	}

	public IPaypalService getIpaypalservice() {
		return ipaypalservice;
	}

	public void setIpaypalservice(IPaypalService ipaypalservice) {
		this.ipaypalservice = ipaypalservice;
	}

	public void processInstallments(Contract contract, int month) {

		basicinstallment = contract.getContractvalue() / month;
		
		
		for(int i = 1; i <= month; i++) {
			
			Date datepgs = addMonths(contract.getDatecontract(), i);
			double upvalue = basicinstallment + ipaypalservice.interestSimple(basicinstallment, i);
			double valuefinal = upvalue + ipaypalservice.taxPayment(upvalue);
			contract.addInstallment(new Installment(datepgs, valuefinal));
		}
	}

	public Date addMonths(Date date, int n) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();

	}

}
