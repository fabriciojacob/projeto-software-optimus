package br.com.softwareOptimus.estoque.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.produto.Produto;

public interface ProdutoEstoqueDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public List<ProdutoEstoque> retCustoMedioProduto(ProdutoEstoque produtoEstoque);
	public void salvarProdEstoque(ProdutoEstoque produtoEstoque, Integer Situacao, Long tipoMovEst);
	public List<ProdutoEstoque> buscaMovProdutoEstoque(Produto produto,	Pessoa empresa, Date dataFim, Date dataIni,	ProdutoEstoque produtoEstoque);
}
