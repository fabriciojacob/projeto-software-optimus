package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public class RegimeDAOHibernate implements RegimeDAO{
	
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
	public List<VigenciaRegime> listaRegime(PessoaJuridica pessoaJuridica)
			throws Exception {
		String jpql = "Select r from VigenciaRegime r where r.pessaoJuridica = :parPes";
		TypedQuery<VigenciaRegime> consulta = this.session.createQuery(jpql, VigenciaRegime.class);
		consulta.setParameter("parPes", pessoaJuridica);
		return consulta.getResultList();
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
	public void excluirRegime(Long idRegime) throws Exception {
		/*
		 * String jpql =
		 * "Delete from VigenciaRegime v where v.idVigReg = :parVig";
		 * TypedQuery<VigenciaRegime> delete = this.session.createQuery(jpql,
		 * VigenciaRegime.class); delete.setParameter("parVig", idRegime);
		 * this.transaction.commit();
		 */
		VigenciaRegime vig = this.session.find(VigenciaRegime.class, idRegime);
		this.session.remove(vig);
		this.transaction.commit();

	}

}
