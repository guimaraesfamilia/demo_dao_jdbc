package com.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leitura {

	private static double sum;
	private Date date;
	private Double valueacount;
	private Double lanterior;
	private Double latual;

	private Condomino condomino;
	private List<Leitura> leituras = new ArrayList<>();

	public Leitura() {
		super();
	}

	public Leitura(Date date, Double valueacount, Double lanterior, Double latual, Condomino condomino) {
		super();
		this.setDate(date);
		this.setValueacount(valueacount);
		this.setLanterior(lanterior);
		this.setLatual(latual);
		this.setCondomino(condomino);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueacount() {
		return valueacount;
	}

	public void setValueacount(Double valueacount) {
		this.valueacount = valueacount;
	}

	public Double getLanterior() {
		return lanterior;
	}

	public void setLanterior(Double lanterior) {
		this.lanterior = lanterior;
	}

	public Double getLatual() {
		return latual;
	}

	public void setLatual(Double latual) {
		this.latual = latual;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public List<Leitura> getLeituras() {
		return leituras;
	}

	public void setLeituras(List<Leitura> leituras) {
		this.leituras = leituras;
	}

	public void addLeitura(Leitura leitura) {

		this.leituras.add(leitura);
	}

	public void removeLeitura(Leitura leitura) {

		this.leituras.remove(leitura);
	}

	public Double totalConsumo() {

		return this.getLatual() - this.getLanterior();
	}

	public Double SomaTotalConsumo() {

		sum = 0.0;
		for (Leitura total : leituras) {

			sum += total.totalConsumo();
		}
		return sum;
	}

	public Double valueCoef() {

		return this.getValueacount() / this.SomaTotalConsumo();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Apto.: " + this.getCondomino().getApto() + " | Leitura Anterior.: "
				+ String.format("%.3f", this.getLanterior() / 1000) + " | Leitura Atual.: "
				+ String.format("%.3f", this.getLatual() / 1000) + " | Consumo M³.: "
				+ String.format("%.3f", this.totalConsumo() / 1000));

		return sb.toString();
	}
	

}
