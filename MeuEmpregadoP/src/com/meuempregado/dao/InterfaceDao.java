package com.meuempregado.dao;

import java.util.List;

public interface InterfaceDao <T>{

	public void inserir(T entity);
	public void excluir(int id);
	public void alterar(T entity);
	public List<T> listar();
	public T obter(int id);
	
}
