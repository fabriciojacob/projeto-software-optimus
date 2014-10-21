package br.com.softwareOptimus.estoque.RN;

import br.com.softwareOptimus.estoque.dao.InventarioDAO;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoEstoqueRN {
	
	private InventarioDAO invetDAO;
	private ProdutoEstoqueDAO prodDAO;
	
	public ProdutoEstoqueRN(){
		this.invetDAO = DAOFactory.criaInventarioDAO();
		this.prodDAO = DAOFactory.criaProdutoEstoqueDAO();
	}

}
