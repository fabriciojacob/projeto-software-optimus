package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import br.com.softwareOptimus.financeiro.ContaBancaria;

public interface ContaBancariaDAO {

	public void excluirConta(ContaBancaria conta) throws Exception;
	public void salvarConta(ContaBancaria conta) throws Exception;
	public void alterar(ContaBancaria conta) throws Exception;
	public List<ContaBancaria> pesquisaTitular(String titular) throws Exception;
	public List<ContaBancaria> pesquisaAgencia(Integer agencia) throws Exception;
	public List<ContaBancaria> pesquisaConta(Integer conta) throws Exception;
	public List<ContaBancaria> pesquisaTodos(String titular, Integer conta, Integer agencia) throws Exception;
	public ContaBancaria pesquisaID(Long id) throws Exception;
	public List<ContaBancaria> listaGeral() throws Exception;

}
