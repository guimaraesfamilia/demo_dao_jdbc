package com.model.entities;

import java.util.function.Function;

public class CaixaAlta implements Function<Product, String> {

	@Override
	public String apply(Product p) {
		// TODO Auto-generated method stub
		return p.getName().toUpperCase();
	}

}
