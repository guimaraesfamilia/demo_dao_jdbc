package com.model.views;

import java.sql.Connection;
import java.util.Scanner;

import com.model.db.DB;

public class Tela {

	private static Scanner sc = new Scanner(System.in);

	public static void mainProgram() {

		choseProcediment();
		sc.close();
	}

	private static void choseProcediment() {

		System.out.print("Chose 1-)Open Connection, 2-)Close Connection.: ");
		int op = sc.nextInt();

		while (op != 0) {

			switch (op) {
			case 1:
				openConnection();
				break;
			case 2:
				closeConnection();

			default:
				break;
			}

			op = sc.nextInt();

		}
		System.out.println("Terminado..");
	}

	private static void openConnection() {

		Connection conn = DB.getConnection();
		System.out.println("Conexao aberta com sucesso!!");
	}

	private static void closeConnection() {

		DB.closeConnection();
		System.out.println("Conexao encerrada com sucesso!!");
	}

}
