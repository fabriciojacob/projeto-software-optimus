package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Caixa;

public class CaixaDAOHibernate implements CaixaDAO {

	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void salvar(Caixa caixa) throws Exception {
		this.session.persist(caixa);
		if (!this.transacao.isActive()) {
			this.transacao.isActive();
		}
		this.transacao.commit();
	}
	
	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

	}

	@Override
	public void excluir(Caixa caixa) throws Exception {
		this.session.remove(caixa);
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}
		this.transacao.commit();

	}

	@Override
	public List<Caixa> pesquisaCaixa(String descricao) throws Exception {
		String jpql = "Select c From Caixa c where c.descricao LIKE :parCaixa";
		TypedQuery<Caixa> consulta = this.session
				.createQuery(jpql, Caixa.class);
		consulta.setParameter("parCaixa", "%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public void close() throws Exception {
		this.session.close();

	}

	@Override
	public void editar(Caixa caixa) throws Exception {
		this.session.merge(caixa);
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}
		this.transacao.commit();
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
	public Caixa pesquisaID(Long id) throws Exception {
		return this.session.find(Caixa.class, id);
	}

}
