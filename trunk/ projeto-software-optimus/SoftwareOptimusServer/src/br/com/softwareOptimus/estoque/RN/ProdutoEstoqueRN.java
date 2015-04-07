package br.com.softwareOptimus.estoque.RN;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.dao.InventarioDAO;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAO;
import br.com.softwareOptimus.produto.Produto;
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
		List<ProdutoEstoque> result;
		result = prodDAO.retCustoMedioProduto(produtoEstoque);
		if(result.size() > 0){
			return result.get(0).getCustoMedio();
		}
		return 0.0;
	}

	public Integer validaCampoNulo(ProdutoEstoque produtoEstoque, Double quantEntSai) {
		Integer retorno = 0;
		
		if(produtoEstoque.getJustificativa() == "" || produtoEstoque.getData() == null || 
		   produtoEstoque.getTipoMovEst() == null || quantEntSai == null || produtoEstoque.getCustoMedio() == null ||
		   produtoEstoque.getTotalCusto() == null){
			retorno =1;
		}
		if(quantEntSai <= 0 || produtoEstoque.getTotalNota() <= 0 || produtoEstoque.getCustoMedio() <= 0){
			retorno=1;
		}
		
		return retorno;
	}

	public void salvar(ProdutoEstoque produtoEstoque, Integer i, Long tipoMovEst) {
		prodDAO.salvarProdEstoque(produtoEstoque, i, tipoMovEst);
	}

	public Integer validaCamposPesquisa(Produto produto, Pessoa empresa,
			Date dataFim, Date dataIni) {
		Integer retorno = 0;
		if(produto.getIdProduto() == null || empresa.getIdPessoa() == null || dataFim == null || dataIni == null){
			retorno = 1;
		}
		return retorno;
	}

	public List<ProdutoEstoque> buscaMovProduto(Produto produto,
			Pessoa empresa, Date dataFim, Date dataIni,
			ProdutoEstoque produtoEstoque) {
		return this.prodDAO.buscaMovProdutoEstoque(produto, empresa, dataFim, dataIni, produtoEstoque);
	}
}
