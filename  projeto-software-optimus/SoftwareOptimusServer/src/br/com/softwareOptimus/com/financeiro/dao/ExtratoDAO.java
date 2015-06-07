package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;

public interface ExtratoDAO {

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;

	public void inclusao(Extrato extrato) throws Exception;

	public Double saldoReg(ContaBancaria contaBancaria, Caixa caixa) throws Exception;
	
	public List<Extrato> pesquisaExtrato (Date dataIni, Date dataFim, ContaBancaria conta, 
			Caixa caixa) throws Exception;
}
