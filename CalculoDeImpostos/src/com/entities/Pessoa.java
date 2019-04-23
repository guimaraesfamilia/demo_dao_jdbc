package com.entities;

public abstract class Pessoa {

	
	private String nome;
	private Double rendaanual;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Double rendaanual) {
		super();
		this.setNome(nome);
		this.setRendaanual(rendaanual);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaanual() {
		return rendaanual;
	}

	public void setRendaanual(Double rendaanual) {
		this.rendaanual = rendaanual;
	}
	
	
	
	
}
