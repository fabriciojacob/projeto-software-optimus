package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

public interface GradeTributariaDAO {
	
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void altGrade(GradeTributariaVigencia grade);
	public void salva(GradeTributariaVigencia grade);
	public void remover(GradeTributariaVigencia grade);
}
