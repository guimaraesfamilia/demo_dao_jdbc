package com.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date datecontract;
	private Double contractvalue;
	private List<Installment> installments = new ArrayList<>();

	public Contract() {
		super();
	}

	public Contract(Integer number, Date datecontract, Double contractvalue) {
		super();
		this.setNumber(number);
		this.setDatecontract(datecontract);
		this.setContractvalue(contractvalue);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDatecontract() {
		return datecontract;
	}

	public void setDatecontract(Date datecontract) {
		this.datecontract = datecontract;
	}

	public Double getContractvalue() {
		return contractvalue;
	}

	public void setContractvalue(Double contractvalue) {
		this.contractvalue = contractvalue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public void addInstallment(Installment installment) {

		this.installments.add(installment);
	}

	public void removeInstallment(Installment installment) {

		this.installments.remove(installment);
	}

}
