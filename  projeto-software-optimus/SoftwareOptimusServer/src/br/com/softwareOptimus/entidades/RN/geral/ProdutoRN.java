package br.com.softwareOptimus.entidades.RN.geral;

import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoRN {
	
	private ProdutoDAO produtoDao;
	
	public ProdutoRN(){
		this.produtoDao = DAOFactory.criaProdutoDAO();
	}
	
	public void salvar(Produto p1){
		this.produtoDao.salvar(p1);
	}

}
