package com.model.entities;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

	private List<T> list = new ArrayList<>();

	public T first() {

		if (list.isEmpty()) {

			throw new IllegalStateException("Lista esta vazia");
		}
		return list.get(0);
	}

	public void addValue(T value) {

		this.list.add(value);
	}

	public void print() {

		if (!list.isEmpty()) {
			System.out.print("[");
			if(!list.isEmpty()) {
				System.out.print(list.get(0));
			}
			for (int i = 1; i < list.size(); i++) {

				System.out.print(", " + list.get(i));
			}
			System.out.println("]");
		}
	}
}
