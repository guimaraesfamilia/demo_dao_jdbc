package com.model.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Product;
import com.model.services.CalculationService;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static List<Product> listprod = new ArrayList<>();

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		readFile();
		sc.close();
	}

	private static void readFile() {

		String path = "/home/temp/in";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				listprod.add(new Product<>(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();

			}
			Product maxValue = CalculationService.max(listprod);
			System.out.println("Most expensive:");
			System.out.println(maxValue);
			
			

		} catch (Exception e) {

			System.out.println("Erro: " + e.getMessage());
		}

	}

}
