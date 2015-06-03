package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.DAOFactory;

public class ProdutoRN {

	private ProdutoDAO produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criaProdutoDAO();
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
	}

	public Integer validaCampoNulo(Produto produto) {
		Integer retorno = 0;
		if (produto.getDescProd().equals("")
				|| produto.getCodBarra().equals("")
				|| produto.getFigura() == null || produto.getUnidMed() == null
				|| produto.getTipoProd() == null || produto.getSetor() == null
				|| produto.getGrupo() == null || produto.getSubGrupo() == null
				|| produto.getCategoria() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public void altPro(Produto produto) {
		this.produtoDAO.alterar(produto);
	}

	public Integer verificaRemocao(Produto produto) {
		return 0;
	}

	public void remover(Produto produto) {
		this.produtoDAO.remover(produto);
	}

	public List<Produto> consultaId(long id) {
		return this.produtoDAO.consultaId(id);
	}

	public List<Produto> consultaDesc(String busca) {
		return this.produtoDAO.consultaDesc(busca);
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public Produto editPro(Long id) {
		return this.produtoDAO.editPro(id);
	}
	
	public List<Produto> buscaProdutoPaginacao(Produto produto, int first, int pageSize){
		return this.produtoDAO.buscaProdutoPaginacao(produto, first, pageSize);
	}
	
	public int countProdutoPaginacao(Produto produto){
		return this.produtoDAO.countProdutoPaginacao(produto);
	}
}
