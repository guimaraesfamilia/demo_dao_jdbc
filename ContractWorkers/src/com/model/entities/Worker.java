package com.model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.model.services.HourContract;
import com.model.services.WorkerLevel;

public class Worker {

	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
	private static double sum;

	private String name;
	private WorkerLevel level;
	private Double basesalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	private static String date;
	private static HourContract contract;

	public Worker() {
		super();
	}

	public Worker(String name, WorkerLevel level, Double basesalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.basesalary = basesalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBasesalary() {
		return basesalary;
	}

	public void setBasesalary(Double basesalary) {
		this.basesalary = basesalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}

	public void addContract(HourContract contract) {

		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {

		this.contracts.remove(contract);
	}

	public Double income(int year, int month) {

		sum = this.getBasesalary();
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {

			cal.setTime(c.getDate());

			int c_month = 1 + cal.get(Calendar.MONTH);
			int c_year = cal.get(Calendar.YEAR);

			date = String.valueOf(month) + "/" + String.valueOf(year);

			if (month == c_month && c_year == year) {

				sum = sum + c.totalValue();

			}
		}

		return sum;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Name.: " + this.getName() + "\n");
		sb.append("Department.: " + this.getDepartment().getName() + "\n");
		sb.append("Income for " + date + ": " + String.format("%.2f", this.sum) + "\n");

		return sb.toString();
	}
}
