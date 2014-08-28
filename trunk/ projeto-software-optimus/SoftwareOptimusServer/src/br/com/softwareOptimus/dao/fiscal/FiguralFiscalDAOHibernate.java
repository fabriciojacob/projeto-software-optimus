package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.softwareOptimus.fiscal.FiguraFiscal;

public class FiguralFiscalDAOHibernate implements FiguraFiscalDAO {
	
	private EntityManager session;
	private EntityTransaction transaction;
	
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

	@Override
	public void salva(FiguraFiscal figura) {
		this.session.persist(figura);
		this.transaction.commit();
	}

	@Override
	public void altFigura(FiguraFiscal figura) {
		this.session.merge(figura);
		this.transaction.commit();
	}

	@Override
	public void remover(FiguraFiscal figura) {
		this.session.remove(figura);
		this.transaction.commit();
	}

	@Override
	public List<FiguraFiscal> consultaId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FiguraFiscal> consultaDesc(String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FiguraFiscal> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
