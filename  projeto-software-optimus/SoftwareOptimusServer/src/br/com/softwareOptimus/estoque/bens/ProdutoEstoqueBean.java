package br.com.softwareOptimus.estoque.bens;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.RN.ProdutoRN;

@ManagedBean(name = "produtoEstoqueBean")
@ViewScoped
public class ProdutoEstoqueBean {
	
	private ProdutoEstoque produtoEstoque = new ProdutoEstoque();
	private List<ProdutoEstoque> listaProdutoEstoque = new ArrayList<ProdutoEstoque>();
	private Produto produto = new Produto();
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private Date dataIni, dataFim;
	private Double quantEntSai;
	private EmpresaRN empRN;
	private ProdutoRN prodRN;
	private Pessoa empresa;
	private Long empresaSelecionada, produtoSelecionado;
	
	public void pesquisaMovEstoque(){
		
	}
	
	public void selecionaEmpresa() {
		this.empRN = new EmpresaRN();
		try {
			this.empresa = this.empRN.pesquisaId(this.empresaSelecionada);
			this.produtoEstoque.setEmpresa(empresa);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Empresa selecionada"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na seleção da empresa "
									+ e.getMessage()));
		}
	}
	
	public void selecionaProduto() {
		this.prodRN = new ProdutoRN();
		try {
			this.produto = this.prodRN.editPro(this.produtoSelecionado);
			this.produtoEstoque.setProduto(produto);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Produto selecionado"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na seleção do Produto "
									+ e.getMessage()));
		}
	}
	
	public Double getQuantEntSai() {
		return quantEntSai;
	}

	public void setQuantEntSai(Double quantEntSai) {
		this.quantEntSai = quantEntSai;
	}

	public Long getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Long produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public Long getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Long empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
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
