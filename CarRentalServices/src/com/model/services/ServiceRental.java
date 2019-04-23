package com.model.services;

import com.model.entities.CarRental;
import com.model.entities.Invoice;

public class ServiceRental {

	private static double basicpayment;

	private Double priceperhour;
	private Double priceperday;

	private ITaxService itaxservice;

	public ServiceRental() {
		super();
	}

	public ServiceRental(Double priceperhour, Double priceperday) {
		super();
		this.setPriceperhour(priceperhour);
		this.setPriceperday(priceperday);
		//this.setItaxservice(itaxservice);
	}

	public Double getPriceperhour() {
		return priceperhour;
	}

	public void setPriceperhour(Double priceperhour) {
		this.priceperhour = priceperhour;
	}

	public Double getPriceperday() {
		return priceperday;
	}

	public void setPriceperday(Double priceperday) {
		this.priceperday = priceperday;
	}

	public ITaxService getItaxservice() {
		return itaxservice;
	}

	public void setItaxservice(ITaxService itaxservice) {
		this.itaxservice = itaxservice;
	}

	public void processInvoice(CarRental carrental, int tipotax) {

		long t1 = carrental.getStart().getTime();
		long t2 = carrental.getFinish().getTime();

		double hours = (double) (t2 - t1) / 1000 / 60 / 60;

		if (hours <= 12) {

			basicpayment = this.getPriceperhour() * Math.ceil(hours);
		} else {

			basicpayment = this.getPriceperday() * Math.ceil(hours / 24);
		}

		
		TipoTaxServicePais tp = TipoTaxServicePais.values()[tipotax - 1];
		itaxservice = tp.obtertax();
		
		double tax = itaxservice.tax(basicpayment);
		carrental.setInvoice(new Invoice(basicpayment, tax));

	}

}
