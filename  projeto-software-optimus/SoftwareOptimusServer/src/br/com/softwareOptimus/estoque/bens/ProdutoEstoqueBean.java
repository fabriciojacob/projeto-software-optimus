package br.com.softwareOptimus.estoque.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.softwareOptimus.comercial.Comercial;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.RN.ProdutoEstoqueRN;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.RN.ProdutoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "produtoEstoqueBean")
@ViewScoped
public class ProdutoEstoqueBean extends FacesUtil implements Serializable{
	
	private static final long serialVersionUID = -1958596637728666102L;
	private ProdutoEstoque produtoEstoque;
	private LazyDataModel<ProdutoEstoque> listaProdutoEstoque;
	private PesquisaEstoquePojo dadosPesquisa = new PesquisaEstoquePojo();
	private List<Produto> listaProduto;
	private Double quantEntSai;
	private EmpresaRN empRN;
	private ProdutoRN prodRN;
	private ProdutoEstoqueRN prodEstRN = new ProdutoEstoqueRN();
	private String tipoMovEstoque;
	private boolean btnAdicionar = true, txtCustoMedio = true;
	private Integer verifica =0;
	
	public ProdutoEstoqueBean(){
		listaProdutoEstoque = new LazyDataModel<ProdutoEstoque>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<ProdutoEstoque> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
						Map<String, Object> filters) {
				Integer retorno = prodEstRN.validaCamposPesquisa(dadosPesquisa);
				if(retorno == 0){
					dadosPesquisa.setPrimeiroRegistro(first);
					dadosPesquisa.setQuantidadeRegistros(pageSize);
					
					setRowCount(prodEstRN.countMovProdutoEstoque(dadosPesquisa));
					
					return prodEstRN.buscaMovProduto(dadosPesquisa);					
				}else{
					return null;
				}
			}
		};
	}
	
	public void pesquisaMovEstoque(){
		Integer retorno = this.getProdEstRN().validaCamposPesquisa(this.getDadosPesquisa());
		if(retorno != 0){
			this.error("Para pesquisa é necessário Produto, Empresa, Data Inicial e Final!");
		}
	}
	
	public void buscaCustoMedio(){
		this.getProdutoEstoque().setCustoMedio(this.getProdEstRN().retCustoMedioProduto(this.getProdutoEstoque()));
		if(this.getProdutoEstoque().getCustoMedio() == 0){
			this.setTxtCustoMedio(false);
		}else{
			this.setTxtCustoMedio(true);
		}
	}
	
	public void empresaSelecionada(SelectEvent event) {
		PessoaJuridica empresa;
		try {
			empresa = (PessoaJuridica) event.getObject();
			this.getDadosPesquisa().setEmpresa(this.getEmpRN().pesquisaId(empresa.getIdPessoa()));
			this.getProdutoEstoque().setEmpresa(this.getDadosPesquisa().getEmpresa());
			this.info("Empresa selecionada");
			this.verifica = this.verifica + 1;
			if(this.getVerifica() >= 2){
				this.btnAdicionar = false;
			}
		} catch (Exception e) {
			this.error("Problemas na seleção da empresa " + e.getMessage());
		}
	}
	
	public void produtoSelecionado(SelectEvent event) {
		Produto prod;
		try {
			prod = (Produto) event.getObject();
			this.getDadosPesquisa().setProduto(this.getProdRN().editPro(prod.getIdProduto()));
			this.getProdutoEstoque().setProduto(this.getDadosPesquisa().getProduto());
			this.info("Produto selecionado");
			this.verifica = this.verifica + 1;
			if(this.getVerifica() >= 2){
				this.btnAdicionar = false;
			}
		} catch (Exception e) {
			this.error("Problemas na seleção do Produto " + e.getMessage());
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
			try {
				this.getProdutoEstoque().setDespesaNota(0.0);
				this.getProdutoEstoque().setFreteNota(0.0);
				this.getProdutoEstoque().setIcmsNota(0.0);
				this.getProdutoEstoque().setIpiNota(0.0);
				this.getProdutoEstoque().setPisCofinsNota(0.0);
				this.getProdutoEstoque().setCustoNota(this.getProdutoEstoque().getCustoMedio());
				this.getProdutoEstoque().setOrigem(new Comercial());
				this.getProdutoEstoque().getOrigem().setIdComercial(new Long(0));
				this.getProdEstRN().salvar(this.getProdutoEstoque(), 1, tipoMovEst);
				this.info("Dados salvo com sucesso!");
			} catch (Exception e) {
				this.error("Falha ao salvar movimentação de estoque " + e.getMessage());
			}
		}else{
			this.error("Existem campos nulos no formulário ou zerado! Verifique!");
		}
	}
	
	public void cancelar(){
		
	}
	
	public void limparInfPesquisa(){
		this.setDadosPesquisa(null);
		this.setProdutoEstoque(null);
		this.setVerifica(0);
		this.setBtnAdicionar(true);
	}
	
	public Double getQuantEntSai() {
		return quantEntSai;
	}

	public void setQuantEntSai(Double quantEntSai) {
		this.quantEntSai = quantEntSai;
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

	public PesquisaEstoquePojo getDadosPesquisa() {
		if(this.dadosPesquisa == null){
			this.dadosPesquisa = new PesquisaEstoquePojo();
		}
		return dadosPesquisa;
	}

	public void setDadosPesquisa(PesquisaEstoquePojo dadosPesquisa) {
		this.dadosPesquisa = dadosPesquisa;
	}

	public LazyDataModel<ProdutoEstoque> getListaProdutoEstoque() {
		return listaProdutoEstoque;
	}
}
