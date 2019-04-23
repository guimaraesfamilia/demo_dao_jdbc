package com.model.views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.model.entities.Product;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static List<Product> listprod = new ArrayList<>();
	private static Product product = null;

	private static String pathfile, targetfile, name = null;
	private static double price;
	private static int quantity;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		procediment_0();
		procediment_1();
		procediment_2();
		listProduct();
		sc.close();
	}

	private static void procediment_0() {

		File past = new File("/home/temp/out");
		past.mkdir();
		
		targetfile = past.getPath()+ "/summary.csv";
		
	}

	private static void procediment_1() {

		pathfile = "/home/temp/listproduto";

		try (BufferedReader br = new BufferedReader(new FileReader(pathfile))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");

				name = fields[0];
				price = Double.parseDouble(fields[1]);
				quantity = Integer.parseInt(fields[2]);

				listprod.add(new Product(name, price, quantity));
				line = br.readLine();

			}

		} catch (Exception e) {

			System.out.println("Erro: " + e.getMessage());
		}

	}

	private static void procediment_2() {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetfile))){
			
			for(Product list : listprod) {
				
				bw.write(list.toString());
				bw.newLine();
			}
			
		}
		catch (Exception e) {
			
			System.out.println("Erro: "+e.getMessage());
		}
	}

	private static void listProduct() {

		System.out.println();
		System.out.println("List Products:");
		System.out.println();
		for (Product list : listprod) {

			System.out.println(list.toString());
		}
	}

}
