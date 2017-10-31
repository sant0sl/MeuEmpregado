package com.meuempregado.dao;

public class FactoryDao <E> extends GenericDao<E>{

	public static <E> InterfaceDao<E> createGenericDao(Class<E> entityClass) {
		System.out.println("entrou factory");
		return new GenericDao<E>(entityClass);
	}
	
}