package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.fiscal.GradeTributaria;

public interface GradeTributariaDAO {
	
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void altGrade(GradeTributaria grade);
	public void salva(GradeTributaria grade);
	public void remover(GradeTributaria grade);
}
