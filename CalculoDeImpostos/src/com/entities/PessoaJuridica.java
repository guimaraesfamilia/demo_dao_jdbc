package com.entities;

public class PessoaJuridica extends Pessoa implements ICalculoImp {

	private Integer numerofuncionario;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaanual, Integer numerofuncionario) {
		super(nome, rendaanual);
		this.setNumerofuncionario(numerofuncionario);
	}

	
	public Integer getNumerofuncionario() {
		return numerofuncionario;
	}

	public void setNumerofuncionario(Integer numerofuncionario) {
		this.numerofuncionario = numerofuncionario;
	}

	@Override
	public Double imposto() {

		double imp = 0.0;

		if (this.getNumerofuncionario() < 10) {

			imp = super.getRendaanual() * 0.16;
		} else {

			imp = super.getRendaanual() * 0.14;
		}
		return imp;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(super.getNome() + ": $ " + String.format("%.2f", imposto()));

		return sb.toString();
	}
}
