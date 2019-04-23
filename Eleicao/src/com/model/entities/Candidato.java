package com.model.entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class Candidato {

	private String name;
	private Integer quantity;
	private Map<Candidato, Integer> candidato = new LinkedHashMap<>();

	public Candidato() {
		super();
	}

	public Candidato(String name) {
		super();
		this.setName(name);
	}

	public Candidato(String name, Integer quantity) {
		super();
		this.setName(name);
		this.setQuantity(quantity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public int sumTotalVotos(int amount) {

		return this.getQuantity() + amount;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Map<Candidato, Integer> getCandidato() {
		return candidato;
	}

	public void setCandidato(Map<Candidato, Integer> candidato) {
		this.candidato = candidato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Candidato list : candidato.keySet()) {

			sb.append(list.name + " - " + candidato.get(list));
			
		}
		sb.append("\n");

		return sb.toString();
	}

}
