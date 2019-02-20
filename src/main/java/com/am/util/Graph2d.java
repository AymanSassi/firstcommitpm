package com.am.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Graph2d {
	@JsonProperty("groupe")
	private String groupe;
	@JsonProperty("ligne")
	private String ligne;
	@JsonProperty("colonne")
	private Long colonne;

	public String getLigne() {
		return ligne;
	}

	public Long getColonne() {
		return colonne;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public void setColonne(Long colonne) {
		this.colonne = colonne;
	}
	
	public Graph2d(String groupe, String ligne, Long colonne) {
		super();
		this.groupe = groupe;
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public Graph2d(String ligne, Long colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
	}

}
