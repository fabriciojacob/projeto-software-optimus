package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.produto.Produto;

public interface ProdutoDAO {
	
	public void salvar(Produto produto);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
