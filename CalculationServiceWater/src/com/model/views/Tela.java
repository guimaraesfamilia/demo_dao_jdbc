package com.model.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Condomino;
import com.model.entities.Leitura;
import com.model.services.CalculationServiceSabesp;

public class Tela {

	private static double sum;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);
	private static Condomino condomino = null;

	private static List<CalculationServiceSabesp> calc = new ArrayList<>();
	private static List<Leitura> leituras = new ArrayList<>();
	private static Leitura leitura = null;

	public static void mainProgram() throws ParseException {

		Locale.setDefault(Locale.US);
		enterDataLeitura();
		SomaLeitura();
		listLeitura();
		sc.close();
	}

	private static void enterDataLeitura() throws ParseException {

		System.out.println();

		System.out.println("Dados da Leitura de agua");
		System.out.print("Date leitura.: ");
		Date date = sdf.parse(sc.next());

		System.out.print("Valor Sabesp.: ");
		double valueacount = sc.nextDouble();

		System.out.print("Qtd Leituras.: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println();
			System.out.print("Nome.: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Apto.: ");
			String apto = sc.next();
			sc.nextLine();

			condomino = new Condomino(name, apto);

			System.out.print("Leitura Anterior.: ");
			double lanterior = sc.nextDouble();

			System.out.print("Leitura Atual   .: ");
			double latual = sc.nextDouble();

			leitura = new Leitura(date, valueacount, lanterior, latual, condomino);
			leitura.totalConsumo();
			leituras.add(leitura);
			leitura.addLeitura(leitura);		
			leitura.SomaTotalConsumo();
			
			System.out.println();

		}

	}
	
	private static void SomaLeitura() {

		for(Leitura soma : leituras) {
			
			sum += soma.SomaTotalConsumo();
		}
		
	}

	private static void listLeitura() {

		System.out.println("");
		System.out.println("Leituras:");
		
		for(Leitura list :leituras) {
			
			System.out.println(list.toString());
		}
		System.out.println();		
		System.out.println("Total Consumo.: "+String.format("%.0f", sum));
		System.out.println("Coef.: "+String.format("%.8f",leitura.getValueacount()/sum));
		
	}
};