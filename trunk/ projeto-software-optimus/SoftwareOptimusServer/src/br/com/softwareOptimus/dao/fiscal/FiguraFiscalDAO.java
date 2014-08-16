package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.fiscal.FiguraFiscal;

public interface FiguraFiscalDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salva(FiguraFiscal figura);

}
