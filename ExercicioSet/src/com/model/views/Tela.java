package com.model.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.model.entities.LogEntry;

public class Tela {

	private static Scanner sc = new Scanner(System.in);

	public static void mainProgram() {

		enterData();
		sc.close();
	}

	private static void enterData() {

		System.out.println();
		System.out.print("Enter file full path.: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry>set = new HashSet<>();
			
			String line = br.readLine();
			
			while(line != null) {
				
				String[] fields = line.split(" ");
				String name = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(name, moment));
				line = br.readLine();
			}
			
			System.out.println("Total users.: "+set.size());
			System.out.println(set.toString());
			
		} catch (Exception e) {

			System.out.println("Erro.: " + e.getMessage());

		}
	}

}
