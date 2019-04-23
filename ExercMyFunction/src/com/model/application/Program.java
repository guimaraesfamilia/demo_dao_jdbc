package com.model.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.entities.Product;
import com.model.services.ProductServices;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		System.out.print("Enter caracter filter.: ");
		char caracter = sc.next().toUpperCase().charAt(0);
		
		ProductServices ps = new ProductServices();
		double sum = ps.filteredsum(list, p -> p.getName().charAt(0) == caracter);
	
		System.out.println(String.format("%.2f", sum));
		
		
	}

}
