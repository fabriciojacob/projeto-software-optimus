package br.com.softwareOptimus.financeiro.RN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.softwareOptimus.com.financeiro.dao.ExtratoDAO;
import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;
import br.com.softwareOptimus.financeiro.Rubrica;
import br.com.softwareOptimus.financeiro.StatusConta;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.DAOFactory;

public class ExtratoRN {

	private ExtratoDAO extratoDAO;
	private Extrato extrato;
	private TituloRN tituloRN;

	public ExtratoRN() {
		extratoDAO = DAOFactory.criaExtratoConta();
		extrato = new Extrato();
	}

	public void inclusao(List<Titulo> titulos, ContaBancaria contaBancaria,
			Caixa caixa) throws Exception {
		Double saldo;
		Date date = new Date();
		tituloRN = new TituloRN();
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
				extrato.setDebito(titulo.getValor());
				saldo = saldo - titulo.getValor();
			} else {
				extrato.setCredito(titulo.getValor());
				saldo = saldo + titulo.getValor();
			}
			extrato.setTitulo(titulo);
			extrato.setContaBancaria(contaBancaria);
			extrato.setCaixa(caixa);
			extrato.setDescricao(titulo.getDescricao());
			extrato.setSaldo(saldo);
			extrato.setData(date);
			titulo.setSaldo(titulo.getSaldo() - titulo.getValor());
			titulo.setDataPagamento(date);
			titulo.setStatus(StatusConta.BAIXADA);
			this.tituloRN.atualizaTitulo(titulo);
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
