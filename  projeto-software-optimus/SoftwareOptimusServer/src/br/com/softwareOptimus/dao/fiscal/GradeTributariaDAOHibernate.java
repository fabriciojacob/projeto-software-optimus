package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.softwareOptimus.fiscal.GradeTributaria;

public class GradeTributariaDAOHibernate implements GradeTributariaDAO {

	private EntityManager session;
	private EntityTransaction transaction;
	
	public EntityManager getSession() {
		return session;
	}
	
	public void setSession(EntityManager session) {
		this.session = session;
	}
	
	public EntityTransaction getTransaction() {
		return transaction;
	}
	
	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
	}
	
	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction.begin();
		}
	}
	
	@Override
	public void close() throws Exception {
		this.session.close();
	}

	@Override
	public void altGrade(GradeTributaria grade) {
		this.session.merge(grade);
		this.transaction.commit();
	}

	@Override
	public void salva(GradeTributaria grade) {
		this.session.persist(grade);
		this.transaction.commit();
	}

	@Override
	public void remover(GradeTributaria grade) {
		this.session.remove(grade);
		this.transaction.commit();
	}
}
