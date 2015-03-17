package br.com.softwareOptimus.financeiro.RN;

import java.util.List;
import br.com.softwareOptimus.com.financeiro.dao.ExtratoContaDAO;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.ExtratoContaBancaria;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.DAOFactory;

public class ExtratoContaRN {

	private ExtratoContaDAO extratoDAO;
	private ExtratoContaBancaria extrato;

	public ExtratoContaRN() {
		extratoDAO = DAOFactory.criaExtratoConta();
	}

	public void inclusao(List<Titulo> titulos, ContaBancaria contaBancaria)
			throws Exception {
		Double saldo = this.extratoDAO.saldoReg(contaBancaria);
		if (saldo == null) {
			saldo = 0.0;
		}
		for (Titulo titulo : titulos) {
			extrato.setRubrica(titulo.getRubrica());
			if (titulo.getTipoTitulo() == TipoTitulo.PAGAR) {
				extrato.setDebito(titulo.getValor());
				saldo = saldo - titulo.getValor();
			} else {
				extrato.setCredito(titulo.getValor());
				saldo = saldo + titulo.getValor();
			}
			extrato.setTitulo(titulos);
			extrato.setContaBancaria(contaBancaria);
			extrato.setDescricao(titulo.getDescricao());
			extrato.setSaldo(saldo);
		}
		this.extratoDAO.inclusao(extrato);
	}

	public ExtratoContaDAO getExtratoDAO() {
		return extratoDAO;
	}

	public void setExtratoDAO(ExtratoContaDAO extratoDAO) {
		this.extratoDAO = extratoDAO;
	}

	public ExtratoContaBancaria getExtrato() {
		return extrato;
	}

	public void setExtrato(ExtratoContaBancaria extrato) {
		this.extrato = extrato;
	}

}
