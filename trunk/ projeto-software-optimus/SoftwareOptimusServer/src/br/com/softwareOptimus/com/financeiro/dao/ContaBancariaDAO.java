package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.TipoContaBancaria;

public interface ContaBancariaDAO {

	public void excluirConta(ContaBancaria conta) throws Exception;

	public void salvarConta(ContaBancaria conta) throws Exception;
	
	public void alterar(ContaBancaria conta) throws Exception;

	public List<ContaBancaria> pesquisarConta(String titular, Integer agencia,
			Integer conta, TipoContaBancaria tipoContaBancaria) throws Exception;
	
	public void begin() throws IOException, SQLException;
	
	public void close()throws Exception;

}
