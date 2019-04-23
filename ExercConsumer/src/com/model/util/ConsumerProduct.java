package com.model.util;

import java.util.function.Consumer;

import com.model.entities.Product;

public class ConsumerProduct implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		// TODO Auto-generated method stub
		
		p.setPrice(p.getPrice() * 1.1);
		
	}

}
