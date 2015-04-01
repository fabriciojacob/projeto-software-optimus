package br.com.softwareOptimus.financeiro.RN;

import java.text.DecimalFormat;
import java.util.Calendar;
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
	private int fase;

	public ExtratoRN() {
		extratoDAO = DAOFactory.criaExtratoConta();
		extrato = new Extrato();
	}

	public int verificaSaldoTitulo(Titulo titulo, Double valor) {
		Double valorCheck = titulo.getValorTitulo() - valor;
		if (valorCheck < 0.0) {
			fase = 1;
		} else if (valorCheck == 0.0) {
			fase = 2;
		} else {
			fase = 3;
		}
		return fase;
	}

	public void estorno(Titulo titulo, ContaBancaria contaBancaria, Caixa caixa)
			throws Exception {
		tituloRN = new TituloRN();
		Double valor;
		Double temp = 0.0;
		valor = titulo.getValor();
		Double saldoExt = this.extratoDAO.saldoReg(contaBancaria, caixa);
		if (titulo.getTipoTitulo().toString() == TipoTitulo.PAGAR.toString()) {
			extrato.setCredito(valor);
			saldoExt = saldoExt + valor;
		} else {
			extrato.setDebito(valor);
			saldoExt = saldoExt - valor;
		}
		if (contaBancaria.isInativa()) {
			extrato.setCaixa(caixa);
		} else {
			extrato.setContaBancaria(contaBancaria);
		}

		if (titulo.getValorTitulo() != titulo.getValor()) {
			temp = titulo.getValorTitulo();
			DecimalFormat df = new DecimalFormat("#.00");
			titulo.setDescEstorno("Valor original do titulo: "
					+ df.format(temp));
			titulo.setValorTitulo(titulo.getValor());
		}
		titulo.setValor(0.0);
		titulo.setStatus(StatusConta.PENDENTE);
		tituloRN.atualizaTitulo(titulo);
		extrato.setRubrica(titulo.getRubrica());
		extrato.setTitulo(titulo);
		extrato.setDescricao("Estorno do titulo " + titulo.getIdTitulo());
		extrato.setSaldo(saldoExt);
		extratoDAO.inclusao(extrato);
	}

	public void inclusao(List<Titulo> titulos, ContaBancaria contaBancaria,
			Caixa caixa) throws Exception {
		Double saldo = 0.0, saldoTitulo = 0.0;
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
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
			extrato.setData(c.getTime());
			saldoTitulo = titulo.getValorTitulo() - titulo.getValor();
			titulo.setDataPagamento(c.getTime());
			titulo.setStatus(StatusConta.BAIXADA);
			this.tituloRN.atualizaTitulo(titulo);
			this.extratoDAO.inclusao(extrato);
			if (saldoTitulo > 0) {
				titulo.setIdTituloPai(titulo.getIdTitulo());
				titulo.setValorTitulo(saldoTitulo);
				titulo.setValor(0.0);
				titulo.setDataPagamento(null);
				titulo.setStatus(StatusConta.PENDENTE);
				titulo.setDescricao("Saldo do titulo " + titulo.getIdTitulo());
				titulo.setIdTitulo(null);
				tituloRN.salvar(titulo, 0);
			}
		}
	}
	
	public void closed() throws Exception {
		this.extratoDAO.close();
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

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

}
