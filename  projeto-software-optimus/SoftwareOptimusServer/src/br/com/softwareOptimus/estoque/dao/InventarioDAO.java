package br.com.softwareOptimus.estoque.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface InventarioDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
