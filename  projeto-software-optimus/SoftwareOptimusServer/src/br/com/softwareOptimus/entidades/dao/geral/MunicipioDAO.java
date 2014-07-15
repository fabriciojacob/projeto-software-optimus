package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;

public interface MunicipioDAO {
	
	public List<Municipio> lista(Estado uf);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
