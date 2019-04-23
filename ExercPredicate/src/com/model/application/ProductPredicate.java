package com.model.application;

import java.util.function.Predicate;

import com.model.entities.Product;

public  class ProductPredicate implements Predicate<Product>{

	@Override
	public boolean test(Product p) {
		// TODO Auto-generated method stub
		return p.getPrice() >= 100.00;
	}

}
