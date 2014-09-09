package br.com.softwareOptimus.fiscal.RN;

import br.com.softwareOptimus.dao.fiscal.CodTabelaGovDAO;
import br.com.softwareOptimus.dao.fiscal.TipoProdutoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class TipoProdutoRN {
	
	private TipoProdutoDAO tipoProdutoDAO;
	private CodTabelaGovDAO codTbDAO;
	
	public TipoProdutoRN(){
		this.tipoProdutoDAO = DAOFactory.criaTipoProdutoDAO();
		this.codTbDAO = DAOFactory.criaCodTabelaGovDAO();
	}

}
