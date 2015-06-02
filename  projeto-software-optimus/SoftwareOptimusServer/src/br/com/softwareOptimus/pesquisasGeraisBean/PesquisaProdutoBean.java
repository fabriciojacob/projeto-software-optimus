package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.TipoProdutoRN;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.UnidMedRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaProdutoBean")
@ViewScoped
public class PesquisaProdutoBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = 3019620803107082715L;
	private Produto produto;
	private List<Produto> listaProduto;
	private List<FiguraFiscal> listaFigura;
	private List<UnidMed> listaUnidade;
	private List<TipoProduto> listaTipo; 
	private String busca, filtro;
	
	private FiguraFiscalRN figRN;
	private UnidMedRN unidRN;
	private TipoProdutoRN tipRN;
	
	public void buscarProd(){
		
	}

	public List<FiguraFiscal> getListaFigura() {
		if(this.listaFigura == null){
			this.listaFigura = new ArrayList<FiguraFiscal>();
			this.setListaFigura(this.getFigRN().listar());
		}
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}

	public List<UnidMed> getListaUnidade() {
		if(this.listaUnidade == null){
			this.listaUnidade = new ArrayList<UnidMed>();
			this.setListaUnidade(this.getUnidRN().lista());
		}
		return listaUnidade;
	}

	public void setListaUnidade(List<UnidMed> listaUnidade) {
		this.listaUnidade = listaUnidade;
	}

	public List<TipoProduto> getListaTipo() {
		if(this.listaTipo == null){
			this.listaTipo = new ArrayList<TipoProduto>();
			this.setListaTipo(this.getTipRN().listarTipoVig());
		}
		return listaTipo;
	}

	public void setListaTipo(List<TipoProduto> listaTipo) {
		this.listaTipo = listaTipo;
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

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public FiguraFiscalRN getFigRN() {
		if(this.figRN == null){
			this.figRN = new FiguraFiscalRN();
		}
		return figRN;
	}

	public void setFigRN(FiguraFiscalRN figRN) {
		this.figRN = figRN;
	}

	public UnidMedRN getUnidRN() {
		if(this.unidRN == null){
			this.unidRN = new UnidMedRN();
		}
		return unidRN;
	}

	public void setUnidRN(UnidMedRN unidRN) {
		this.unidRN = unidRN;
	}

	public TipoProdutoRN getTipRN() {
		if(tipRN == null){
			this.tipRN = new TipoProdutoRN();
		}
		return tipRN;
	}

	public void setTipRN(TipoProdutoRN tipRN) {
		this.tipRN = tipRN;
	}
}
