package com.meuempregado.service;

import java.util.List;

public interface InterfaceService <T> {
	public void inserir(T entity);
	public void excluir(Integer id);
	public void alterar(T entity);
	public List<T> listar();
	public T obter(Integer id);

}