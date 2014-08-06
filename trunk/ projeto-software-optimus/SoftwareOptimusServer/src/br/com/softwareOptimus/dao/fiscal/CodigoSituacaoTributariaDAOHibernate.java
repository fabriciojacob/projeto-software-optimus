package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;


public class CodigoSituacaoTributariaDAOHibernate implements
		CodigoSituacaoTributariaDAO {

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
	public List<CodigoSituacaoTributaria> cstListaIcms() {
		String jpql = "Select u From CodigoSituacaoTributaria u Where u.tipoCst = :icms";
		TypedQuery<CodigoSituacaoTributaria> listaCst = this.session
				.createQuery(jpql, CodigoSituacaoTributaria.class);
		listaCst.setParameter("icms", TipoCst.ICMS);
		return listaCst.getResultList();
	}

	@Override
	public List<CodigoSituacaoTributaria> cstListaOut(TipoCst tipo, IO entSai) {
		String jpql = "Select u From CodigoSituacaoTributaria u Where u.tipoCst = :tipo And u.io = :entSai";
		TypedQuery<CodigoSituacaoTributaria> listaCstEnt = this.session
				.createQuery(jpql, CodigoSituacaoTributaria.class);
		listaCstEnt.setParameter("tipo", tipo);
		listaCstEnt.setParameter("entSai", entSai);
		return listaCstEnt.getResultList();
	}
}
