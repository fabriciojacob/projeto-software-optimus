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

import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.RN.PautaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaPautaBean")
@ViewScoped
public class PesquisaNcmBean extends FacesUtil implements Serializable {

	private PautaRN pautaRN;
	private Pauta pauta;
	private LazyDataModel<Pauta> pautaList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaNcmBean(){
		pautaList = new LazyDataModel<Pauta>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<Pauta> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getPautaRN().countPautaPaginacao(getPauta()));
				return getPautaRN().buscaPautaPaginacao(getPauta(), first, pageSize);
			}
		};
	}
	
	public void selecionaPauta(Pauta pauta){
		RequestContext.getCurrentInstance().closeDialog(pauta);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaPauta", opcoes, null);
	}

	public PautaRN getPautaRN() {
		if(this.pautaRN == null){
			this.pautaRN = new PautaRN();
		}
		return pautaRN;
	}

	public void setPautaRN(PautaRN pautaRN) {
		this.pautaRN = pautaRN;
	}

	public Pauta getPauta() {
		if(this.pauta == null){
			this.pauta = new Pauta();
		}
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public LazyDataModel<Pauta> getPautaList() {
		return pautaList;
	}

	public void setPautaList(LazyDataModel<Pauta> pautaList) {
		this.pautaList = pautaList;
	}
}
