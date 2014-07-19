package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.softwareOptimus.produto.Produto;

public class ProdutoDAOHibernate implements ProdutoDAO {

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
	public void salvar(Produto produto) {
		this.session.persist(produto);
		this.transaction.commit();
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

}
