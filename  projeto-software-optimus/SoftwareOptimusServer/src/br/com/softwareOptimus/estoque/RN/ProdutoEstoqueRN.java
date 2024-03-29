package br.com.softwareOptimus.estoque.RN;

import java.util.List;

import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.bens.PesquisaEstoquePojo;
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

	public Integer validaCamposPesquisa(PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		Integer retorno = 0;
		if(dadosPesquisaEstoquePojo.getProduto().getIdProduto() == null || 
		   dadosPesquisaEstoquePojo.getEmpresa().getIdPessoa() == null || 
		   dadosPesquisaEstoquePojo.getDataFim() == null || 
		   dadosPesquisaEstoquePojo.getDataIni() == null){
			retorno = 1;
		}
		return retorno;
	}

	public List<ProdutoEstoque> buscaMovProduto(PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		return this.prodDAO.buscaMovProdutoEstoque(dadosPesquisaEstoquePojo);
	}
	
	public int countMovProdutoEstoque(PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		return this.prodDAO.countMovProdutoEstoque(dadosPesquisaEstoquePojo);
	}
}
