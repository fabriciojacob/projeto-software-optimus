package br.com.softwareOptimus.estoque.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.estoque.ProdutoEstoque;

public interface ProdutoEstoqueDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<ProdutoEstoque> retCustoMedioProduto(ProdutoEstoque produtoEstoque);
	public void salvarProdEstoque(ProdutoEstoque produtoEstoque, Integer Situacao);
}
