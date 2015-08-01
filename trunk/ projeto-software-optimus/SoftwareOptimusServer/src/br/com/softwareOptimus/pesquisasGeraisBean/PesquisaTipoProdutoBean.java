package br.com.softwareOptimus.pesquisasGeraisBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.fiscal.RN.TipoProdutoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaTipoProdutoBean")
@ViewScoped
public class PesquisaTipoProdutoBean extends FacesUtil implements Serializable {

	private TipoProdutoRN tipoProdRN;
	private TipoProduto tipoProd;
	private LazyDataModel<TipoProduto> tipoProdutoList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaTipoProdutoBean(){
		tipoProdutoList = new LazyDataModel<TipoProduto>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<TipoProduto> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getTipoProdRN().countTipoProdutoPaginacao(getTipoProd()));
				return getTipoProdRN().buscaTipoProdutoPaginacao(getTipoProd(), first, pageSize);
			}
		};
	}
	
	public void selecionaTipoProd(TipoProduto tipoProd){
		RequestContext.getCurrentInstance().closeDialog(tipoProd);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaTipoProduto", opcoes, null);
	}

	public TipoProdutoRN getTipoProdRN() {
		if(this.tipoProdRN == null){
			this.tipoProdRN = new TipoProdutoRN();
		}
		return tipoProdRN;
	}

	public void setTipoProdRN(TipoProdutoRN tipoProdRN) {
		this.tipoProdRN = tipoProdRN;
	}

	public TipoProduto getTipoProd() {
		if(this.tipoProd == null){
			this.tipoProd = new TipoProduto();
		}
		return tipoProd;
	}

	public void setTipoProd(TipoProduto tipoProd) {
		this.tipoProd = tipoProd;
	}

	public LazyDataModel<TipoProduto> getTipoProdutoList() {
		return tipoProdutoList;
	}

	public void setTipoProdutoList(LazyDataModel<TipoProduto> tipoProdutoList) {
		this.tipoProdutoList = tipoProdutoList;
	}
}
