package br.com.softwareOptimus.produto.bens;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.produto.Produto;

@ManagedBean(name = "produtoBean")
@SessionScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<FiguraFiscal> figura;
	private List<Ncm> ncm;

	public List<Ncm> getNcm() {
		return ncm;
	}

	public void setNcm(List<Ncm> ncm) {
		this.ncm = ncm;
	}

	public List<FiguraFiscal> getFigura() {
		return figura;
	}

	public void setFigura(List<FiguraFiscal> figura) {
		this.figura = figura;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
