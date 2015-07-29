package br.com.softwareOptimus.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.comercial.Requisicao;

public interface RequisicaoDAO {

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;

	public List<Requisicao> lista() throws Exception;

	public Requisicao requisicao(Long id) throws Exception;
	
	public void salvar(Requisicao requisicao) throws Exception;
	
	public void editar(Requisicao requisicao) throws Exception;
	
	public void excluir(Requisicao requisicao) throws Exception;
	
	public List<Requisicao> pesquisaDescricao(String descricao) throws Exception;
	
	public List<Requisicao> pesquisaPeriodo(Date dataIni, Date dataFim) throws Exception;

}
