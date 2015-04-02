package br.com.softwareOptimus.estoque.bens;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.util.List;

import br.com.softwareOptimus.comercial.Comercial;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.RN.ProdutoEstoqueRN;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.RN.ProdutoRN;

@ManagedBean(name = "produtoEstoqueBean")
@ViewScoped
public class ProdutoEstoqueBean {
	
	private ProdutoEstoque produtoEstoque;
	private List<ProdutoEstoque> listaProdutoEstoque;
	private Produto produto;
	private List<Produto> listaProduto;
	private Date dataIni, dataFim;
	private Double quantEntSai;
	private EmpresaRN empRN;
	private ProdutoRN prodRN;
	private ProdutoEstoqueRN prodEstRN;
	private Pessoa empresa;
	private String tipoMovEstoque;
	private boolean btnAdicionar = true, txtCustoMedio = true;
	private Integer verifica =0;
	private Long empresaSelecionada, produtoSelecionado;
	
	public void pesquisaMovEstoque(){
		Integer Teste = 0;
		
		Teste++;
	}
	
	public void buscaCustoMedio(){
		this.getProdutoEstoque().setCustoMedio(this.getProdEstRN().retCustoMedioProduto(this.getProdutoEstoque()));
		if(this.getProdutoEstoque().getCustoMedio() == 0){
			this.setTxtCustoMedio(false);
		}else{
			this.setTxtCustoMedio(true);
		}
	}
	
	public void selecionaEmpresa() {
		try {
			this.setEmpresa(this.getEmpRN().pesquisaId(this.empresaSelecionada));
			this.getProdutoEstoque().setEmpresa(empresa);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Empresa selecionada"));
			this.verifica = this.verifica + 1;
			if(this.getVerifica() >= 2){
				this.btnAdicionar = false;
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na seleção da empresa "
									+ e.getMessage()));
		}
	}
	
	public void selecionaProduto() {
		try {
			this.setProduto(this.getProdRN().editPro(this.produtoSelecionado));
			this.getProdutoEstoque().setProduto(produto);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Produto selecionado"));
			this.verifica = this.verifica + 1;
			if(this.getVerifica() >= 2){
				this.btnAdicionar = false;
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na seleção do Produto "
									+ e.getMessage()));
		}
	}
	
	public void incluir(){
		Long tipoMovEst = null;
		if(this.getTipoMovEstoque().equals(TipoMovEst.MANUALENTRADA.toString())){
			tipoMovEst = new Long (4);
			this.getProdutoEstoque().setTipoMovEst(TipoMovEst.MANUALENTRADA);
			this.getProdutoEstoque().setQuantEntrada(this.getQuantEntSai());
			this.getProdutoEstoque().setQuantSaida(0.0);
		}else if(this.getTipoMovEstoque().equals(TipoMovEst.MANUALSAIDA.toString())){
			tipoMovEst = new Long (5);
			this.getProdutoEstoque().setTipoMovEst(TipoMovEst.MANUALSAIDA);
			this.getProdutoEstoque().setQuantSaida(this.getQuantEntSai());
			this.getProdutoEstoque().setQuantEntrada(0.0);
			
		}
		
		Integer retorno = this.getProdEstRN().validaCampoNulo(this.getProdutoEstoque(), quantEntSai);
		if (retorno == 0){

			this.getProdutoEstoque().setDespesaNota(0.0);
			this.getProdutoEstoque().setFreteNota(0.0);
			this.getProdutoEstoque().setIcmsNota(0.0);
			this.getProdutoEstoque().setIpiNota(0.0);
			this.getProdutoEstoque().setPisCofinsNota(0.0);
			this.getProdutoEstoque().setCustoNota(this.getProdutoEstoque().getCustoMedio());
			this.getProdutoEstoque().setOrigem(new Comercial());
			this.getProdutoEstoque().getOrigem().setIdComercial(new Long(0));
			this.getProdEstRN().salvar(this.getProdutoEstoque(), 1, tipoMovEst);
		}else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Info",
							"Existem campos nulos no formulário ou zerado! Verifique!"));
		}
	}
	
	public void cancelar(){
		
	}
	
	public void limparInfPesquisa(){
		this.setEmpresa(null);
		this.setProduto(null);
		this.setDataFim(null);
		this.setDataIni(null);
		this.setProdutoEstoque(null);
		this.setListaProdutoEstoque(null);
		this.setVerifica(0);
		this.setBtnAdicionar(true);
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
		if(this.empresa == null){
			this.empresa = new Pessoa();			
		}
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
		if(this.produtoEstoque == null){
			this.produtoEstoque = new ProdutoEstoque();
		}
		return produtoEstoque;
	}
	public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	public List<ProdutoEstoque> getListaProdutoEstoque() {
		if(this.listaProdutoEstoque == null){
			this.listaProdutoEstoque = new ArrayList<ProdutoEstoque>();	
		}
		return listaProdutoEstoque;
	}
	public void setListaProdutoEstoque(List<ProdutoEstoque> listaProdutoEstoque) {
		this.listaProdutoEstoque = listaProdutoEstoque;
	}
	public Produto getProduto() {
		if(this.produto == null){
			this.produto = new Produto();			
		}
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getListaProduto() {
		if(this.listaProduto == null){
			this.listaProduto = new ArrayList<Produto>();			
		}
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public boolean isBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(boolean btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	public Integer getVerifica() {
		return verifica;
	}

	public void setVerifica(Integer verifica) {
		this.verifica = verifica;
	}

	public boolean isTxtCustoMedio() {
		return txtCustoMedio;
	}

	public void setTxtCustoMedio(boolean txtCustoMedio) {
		this.txtCustoMedio = txtCustoMedio;
	}

	public EmpresaRN getEmpRN() {
		if(this.empRN == null){
			this.empRN = new EmpresaRN();			
		}
		return empRN;
	}

	public void setEmpRN(EmpresaRN empRN) {
		this.empRN = empRN;
	}

	public ProdutoRN getProdRN() {
		if(this.prodRN == null){
			this.prodRN = new ProdutoRN();
		}
		return prodRN;
	}

	public void setProdRN(ProdutoRN prodRN) {
		this.prodRN = prodRN;
	}

	public ProdutoEstoqueRN getProdEstRN() {
		if(this.prodEstRN == null){
			this.prodEstRN = new ProdutoEstoqueRN();			
		}
		return prodEstRN;
	}

	public void setProdEstRN(ProdutoEstoqueRN prodEstRN) {
		this.prodEstRN = prodEstRN;
	}

	public String getTipoMovEstoque() {
		return tipoMovEstoque;
	}

	public void setTipoMovEstoque(String tipoMovEstoque) {
		this.tipoMovEstoque = tipoMovEstoque;
	}
}
