package com.model.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Contract;
import com.model.entities.Installment;
import com.model.services.PaypalServicePayment;
import com.model.services.ServicePaymentOnLine;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static List<Installment>listinstallments = new ArrayList<>();
	private static Contract contract = null;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		enterDataContract();
		listInstallments();
		sc.close();
	}

	private static void enterDataContract() {

		try {

			System.out.println();
			System.out.println("Enter contract data");
			System.out.print("Number.: ");
			int number = sc.nextInt();

			System.out.print("Date (DD/MM/YYYY).: ");
			Date datecontract = sdf.parse(sc.next());

			System.out.print("Contract value.: ");
			double contractvalue = sc.nextDouble();

			System.out.print("Enter number of installments: ");
			int ninstallments = sc.nextInt();

			contract = new Contract(number, datecontract, contractvalue);

			ServicePaymentOnLine service = new ServicePaymentOnLine(new PaypalServicePayment());
			service.processInstallments(contract, ninstallments);

		} catch (ParseException e) {

			System.out.println("Erro: " + e.getMessage());

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}

	}
	private static void listInstallments() {
		
		System.out.println("");
		System.out.println("Installments:");
		for(Installment list : contract.getInstallments()) {
			
			System.out.println(list.toString());
		}
	}

}
