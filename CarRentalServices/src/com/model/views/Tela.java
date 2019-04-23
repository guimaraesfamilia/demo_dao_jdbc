package com.model.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.CarRental;
import com.model.entities.Vehicle;
import com.model.services.ServiceRental;

public class Tela {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	private static Scanner sc = new Scanner(System.in);
	private static CarRental carrental = null;
	public static void mainProgram() {
		
		Locale.setDefault(Locale.US);
		enterDataRental();
		invoice();
		sc.close();
	}
	private static void enterDataRental() {
		
		
		try {
			
			
			System.out.println();
			System.out.println("Enter rental data");
			System.out.println();
			System.out.print("Car model.: ");
			String name = sc.nextLine();
			
			System.out.print("Pickup (DD/MM/YYYY hh:mm).: ");
			Date start = sdf.parse(sc.nextLine());
			
			System.out.print("Return (DD/MM/YYYY hh:mm).: ");
			Date finish = sdf.parse(sc.nextLine());
			
			System.out.print("What pais to calculation tax service 1-)Brazil, 2-) USA, 3-)Canadá.: ");
			int tipotax = sc.nextInt();
			
			carrental = new CarRental(start, finish, new Vehicle(name));
			
			System.out.print("Enter price per hour.: ");
			double priceperhour = sc.nextDouble();
			
			System.out.print("Enter price per day.: ");
			double priceperday = sc.nextDouble();
			

			ServiceRental svrenta = new ServiceRental(priceperhour, priceperday);
			svrenta.processInvoice(carrental,tipotax);
			
			
			
		}
		catch (ParseException e) {
			
			System.out.println("Error: "+e.getMessage());
		}
	
	}
	private static void invoice() {
		
		System.out.println();
		System.out.println("INVOICE:");
		System.out.println(carrental.getInvoice().toString());
	}
	
}
