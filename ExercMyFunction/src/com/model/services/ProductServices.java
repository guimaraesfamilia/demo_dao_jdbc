package com.model.services;

import java.util.List;
import java.util.function.Predicate;

import com.model.entities.Product;

public class ProductServices {

	public Double filteredsum(List<Product> product,Predicate<Product> criteria) {

		double sum = 0.0;

		for (Product p : product) {

			if (criteria.test(p)) {

				sum += p.getPrice();
			}

		}
		return sum;
	}

}
