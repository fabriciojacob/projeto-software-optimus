package br.com.softwareOptimus.estoque.RN;

import br.com.softwareOptimus.estoque.dao.InventarioDAO;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoEstoqueRN {
	
	@SuppressWarnings("unused")
	private InventarioDAO invetDAO;
	@SuppressWarnings("unused")
	private ProdutoEstoqueDAO prodDAO;
	
	public ProdutoEstoqueRN(){
		this.invetDAO = DAOFactory.criaInventarioDAO();
		this.prodDAO = DAOFactory.criaProdutoEstoqueDAO();
	}

}
