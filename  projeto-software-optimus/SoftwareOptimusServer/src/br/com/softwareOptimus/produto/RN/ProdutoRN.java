package br.com.softwareOptimus.produto.RN;

import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoRN {
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criaProdutoDAO();
	}
	
	public void salvar(Produto produto){
		this.produtoDAO.salvar(produto);
	}

}
