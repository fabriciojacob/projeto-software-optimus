package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.FormaPgto;

public interface FormaPgtoDAO {
	
	public void salvar(FormaPgto formaPgto) throws Exception;
	
	public void excluir(FormaPgto formaPgto) throws Exception;
	
	public List<FormaPgto> lista(String descricao) throws Exception;
	
	public void editar(FormaPgto formaPgto) throws Exception;

	public void begin() throws IOException, SQLException;
	
	public void close() throws Exception;
	
	public FormaPgto selecionar(Long id) throws Exception;
}
