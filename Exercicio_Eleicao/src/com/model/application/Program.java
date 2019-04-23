package com.model.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votos = new LinkedHashMap<>();

		System.out.println();
		System.out.print("Enter the path.: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				int quantity = Integer.parseInt(fields[1]);

				if (votos.containsKey(name)) {

					int qtdvotos = votos.get(name);
					votos.put(name, quantity + qtdvotos);
				} else {

					votos.put(name, quantity);
				}

				line = br.readLine();
			}

			for (String list : votos.keySet()) {

				System.out.println(list + " " + votos.get(list));
			}

		} catch (Exception e) {

			System.out.println("Erro.: " + e.getMessage());
		}

		sc.close();

	}

}
