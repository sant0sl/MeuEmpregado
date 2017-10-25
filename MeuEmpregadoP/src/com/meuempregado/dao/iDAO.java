package com.meuempregado.dao;

import java.util.List;

public interface iDAO<T> {

	public void inserir(T objeto);
	public void alterar(T objeto);
	public void deletar(T objeto);
	public List<T> listarTudo();
	public List<T> buscarPorNome(String nome);
	
}
