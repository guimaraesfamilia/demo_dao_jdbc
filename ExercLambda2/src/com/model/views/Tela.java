package com.model.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.model.entities.Funcionario;

public class Tela {

	private static double sum;
	private static Scanner sc = new Scanner(System.in);

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		readOnFile();
		sc.close();
	}

	private static void readOnFile() {

		List<Funcionario> listfunc = new ArrayList<>();

		System.out.println();
		System.out.print("Enter the path file.: ");
		String pathname = sc.nextLine().toLowerCase();

		System.out.print("Enter value salary.: ");
		double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(pathname))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				listfunc.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.printf("Email of people whose salary is more than %s:", String.format("%.2f", salary));
			System.out.println();

			List<String> emails = listfunc.stream()

					.filter(f -> f.getSalary() > salary).map(e -> e.getEmail()).sorted().collect(Collectors.toList());

			System.out.println();

			for (String list : emails) {

				System.out.println(list.toString());
			}

			List<Funcionario> namesComM = listfunc.stream().filter(n -> n.getName().charAt(0) == 'M')
					.collect(Collectors.toList());

			for (Funcionario list : namesComM) {

				sum += list.getSalary();
			}

			System.out.println();
			System.out.println("Sum of salary of people whose name starts with 'M'.: " + String.format("%.2f", sum));

		} catch (Exception e) {

			System.out.println("Error.: " + e.getMessage());

		}

	}

}
