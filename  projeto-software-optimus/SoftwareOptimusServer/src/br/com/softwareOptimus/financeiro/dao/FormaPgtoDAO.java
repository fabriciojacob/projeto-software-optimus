package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import br.com.softwareOptimus.financeiro.FormaPgto;

public interface FormaPgtoDAO {
	
	public void salvar(FormaPgto formaPgto) throws Exception;
	public void excluir(FormaPgto formaPgto) throws Exception;
	public List<FormaPgto> lista(String descricao) throws Exception;
	public void editar(FormaPgto formaPgto) throws Exception;
	public FormaPgto selecionar(Long id) throws Exception;
}
