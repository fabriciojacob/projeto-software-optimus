package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.produto.Grupo;

public interface GrupoDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(Grupo grupo);
	public void alterar(Grupo grupo);

}
