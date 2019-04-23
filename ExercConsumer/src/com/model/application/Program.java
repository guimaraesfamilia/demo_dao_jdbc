package com.model.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;

import com.model.entities.Product;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("Hd Case", 80.90));

		System.out.print("Informe a porcetagem de reajuste.: ");
		double percent = sc.nextDouble();

		Consumer<Product> cons = p -> p.setPrice(p.getPrice() + (p.getPrice() * (percent / 100)));

		// list.forEach(new ConsumerProduct());
		// list.forEach(Product :: staticConsumerProduct);
		// list.forEach(Product :: nonStaticConsumerProduct);
		// list.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		list.forEach(cons);
		System.out.println();
		list.forEach(System.out::println);

	}

}
