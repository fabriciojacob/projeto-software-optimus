package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.ExtratoContaBancaria;

public class ExtratoContaDAOHibernate implements ExtratoContaDAO{
	
	private EntityManager secao;
	private EntityTransaction transacao;

	@Override
	public void begin() throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inclusao(ExtratoContaBancaria extrato) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double saldoReg(ContaBancaria contaBancaria) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
