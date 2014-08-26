package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.TipoContaBancaria;

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
	public void excluirConta(ContaBancariaDAO conta) throws Exception {
		this.session.remove(conta);
		this.transacao.commit();
	}

	@Override
	public void salvarConta(ContaBancariaDAO conta) throws Exception {
		this.session.persist(conta);
		this.transacao.commit();
	}

	@Override
	public List<ContaBancariaDAO> pesquisarConta(String titular, Integer agencia,
			Integer conta, TipoContaBancaria tipoConta) throws Exception {
		String jpql = null;
		TypedQuery<ContaBancariaDAO> consulta = this.session.createQuery(jpql,
				ContaBancariaDAO.class);
		if (titular.equals(null)) {
			jpql = "Select c from ContaBancaria c where c.agencia = :parAgencia"
					+ " and c.conta = :parConta"
					+ " and c.tipoContaBancaria = :parTipoConta";
			consulta.setParameter("parAgencia", agencia);
			consulta.setParameter("parConta", conta);
			consulta.setParameter("parTipoConta", tipoConta);
		} else {
			jpql = "Select c from ContaBancaria c where c.titular = :parTitular";
			consulta.setParameter("parTitular", titular);
		}
		return consulta.getResultList();
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if(!this.transacao.isActive()){
			this.transacao = this.session.getTransaction();
		}
		
	}

	@Override
	public void close() throws Exception {
		this.session.close();
		
	}

}
