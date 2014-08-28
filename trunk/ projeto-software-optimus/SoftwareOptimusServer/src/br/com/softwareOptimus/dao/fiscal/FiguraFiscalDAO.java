package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.FiguraFiscal;

public interface FiguraFiscalDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salva(FiguraFiscal figura);
	public void altFigura(FiguraFiscal figura);
	public void remover(FiguraFiscal figura);
	public List<FiguraFiscal> consultaId(long id);
	public List<FiguraFiscal> consultaDesc(String desc);
	public List<FiguraFiscal> listar();

}
