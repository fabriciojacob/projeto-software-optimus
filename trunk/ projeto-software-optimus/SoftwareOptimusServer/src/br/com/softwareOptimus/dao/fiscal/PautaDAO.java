package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.fiscal.Pauta;

public interface PautaDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(Pauta pauta);

}
