package com.model.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.model.entities.CaixaAlta;
import com.model.entities.Product;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Product>list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("Hd Case", 80.90));
		
		
		
		//Function<Product, String> func = p -> p.getName().toUpperCase();
		//List<String> name = list.stream().map(func).collect(Collectors.toList());
		
		//List<String> name =  list.stream().map(new CaixaAlta()).collect(Collectors.toList());
		
		//List<String> name =  list.stream().map(Product :: staticUpperCaseName).collect(Collectors.toList());	
		
		//List<String> name = list.stream().map(Product :: nonStaticUpperCaseName).collect(Collectors.toList());
		
		List<String> name = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		
		
		name.forEach(System.out :: println);
		
		
	}

}
