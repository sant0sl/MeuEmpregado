package com.meuempregado.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDao <T> implements InterfaceDao<T>{
	
	protected EntityManager em;
	
	private Class<T> persistedClass;
	
	protected GenericDao(){}
	
	protected GenericDao(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	@Override
	public void inserir(T entity) {
		em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.flush();
		em.clear();
		em.getTransaction().commit();		
	}

	@Override
	public void excluir(int id) {
		em = Conexao.getInstance().createEntityManager();
		T entity = obter(id);
		em.getTransaction().begin();
		T mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.flush();
		em.clear();
		em.getTransaction().commit();
	}

	@Override
	public void alterar(T entity) {
		em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.flush();
		em.clear();
		em.getTransaction().commit();
		
	}

	@Override
	public List<T> listar() {
		em = Conexao.getInstance().createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return em.createQuery(query).getResultList();
	}

	@Override
	public T obter(int id) {
		em = Conexao.getInstance().createEntityManager();
		return em.find(persistedClass, id);
	}

}
