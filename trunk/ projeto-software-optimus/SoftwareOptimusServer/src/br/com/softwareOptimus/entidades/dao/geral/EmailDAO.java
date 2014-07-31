package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.entidades.Email;

public interface EmailDAO {
	
	public void salvar(Email email) throws Exception;
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void excluir(Email email) throws Exception;

}
