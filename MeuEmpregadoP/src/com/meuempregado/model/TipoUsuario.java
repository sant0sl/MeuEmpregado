package com.meuempregado.model;

public enum TipoUsuario {
	EMPREGADO("Sou Empregado"), EMPREGADOR("Sou Empregador");
	
	private String nome;
	
	private TipoUsuario(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
