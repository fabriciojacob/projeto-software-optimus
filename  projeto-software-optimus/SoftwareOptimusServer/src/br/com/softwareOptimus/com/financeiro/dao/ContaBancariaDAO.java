package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.TipoContaBancaria;

public interface ContaBancariaDAO {

	public void excluirConta(ContaBancariaDAO conta) throws Exception;

	public void salvarConta(ContaBancariaDAO conta) throws Exception;

	public List<ContaBancariaDAO> pesquisarConta(String titular, Integer agencia,
			Integer conta, TipoContaBancaria tipoContaBancaria) throws Exception;
	
	public void begin() throws IOException, SQLException;
	
	public void close()throws Exception;

}
