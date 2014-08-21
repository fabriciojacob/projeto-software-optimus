package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

public interface GradeTributariaVigenciaDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<GradeTributariaVigencia> listaVig(GradeTributaria grade);
}
