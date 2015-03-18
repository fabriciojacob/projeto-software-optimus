package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.ExtratoContaBancaria;

public class ExtratoContaDAOHibernate implements ExtratoContaDAO {

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
	public void inclusao(ExtratoContaBancaria extrato) throws Exception {
		this.secao.persist(extrato);

	}

	@Override
	public Double saldoReg(ContaBancaria contaBancaria) throws Exception {
		String jpql = "Select t.saldo from ExtratoContaBancaria t "
				+ " where t.idExtratoC = (select max(t2.idExtratoC) "
				+ " from ExtratoContaBancaria)"
				+ "  and t.contaBancaria = :parConta ";
		TypedQuery<Double> consulta = this.secao
				.createQuery(jpql, Double.class);
		consulta.setParameter("parConta", contaBancaria);
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
