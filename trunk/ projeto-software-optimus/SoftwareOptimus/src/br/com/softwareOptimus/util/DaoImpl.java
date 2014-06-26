package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DaoImpl<T> implements Dao<T> {
	
	private EntityManager em;
	private Class<T> type;
	
	public DaoImpl(EntityManager em, Class<T> type) {
		super();
		this.em = em;
		this.type = type;
	}
	
	protected EntityManager em(){
		return em;
	}

	@Override
	public Dao<T> insere(T elemento) {
		em.persist(elemento);
		return this; 
	}

	@Override
	public Dao<T> atualiza(T elemento) {
		em.merge(elemento);
		return this;
	}

	@Override
	public Dao<T> remove(T elemento) {
		em.remove(elemento);
		return this;
	}

	@Override
	public T get(Long codigo) {
		System.out.println(codigo.toString());
		String jpql = "select e from " + 
  	                  type.getSimpleName() + " e where e.codigo = :codigo";
		
		TypedQuery<T> query = em.createQuery(jpql, type);
		
		query.setParameter("codigo", codigo);
		
		return query.getSingleResult();
	} 

	@Override
	public List<T> all() {
		String jpql = "select e from " + type.getSimpleName() + " e";
		
		try {
			TypedQuery<T> query = em.createQuery(jpql, type);
			return query.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	@Override
	public Dao<T> begin() throws IOException, SQLException {
		EntityTransaction transaction = em.getTransaction();
		
		if(!transaction.isActive()){
			transaction.begin();
		}
		
		return this;
	}

	@Override
	public Dao<T> commit() {
		EntityTransaction transaction = em.getTransaction();
		
		if(transaction.isActive()){
			transaction.commit();
		}
		
		return this;
	}

	@Override
	public Dao<T> rollback() {
		EntityTransaction transaction = em.getTransaction();
		
		if(transaction.isActive()){
			transaction.rollback();
		}
		
		return this;
	}
}

