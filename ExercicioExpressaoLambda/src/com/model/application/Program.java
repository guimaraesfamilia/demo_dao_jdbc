package com.model.application;

import java.util.ArrayList;
import java.util.List;

import com.model.entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Monitor", 500.0));
		list.add(new Product("Notebook", 1500.0));
		list.add(new Product("PenDrive", 45.0));

		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		for (Product l : list) {

			System.out.println(l.toString());
		}
	}

}
