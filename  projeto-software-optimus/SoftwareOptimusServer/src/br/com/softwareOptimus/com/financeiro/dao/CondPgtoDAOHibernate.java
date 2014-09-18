package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;

import br.com.softwareOptimus.financeiro.CondPgto;

public class CondPgtoDAOHibernate implements CondPgtoDAO {

	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void salvar(CondPgto condPgto) throws Exception {
		this.session.persist(condPgto);
		this.transacao.commit();
	}

	@Override
	public void editar(CondPgto condPgto) throws Exception {
		this.session.merge(condPgto);
		this.transacao.commit();
	}

	@Override
	public void excluir(CondPgto condPgto) throws Exception {
		this.session.remove(condPgto);
		this.transacao.commit();
	}

	@Override
	public List<CondPgto> listar() throws Exception {
		String jpql = "Select e from CondPgto e";
		TypedQuery<CondPgto> consulta = this.session.createQuery(jpql,
				CondPgto.class);
		return consulta.getResultList();
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if(!this.transacao.isActive()){
			this.transacao.begin();
		}
		
	}

	@Override
	public CondPgto find(Long id) throws Exception {
		return this.session.find(CondPgto.class, id);
	}

}
