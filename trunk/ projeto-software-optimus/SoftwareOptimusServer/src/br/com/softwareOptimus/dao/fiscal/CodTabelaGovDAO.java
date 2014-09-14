package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;


public interface CodTabelaGovDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<CodTabelaGov> listaVig(TipoProduto tipo);
	public void remover(Long idVig);
	public void salvar(CodTabelaGov tbGov);
	public CodTabelaGov editVig(Long idVig);
}
