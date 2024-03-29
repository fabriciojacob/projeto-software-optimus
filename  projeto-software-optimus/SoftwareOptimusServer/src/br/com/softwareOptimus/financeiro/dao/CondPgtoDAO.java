package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import br.com.softwareOptimus.financeiro.CondPgto;

public interface CondPgtoDAO {
	
	public void salvar(CondPgto condPgto) throws Exception;
	public void editar(CondPgto condPgto) throws Exception;
	public void excluir(CondPgto condPgto) throws Exception;
	public List<CondPgto> listar() throws Exception;
	public CondPgto find(Long id) throws Exception;
}
