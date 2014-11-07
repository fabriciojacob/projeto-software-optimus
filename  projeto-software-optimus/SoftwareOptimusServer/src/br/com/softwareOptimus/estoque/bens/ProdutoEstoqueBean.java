package br.com.softwareOptimus.estoque.bens;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.produto.Produto;

@ManagedBean(name = "produtoEstoqueBean")
@ViewScoped
public class ProdutoEstoqueBean {
	
	private ProdutoEstoque produtoEstoque = new ProdutoEstoque();
	private List<ProdutoEstoque> listaProdutoEstoque = new ArrayList<ProdutoEstoque>();
	private Produto produto = new Produto();
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private Date dataIni, dataFim;
	
	public void pesquisaMovEstoque(){
		
	}
	
	
	
	
	
	public Date getDataIni() {
		return dataIni;
	}
	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public ProdutoEstoque getProdutoEstoque() {
		return produtoEstoque;
	}
	public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	public List<ProdutoEstoque> getListaProdutoEstoque() {
		return listaProdutoEstoque;
	}
	public void setListaProdutoEstoque(List<ProdutoEstoque> listaProdutoEstoque) {
		this.listaProdutoEstoque = listaProdutoEstoque;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
}
