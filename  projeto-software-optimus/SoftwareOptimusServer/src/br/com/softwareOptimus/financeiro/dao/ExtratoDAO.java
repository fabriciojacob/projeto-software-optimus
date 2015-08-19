package br.com.softwareOptimus.financeiro.dao;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;

public interface ExtratoDAO {

	public void inclusao(Extrato extrato) throws Exception;
	public Double saldoReg(ContaBancaria contaBancaria, Caixa caixa) throws Exception;
	public List<Extrato> pesquisaExtrato (Date dataIni, Date dataFim, ContaBancaria conta, 
			Caixa caixa) throws Exception;
}
