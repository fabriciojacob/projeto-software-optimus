package br.com.softwareOptimus.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.comercial.Cotacao;

public interface CotacaoDAO {
	
	public void begin() throws IOException, SQLException;
	
	public void close() throws Exception;
	
	public List<Cotacao> lista() throws Exception;
	
	public Cotacao cotacao(Long id) throws Exception;
	
	public void salvar(Cotacao cotacao) throws Exception;
}
