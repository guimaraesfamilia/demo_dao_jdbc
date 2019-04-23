package com.model.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import com.model.entities.Product;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Product>list = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD case", 80.90));
		
		
		Predicate<Product> pred = p -> p.getPrice()>= 100;
		
		
		list.removeIf(p -> p.getPrice() >= 100.00);
		
		//list.removeIf(new ProductPredicate());
		//list.removeIf(Product :: staticProductPredicate);
		//list.removeIf(Product :: nonStaticProductPredicate);
		//list.removeIf(pred);
		
		
		for(Product lp : list) {
			
			System.out.println(lp.toString());
		}
		
		
	}

}
