package br.com.softwareOptimus.produto.bens;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.RN.ProdutoRN;

@ManagedBean(name = "produtoBean")
@ViewScoped
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

	public void salvarProd() {
		try {
			ProdutoRN produtoRN = new ProdutoRN();
			produtoRN.salvar(produto);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Produto salvo com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do produto "
									+ e.getMessage()));
		}

	}

}
