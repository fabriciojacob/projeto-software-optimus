package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.Caixa;

public interface CaixaDAO {

	public void salvar(Caixa caixa) throws Exception;

	public void begin() throws IOException, SQLException;

	public void excluir(Caixa caixa) throws Exception;

	public List<Caixa> pesquisaCaixa(String descricao) throws Exception;
	
	public void close() throws Exception;
	
	public void editar(Caixa caixa) throws Exception;
	
	public Caixa pesquisaID(Long id) throws Exception;

}
