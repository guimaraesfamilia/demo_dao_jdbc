package com.model.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Client;
import com.model.entities.Order;
import com.model.entities.OrderItem;
import com.model.entities.Product;
import com.model.enums.OrderStatus;

public class Tela {

	private static SimpleDateFormat sdfmoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdfbirthdate = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);

	private static OrderStatus status;
	private static Client client = null;
	private static Order order = null;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		enterClientData();
		enterOrderData();
		orderSummary();
		sc.close();
	}

	private static void enterClientData() {

		try {

			System.out.println("Enter cliente data:");
			System.out.print("Name.: ");
			String name = sc.nextLine();
			

			System.out.print("Email.: ");
			String email = sc.nextLine();

			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birthdate = sdfbirthdate.parse(sc.next());

			client = new Client(name, email, birthdate);

		} catch (ParseException e) {

			System.out.println("Date is invalid." + e.getMessage());
			return;

		} catch (Exception e) {

			System.out.println("Erro inesperado." + e.getMessage());
			return;
		}

		System.out.println();
	}

	private static void enterOrderData() {

		
		
		
		System.out.println("Enter order data:");
		System.out.print("Status.: ");
		status = status.valueOf(sc.next().toUpperCase());

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();

		System.out.println();

		Date datemoment = new Date();
		order = new Order(datemoment, status, client);
		
		for (int i = 1; i <= n; i++) {

			System.out.printf("Enter #%d item data: %n", i);
			System.out.print("Product name.: ");
			String productname = sc.next();
			sc.nextLine();

			System.out.print("Product price.: ");
			double price = sc.nextDouble();

			System.out.print("Quantity.: ");
			int quantity = sc.nextInt();

			OrderItem orderitem = new OrderItem(quantity, price, new Product(productname, price));
			order.addItem(orderitem);

			System.out.println();
		}

	}

	private static void orderSummary() {

		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());

	}

}
