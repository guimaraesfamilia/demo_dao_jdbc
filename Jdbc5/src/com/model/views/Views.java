package com.model.views;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Department;
import com.model.entities.Seller;
import com.model.enums.TypeEntities;
import com.model.services.IOperationsCrud;

public class Views {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);
	private static int opc = 0;
	private static IOperationsCrud oper = null;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		// listTables();
		chooseMenu();
		sc.close();
	}

	private static void chooseMenu() {

		do {
			mainMenu();
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				listTables();
				break;
			case 2:
				registerDepartment();
				break;
			case 3:
				registerSeller();
				break;
			case 4:
				deleteRegisterDeparment();
				break;
			case 5:
				deleteRegisterSeller();
				break;
			case 6:
				mainMenu();
				break;
			case 7:
				System.out.println(" Closing program!");
				System.exit(0);
			default:
				break;
			}

			System.out.print(" Digit 7 to exit or 1 to return main menu.: ");
			opc = sc.nextInt();

		} while (opc != 7);

		System.out.println(" Closing program!");
		opc = 0;
	}

	private static void mainMenu() {

		System.out.println("");
		System.out.println("-------------------------- Menu -----------------------------");
		System.out.println();
		System.out.println(" 1-) View Table");
		System.out.println(" 2-) Registration Department");
		System.out.println(" 3-) Registration Seller");
		System.out.println(" 4-) Delete Register Department");
		System.out.println(" 5-) Delete Register Seller");
		System.out.println(" 6-) Return main menu");
		System.out.println(" 7-) Exit");

		System.out.println();
		System.out.print(" Choose option.: ");

	}

	private static void listTables() {

		System.out.println();
		System.out.println(" 1-) View table Department");
		System.out.println(" 2-) View table Seller");
		System.out.println();
		System.out.print(" Choose option.: ");
		opc = sc.nextInt();

		System.out.println();

		TypeEntities tp = TypeEntities.values()[opc - 1];
		oper = tp.obterOperation();

		System.out.println(" ---------------------- Table " + tp.toString() + " ------------------------ ");
		System.out.println();
		oper.list();
		opc = 0;

		System.out.println();
		System.out.println(" Consult realizeded with sucessfuly.");

		System.out.println(" -------------------------------------------------------------- ");

	}

	private static void registerDepartment() {

		int rowsaffected = 0;

		System.out.println();
		System.out.println(" Register Department");
		System.out.println();
		System.out.print(" How many register department? ");
		int n = sc.nextInt();

		System.out.println();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {

			System.out.printf(" Department #%d: %n", i);

			System.out.print(" Name.: ");
			String name = sc.nextLine();

			oper = new Department(name);
			if (oper.insert() > 0) {

				rowsaffected++;
			}

			System.out.println();

		}
		System.out.println();
		System.out.printf(" Done! %d rows affected.%n", rowsaffected);
		System.out.println(" Register saving with sucessfuly!");
		System.out.println();
	}

	private static void registerSeller() {

		int rowsaffected = 0;

		System.out.println();
		System.out.println(" -------------------- Register Sellers -------------------- ");
		System.out.println();
		System.out.print(" How many register seller? ");
		int n = sc.nextInt();

		System.out.println();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {

			System.out.printf(" Seller #%d: %n", i);

			try {

				System.out.print(" Name.: ");
				String name = sc.nextLine();

				System.out.print(" Email.: ");
				String email = sc.nextLine();

				System.out.print(" BirthDate (DD/MM/YYYY).: ");
				Date birthdate = new java.sql.Date(sdf.parse(sc.next()).getTime());

				System.out.print(" Base Salary.: ");
				double basesalary = sc.nextDouble();

				System.out.print(" Department.: ");
				int departmentid = sc.nextInt();

				oper = new Seller(name, email, birthdate, basesalary, departmentid);

				rowsaffected = oper.insert();
				rowsaffected++;

			} catch (ParseException e) {

				System.out.println("Date is invalid. " + e.getMessage());
			}

			System.out.println();
			sc.nextLine();
		}
		System.out.println();
		System.out.printf(" Done! %d rows affected.%n", rowsaffected);
		System.out.println(" Register saving with sucessfuly!");
		System.out.println();
		System.out.println(" -------------------- End -------------------- ");
	}

	private static void deleteRegisterDeparment() {

		int rowsaffected = 0;

		System.out.println();
		System.out.println(" -------------------- Delete Department -------------------- ");
		System.out.println();
		System.out.print(" How register department delete? ");
		int n = sc.nextInt();

		oper = new Department();
		rowsaffected = oper.delete(n);

		System.out.println();
		System.out.printf(" Deleted! %d rows deleted.%n", rowsaffected);
		System.out.println(" Register deleted with sucessfuly!");
		System.out.println();
		
		
	}

	private static void deleteRegisterSeller() {

		int rowsaffected = 0;

		System.out.println();
		System.out.println(" -------------------- Delete Sellers -------------------- ");
		System.out.println();
		System.out.print(" How register seller delete? ");
		int n = sc.nextInt();

		oper = new Seller();
		rowsaffected = oper.delete(n);

		System.out.println();
		System.out.printf(" Deleted! %d rows deleted.%n", rowsaffected);
		System.out.println(" Register deleted with sucessfuly!");
		System.out.println();

	}

}
