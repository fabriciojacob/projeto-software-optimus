package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Estado;

public class EstadoDAOHibernate implements EstadoDAO {

	private EntityManager session;
	private EntityTransaction transaction;

	@Override
	public List<Estado> listar() {
		String jpql = "Select uf From Estado uf";
		TypedQuery<Estado> listaEstado = this.session.createQuery(jpql,
				Estado.class);
		return listaEstado.getResultList();
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

}
