package com.model.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Department;
import com.model.entities.Worker;
import com.model.services.HourContract;
import com.model.services.WorkerLevel;

public class Tela {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);
	private static WorkerLevel level = null;
	private static Worker worker = null;
	private static HourContract contract = null;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		enterDataEmployee();
		enterContractEmployee();
		listageContractEmployee();
		sc.close();
	}

	private static void enterDataEmployee() {

		System.out.println();
		System.out.print("Enter department's name.: ");
		String departmentname = sc.nextLine();

		System.out.println("Enter worker data:");
		System.out.print("Name.: ");
		String name = sc.nextLine();

		System.out.print("Level.: ");
		level = level.valueOf(sc.next());

		System.out.print("Base salary.: ");
		double basesalary = sc.nextDouble();

		worker = new Worker(name, level, basesalary, new Department(departmentname));

	}

	private static void enterContractEmployee() {

		try {

			System.out.print("How many contracts to this worker? ");
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {

				System.out.printf("Enter contract %d data: %n", i);
				System.out.print("Date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());

				System.out.print("Value per hour.: ");
				double valueperhour = sc.nextDouble();

				System.out.print("Duration (hours): ");
				int hours = sc.nextInt();

				contract = new HourContract(date, valueperhour, hours);
				worker.addContract(contract);

				System.out.println();
			}

		} catch (ParseException e) {

			System.out.println("Date is invalid.");

		}

	}
	
	private static void listageContractEmployee() {
		
		
		System.out.println();
		System.out.print("Enter month and year to calculate (MM/YYYY): ");
		String monthandyear = sc.next();
		
		int month = Integer.parseInt(monthandyear.substring(0, 2));
		int year = Integer.parseInt(monthandyear.substring(3));
		
		worker.income(year, month);
		System.out.println(worker.toString());
		
	}

}
