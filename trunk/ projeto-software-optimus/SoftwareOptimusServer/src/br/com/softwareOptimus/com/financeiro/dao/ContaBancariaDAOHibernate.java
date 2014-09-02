package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.financeiro.ContaBancaria;

public class ContaBancariaDAOHibernate implements ContaBancariaDAO {

	private EntityTransaction transacao;
	private EntityManager session;

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void excluirConta(ContaBancaria conta) throws Exception {
		this.session.remove(conta);
		this.transacao.commit();
	}

	@Override
	public void salvarConta(ContaBancaria conta) throws Exception {
		this.session.persist(conta);
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
	public void close() throws Exception {
		this.session.close();

	}

	@Override
	public void alterar(ContaBancaria conta) throws Exception {
		this.session.merge(conta);

	}

	@Override
	public List<ContaBancaria> pesquisaTitular(String titular) throws Exception {
		String jpql = "Select c from ContaBancaria c where c.titular LIKE :parTitular";
		TypedQuery<ContaBancaria> consulta = this.session.createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parTitular", "%" + titular + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaBancaria> pesquisaAgencia(Integer agencia)
			throws Exception {
		String jpql = "Select c from ContaBancaria c where c.agencia LIKE :parAgencia";
		TypedQuery<ContaBancaria> consulta = this.session.createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parAgencia", "%" + agencia + "%");
		return consulta.getResultList();

	}

	@Override
	public List<ContaBancaria> pesquisaConta(Integer conta) throws Exception {
		String jpql = "Select c From ContaBancaria c where c.conta LIKE :parConta";
		TypedQuery<ContaBancaria> consulta = this.session.createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parConta", "%" + conta + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaBancaria> pesquisaTodos(String titular, Integer conta,
			Integer agencia) throws Exception {
		String jpql = "Select c From ContaBancaria c where c.conta LIKE :parConta "
				+ " and c.titular LIKE :parTitular"
				+ " and c.agencia LIKE :parAgencia";
		TypedQuery<ContaBancaria> consulta = this.session.createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parConta", "%" + conta + "%");
		consulta.setParameter("parTitular", "%" + titular + "%");
		consulta.setParameter("parAgencia", "%" + agencia + "%");
		return consulta.getResultList();
	}

}
