package com.model.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import com.model.entities.Candidato;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static Candidato cand = null;
	private static int value;

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		readFile();
		sc.close();
	}

	private static void readFile() {

		System.out.println();
		System.out.print("Enter the path file.: ");
		String path = sc.nextLine();

		Map<String, Integer> candidato = new LinkedHashMap<>();
		//Map<Candidato, Integer> candidato = new LinkedHashMap<Candidato,Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				int quantity = Integer.parseInt(fields[1]);

				cand = new Candidato(name,quantity);

				if (candidato.containsKey(name)) {

					value = candidato.get(cand.getName());
					candidato.put(cand.getName(),cand.sumTotalVotos(value));

				} else {

					candidato.put(cand.getName(),quantity);
				}
				
				line = br.readLine();
			}

			/*for (String list : candidato.keySet()) {

				System.out.println(list + " " + candidato.get(list));
			}*/
			
			
			
			System.out.println(candidato.toString());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro.: " + e.getMessage());
		}

	}

}
