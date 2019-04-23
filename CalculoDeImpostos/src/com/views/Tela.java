package com.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.entities.ICalculoImp;
import com.entities.Pessoa;
import com.entities.PessoaFisica;
import com.entities.PessoaJuridica;
import com.enums.TipoPlano;

public class Tela {

	private static Scanner sc = new Scanner(System.in);
	private static ICalculoImp icalculoimp = null;
	private static List<Pessoa> listpessoa = new ArrayList<>();

	public static void mainProgram() {

		Locale.setDefault(Locale.US);
		enterData();
		listPayer();
		sc.close();

	}

	private static void enterData() {

		System.out.println();
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		System.out.println();

		for (int i = 1; i <= n; i++) {

			System.out.printf("Tax payer #%d data: %n", i);

			System.out.print("Nome.: ");
			String nome = sc.next();
			sc.nextLine();

			System.out.print("Renda Anual.: ");
			double rendaanual = sc.nextDouble();

			System.out.print("1-) Individual, 2-)Company ?");
			int tipoplano = sc.nextInt();

			TipoPlano tp = TipoPlano.values()[tipoplano - 1];
			icalculoimp = tp.obtercalculo();
			if (tp.ordinal() == 0) {

				System.out.print("Gasto com saude: ");
				double gastosaude = sc.nextDouble();
				icalculoimp = new PessoaFisica(nome, rendaanual, gastosaude);
				icalculoimp.imposto();
				listpessoa.add(new PessoaFisica(nome, rendaanual, gastosaude));

			} else {

				System.out.print("Numero de funcionarios: ");
				int numerofuncionario = sc.nextInt();
				icalculoimp = new PessoaJuridica(nome, rendaanual, numerofuncionario);
				icalculoimp.imposto();
				listpessoa.add(new PessoaJuridica(nome, rendaanual, numerofuncionario));
			}

		}

	}

	private static void listPayer() {

		double sum = 0.0;

		System.out.println();
		System.out.println("TAXES PAID:");

		for (Pessoa ps : listpessoa) {

			System.out.println(ps.toString());
			sum += icalculoimp.imposto();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

	}

}
