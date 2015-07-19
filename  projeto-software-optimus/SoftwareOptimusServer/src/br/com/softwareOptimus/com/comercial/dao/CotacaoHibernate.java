package br.com.softwareOptimus.com.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.comercial.Cotacao;

public class CotacaoHibernate implements CotacaoDAO {

	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}
	}

	@Override
	public void close() throws Exception {
		this.session.close();
	}

	@Override
	public List<Cotacao> lista() throws Exception {
		String jpql = "Select e from Cotacao";
		TypedQuery<Cotacao> consulta = this.session.createQuery(jpql,
				Cotacao.class);
		return consulta.getResultList();
	}

	@Override
	public Cotacao cotacao(Long id) throws Exception {
		return this.session.find(Cotacao.class, id);
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
