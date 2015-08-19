package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.produto.Produto;

public interface ProdutoDAO {
	
	public void alterar(Produto produto);
	public void remover(Produto produto);
	public List<Produto> consultaId(long id);
	public List<Produto> consultaDesc(String busca);
	public List<Produto> listar();
	public Produto editPro(Long id);
	public List<Produto> buscaProdutoPaginacao(Produto produto, int first, int pageSize);
	public void definiCondicao(StringBuilder sql, Produto produto);
	public void defineParametros(Query qry, Produto produto);
	public int countProdutoPaginacao(Produto produto);
	public List<Produto> consultDescPag(String desc, int first, int pageSize) throws Exception;
	public int countProdutoDesc(String desc) throws Exception;
	public void salvar(Produto produto);
}
