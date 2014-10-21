package br.com.softwareOptimus.estoque.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface ProdutoEstoqueDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
