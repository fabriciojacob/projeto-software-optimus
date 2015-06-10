package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.TipoProdutoRN;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.ProdutoRN;
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
	private LazyDataModel<Produto> listProduto;
	
	private FiguraFiscalRN figRN;
	private UnidMedRN unidRN;
	private TipoProdutoRN tipRN;
	private ProdutoRN prodRN;
	
	public PesquisaProdutoBean(){
		listProduto = new LazyDataModel<Produto>() {
			private static final long serialVersionUID = 1L;
			@Override
			public List<Produto> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getProdRN().countProdutoPaginacao(getProduto()));
				return getProdRN().buscaProdutoPaginacao(getProduto(), first, pageSize);
			}
		};
	}
	
	public void selecionaProduto(Produto produto){
		RequestContext.getCurrentInstance().closeDialog(produto);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 500);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaProduto", opcoes, null);
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
			this.produto.setUnidMed(new UnidMed());
			this.produto.setFigura(new FiguraFiscal());
			this.produto.setTipoProd(new TipoProduto());
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

	public ProdutoRN getProdRN() {
		if(this.prodRN == null){
			this.prodRN = new ProdutoRN();
		}
		return prodRN;
	}

	public void setProdRN(ProdutoRN prodRN) {
		this.prodRN = prodRN;
	}

	public LazyDataModel<Produto> getListProduto() {
		return listProduto;
	}
	
	public void setListProduto(LazyDataModel<Produto> listProduto) {
		this.listProduto = listProduto;
	}
}
