package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import br.com.softwareOptimus.financeiro.Banco;

public interface BancoDAO {
	
	public List<Banco> pesquisa() throws Exception;
	public Banco banco(String id) throws Exception;
}
