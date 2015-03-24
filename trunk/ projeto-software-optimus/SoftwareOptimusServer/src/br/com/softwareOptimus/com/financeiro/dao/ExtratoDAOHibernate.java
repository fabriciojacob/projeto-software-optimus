package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;

public class ExtratoDAOHibernate implements ExtratoDAO {

	private EntityManager secao;
	private EntityTransaction transacao;

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.secao.getTransaction();
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

	}

	@Override
	public void close() throws Exception {
		this.transacao.commit();
		this.secao.close();

	}

	@Override
	public void inclusao(Extrato extrato) throws Exception {
		this.secao.persist(extrato);
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}
		this.transacao.commit();

	}

	@Override
	public Double saldoReg(ContaBancaria contaBancaria, Caixa caixa)
			throws Exception {
		String jpql = "Select t.saldo from Extrato t "
				+ " where t.idExtrato = (select max(t2.idExtrato) "
				+ " from Extrato t2"
				+ "  where t2.contaBancaria = :parConta or t2.caixa = :parCaixa) ";
		TypedQuery<Double> consulta = this.secao
				.createQuery(jpql, Double.class);
		consulta.setParameter("parConta", contaBancaria);
		consulta.setParameter("parCaixa", caixa);
		return consulta.getSingleResult();
	}

	public EntityManager getSecao() {
		return secao;
	}

	public void setSecao(EntityManager secao) {
		this.secao = secao;
	}

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

}
