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

import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.UnidMedRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaUnidadeMedidaBean")
@ViewScoped
public class PesquisaUnidadeMedidaBean extends FacesUtil implements Serializable {

	private UnidMedRN unidRN;
	private UnidMed unidMed;
	private LazyDataModel<UnidMed> unidadeMedidaList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaUnidadeMedidaBean(){
		unidadeMedidaList = new LazyDataModel<UnidMed>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<UnidMed> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getUnidRN().countUnidadeMedidaPaginacao(getUnidMed()));
				return getUnidRN().buscaUnidadeMedidaPaginacao(getUnidMed(), first, pageSize);
			}
		};
	}
	
	public void selecionaUnidadeMedida(UnidMed unidMed){
		RequestContext.getCurrentInstance().closeDialog(unidMed);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaUnidadeMedida", opcoes, null);
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

	public UnidMed getUnidMed() {
		if(this.unidMed == null){
			this.unidMed = new UnidMed();
		}
		return unidMed;
	}

	public void setUnidMed(UnidMed unidMed) {
		this.unidMed = unidMed;
	}

	public LazyDataModel<UnidMed> getUnidadeMedidaList() {
		return unidadeMedidaList;
	}

	public void setUnidadeMedidaList(LazyDataModel<UnidMed> unidadeMedidaList) {
		this.unidadeMedidaList = unidadeMedidaList;
	}

}
