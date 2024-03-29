package br.com.softwareOptimus.dao.fiscal;
import java.util.List;

import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;


public interface CodTabelaGovDAO {

	public List<CodTabelaGov> listaVig(TipoProduto tipo);
	public void remover(Long idVig);
	public void salvar(CodTabelaGov tbGov);
	public CodTabelaGov editVig(Long idVig);
	public void salvaVig2(CodTabelaGov tbGov);
}
