package com.gps.funnymath.game;

import java.io.Serializable;

public class Pontuacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367447286931729107L;
	private String nome;
	private int pontos;
	
	public Pontuacao(int pontos, String nome){
		this.nome = nome;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	

}
