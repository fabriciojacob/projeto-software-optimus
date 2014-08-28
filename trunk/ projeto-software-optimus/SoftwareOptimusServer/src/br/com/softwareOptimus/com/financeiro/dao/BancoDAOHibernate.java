package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Banco;

public class BancoDAOHibernate implements BancoDAO{
	
	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public List<Banco> pesquisa() throws Exception {
		String jpql = "Select c from Banco c";
		TypedQuery<Banco> consulta = this.session.createQuery(jpql,Banco.class);
		return consulta.getResultList();
	}

	@Override
	public Banco banco(String id) throws Exception {
		return this.session.find(Banco.class, id);
	}

	@Override
	public void being() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if(!this.transacao.isActive()){
			this.transacao.begin();
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

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

}
