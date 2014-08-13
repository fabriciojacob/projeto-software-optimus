package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.fiscal.PautaMVA;

public interface PautaMVADAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salva(PautaMVA pauta);
	public void alterar(PautaMVA pauta);
	public void remover(PautaMVA pauta);
}
