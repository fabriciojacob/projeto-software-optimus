package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;


public interface TipoProdutoDAO {

	void begin() throws IOException, SQLException;
	void close() throws Exception;

}
