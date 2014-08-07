package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.softwareOptimus.fiscal.Aliquota;

public class AliquotaDAOHibernate implements AliquotaDAO {

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
	public List<Aliquota> consultar(Long id) {
		return null;
	}

	@Override
	public void altUnid(Aliquota aliquota) throws Exception {
		
	}

	@Override
	public Aliquota editBusc(Long id) {
		return null;
	}

	@Override
	public void remover(Long id) throws Exception {
	
	}

	@Override
	public List<Aliquota> lista() {
		return null;
	}

	@Override
	public void salvar(Aliquota aliq) {
		
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
	public void salva(Aliquota aliquota) {
		this.session.persist(aliquota);
		this.transaction.commit();
	}
}
