package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.produto.UnidMed;

public interface UnidMedDAO {

	public void salvar(UnidMed unid);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
