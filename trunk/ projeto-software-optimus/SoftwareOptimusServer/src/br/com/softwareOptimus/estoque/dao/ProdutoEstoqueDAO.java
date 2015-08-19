package br.com.softwareOptimus.estoque.dao;

import java.util.List;

import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.bens.PesquisaEstoquePojo;

public interface ProdutoEstoqueDAO {

	public List<ProdutoEstoque> retCustoMedioProduto(ProdutoEstoque produtoEstoque);
	public void salvarProdEstoque(ProdutoEstoque produtoEstoque, Integer Situacao, Long tipoMovEst);
	public int countMovProdutoEstoque(PesquisaEstoquePojo dadosPesquisaEstoquePojo);
	public List<ProdutoEstoque> buscaMovProdutoEstoque(PesquisaEstoquePojo dadosPesquisaEstoquePojo);
}
