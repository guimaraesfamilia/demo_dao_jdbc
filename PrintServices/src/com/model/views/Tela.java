package com.model.views;

import java.util.Scanner;

import com.model.entities.PrintService;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	
	
	public static void mainProgram() {
		
		enterData();
		sc.close();
	}
	private static void enterData() {
		
		System.out.println();
		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		
		
		PrintService<String> ps = new PrintService<>();
		
		for(int i = 1; i <= n; i++) {
			
			ps.addValue(sc.next());
			
		}
	    ps.print();
	    System.out.println("First: "+ps.first());
		
		
	}
}
