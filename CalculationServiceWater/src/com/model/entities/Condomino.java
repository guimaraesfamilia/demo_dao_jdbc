package com.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Condomino {

	
	private String name;
	private String apto;
	
	

	public Condomino() {
		super();
	}

	public Condomino(String name, String apto) {
		super();
		this.name = name;
		this.apto = apto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApto() {
		return apto;
	}

	public void setApto(String apto) {
		this.apto = apto;
	}
}
