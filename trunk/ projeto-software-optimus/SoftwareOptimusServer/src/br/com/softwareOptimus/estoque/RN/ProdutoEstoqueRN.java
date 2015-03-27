package br.com.softwareOptimus.estoque.RN;

import java.util.List;

import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.dao.InventarioDAO;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoEstoqueRN {
	
	@SuppressWarnings("unused")
	private InventarioDAO invetDAO;
	private ProdutoEstoqueDAO prodDAO;
	
	public ProdutoEstoqueRN(){
		this.invetDAO = DAOFactory.criaInventarioDAO();
		this.prodDAO = DAOFactory.criaProdutoEstoqueDAO();
	}

	public Double retCustoMedioProduto(ProdutoEstoque produtoEstoque) {
		//ProdutoEstoque produtoEstoqueCustoMedio;
		List<Object[]> result;
		
		result = prodDAO.retCustoMedioProduto(produtoEstoque);
		
		return 0.0;
	}

}
