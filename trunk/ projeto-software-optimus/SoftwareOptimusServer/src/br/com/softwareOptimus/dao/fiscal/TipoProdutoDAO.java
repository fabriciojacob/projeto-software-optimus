package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;


public interface TipoProdutoDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
