package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.Estado;

public interface EstadoDAO {

	public List<Estado> listar();
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;

}
