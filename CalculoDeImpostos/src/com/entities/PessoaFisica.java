package com.entities;

public class PessoaFisica extends Pessoa implements ICalculoImp {

	private Double gastosaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaanual, Double gastosaude) {
		super(nome, rendaanual);
		this.setGastosaude(gastosaude);
	}

	
	public Double getGastosaude() {
		return gastosaude;
	}

	public void setGastosaude(Double gastosaude) {
		this.gastosaude = gastosaude;
	}

	@Override
	public Double imposto() {

		double imp = 0.0;

		if (super.getRendaanual() <= 20000.00) {

			imp = super.getRendaanual() - (super.getRendaanual() * 0.15);
		} else {

			imp = (super.getRendaanual() * 0.25) - (this.getGastosaude() * 0.50);
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
