package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.Banco;

public interface BancoDAO {
	
	public List<Banco> pesquisa() throws Exception;
	
	public Banco banco(String id) throws Exception;
	
	public void being() throws IOException, SQLException;
	
	public void close() throws Exception;
	
	

}
