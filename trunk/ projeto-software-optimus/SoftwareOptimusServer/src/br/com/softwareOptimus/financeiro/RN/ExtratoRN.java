package br.com.softwareOptimus.financeiro.RN;

import java.util.List;

import javax.persistence.NoResultException;

import br.com.softwareOptimus.com.financeiro.dao.ExtratoDAO;
import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;
import br.com.softwareOptimus.financeiro.Rubrica;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.DAOFactory;

public class ExtratoRN {

	private ExtratoDAO extratoDAO;
	private Extrato extrato;

	public ExtratoRN() {
		extratoDAO = DAOFactory.criaExtratoConta();
		extrato = new Extrato();
	}

	public void inclusao(List<Titulo> titulos, ContaBancaria contaBancaria,
			Caixa caixa) throws Exception {
		Double saldo;
		try {
			saldo = this.extratoDAO.saldoReg(contaBancaria, caixa);
		} catch (NoResultException e) {
			saldo = (double) 0;
		}
		if (saldo == null) {
			saldo = 0.0;
		}
		for (Titulo titulo : titulos) {
			if (Rubrica.AUTOMATICA.toString() == titulo.getRubrica().toString()) {
				extrato.setRubrica(Rubrica.AUTOMATICA);
			} else {
				extrato.setRubrica(Rubrica.MANUAL);
			}
			if (titulo.getTipoTitulo().toString() == TipoTitulo.PAGAR
					.toString()) {
				extrato.setDebito(titulo.getValorTitulo());
				saldo = saldo - titulo.getValorTitulo();
			} else {
				extrato.setCredito(titulo.getValorTitulo());
				saldo = saldo + titulo.getValorTitulo();
			}
			extrato.setTitulo(titulos);
			extrato.setContaBancaria(contaBancaria);
			extrato.setCaixa(caixa);
			extrato.setDescricao(titulo.getDescricao());
			extrato.setSaldo(saldo);
			this.extratoDAO.inclusao(extrato);
		}
	}

	public ExtratoDAO getExtratoDAO() {
		return extratoDAO;
	}

	public void setExtratoDAO(ExtratoDAO extratoDAO) {
		this.extratoDAO = extratoDAO;
	}

	public Extrato getExtrato() {
		return extrato;
	}

	public void setExtrato(Extrato extrato) {
		this.extrato = extrato;
	}

}
