package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;

public interface CategoriaDAO {
	
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;


}
