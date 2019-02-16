package com.am.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Graph2d {
	@JsonProperty("ligne")
	private String ligne;
	@JsonProperty("colonne")
	private Long colonne;

	public Graph2d(String ligne, Long colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public String getLigne() {
		return ligne;
	}

	public Long getColonne() {
		return colonne;
	}

}
