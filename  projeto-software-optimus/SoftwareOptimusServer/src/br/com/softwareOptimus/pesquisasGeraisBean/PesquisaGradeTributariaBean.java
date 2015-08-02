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

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.RN.geral.EstadoRN;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.fiscal.RN.PautaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaGradeTributariaBean")
@ViewScoped
public class PesquisaGradeTributariaBean extends FacesUtil implements Serializable {

	private PautaRN pautaRN;
	private GradeTributariaRN gradeTributariaRN;
	private EstadoRN estadoRN;
	private GradeTributaria gradeTributaria;
	private GradeTributariaVigencia gradeTributariaVigencia;
	private List<Pauta> pautaList;
	private List<Estado> origemList;
	private List<Estado> destinoList;
	private LazyDataModel<GradeTributaria> gradeTributariaList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaGradeTributariaBean(){
		gradeTributariaList = new LazyDataModel<GradeTributaria>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<GradeTributaria> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getGradeTributariaRN().countGradeTributariaPaginacao(getGradeTributaria(), getGradeTributariaVigencia()));
				return getGradeTributariaRN().buscaGradeTributariaPaginacao(getGradeTributaria(), getGradeTributariaVigencia(), first, pageSize);
			}
		};
	}
	
	public void selecionaGradeTributaria(GradeTributaria gradeTributaria){
		RequestContext.getCurrentInstance().closeDialog(gradeTributaria);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaGradeTributaria", opcoes, null);
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

	public GradeTributariaRN getGradeTributariaRN() {
		if(this.gradeTributariaRN == null){
			this.gradeTributariaRN = new GradeTributariaRN();
		}
		return gradeTributariaRN;
	}

	public void setGradeTributariaRN(GradeTributariaRN gradeTributariaRN) {
		this.gradeTributariaRN = gradeTributariaRN;
	}

	public GradeTributaria getGradeTributaria() {
		if(this.gradeTributaria == null){
			this.gradeTributaria = new GradeTributaria();
		}
		return gradeTributaria;
	}

	public void setGradeTributaria(GradeTributaria gradeTributaria) {
		this.gradeTributaria = gradeTributaria;
	}

	public List<Pauta> getPautaList() {
		if(this.pautaList == null){
			this.pautaList = new ArrayList<Pauta>();
			this.pautaList.addAll(this.getPautaRN().listar());
		}
		return pautaList;
	}

	public void setPautaList(List<Pauta> pautaList) {
		this.pautaList = pautaList;
	}

	public LazyDataModel<GradeTributaria> getGradeTributariaList() {
		return gradeTributariaList;
	}

	public void setGradeTributariaList(LazyDataModel<GradeTributaria> gradeTributariaList) {
		this.gradeTributariaList = gradeTributariaList;
	}

	public EstadoRN getEstadoRN() {
		if(this.estadoRN == null){
			this.estadoRN = new EstadoRN();
		}
		return estadoRN;
	}

	public void setEstadoRN(EstadoRN estadoRN) {
		this.estadoRN = estadoRN;
	}

	public GradeTributariaVigencia getGradeTributariaVigencia() {
		if(this.gradeTributariaVigencia == null){
			this.gradeTributariaVigencia = new GradeTributariaVigencia();
			this.gradeTributariaVigencia.setDestino(new Estado());
			this.gradeTributariaVigencia.setOrigem(new Estado());
			this.gradeTributariaVigencia.setPauta(new Pauta());
		}
		return gradeTributariaVigencia;
	}

	public void setGradeTributariaVigencia(GradeTributariaVigencia gradeTributariaVigencia) {
		this.gradeTributariaVigencia = gradeTributariaVigencia;
	}

	public List<Estado> getOrigemList() {
		if(this.origemList == null){
			this.origemList = new ArrayList<Estado>();
			this.origemList.addAll(this.getEstadoRN().listaEstado());
		}
		return origemList;
	}

	public void setOrigemList(List<Estado> origemList) {
		this.origemList = origemList;
	}

	public List<Estado> getDestinoList() {
		if(this.destinoList == null){
			this.destinoList = new ArrayList<Estado>();
			this.destinoList.addAll(this.getEstadoRN().listaEstado());
		}
		return destinoList;
	}

	public void setDestinoList(List<Estado> destinoList) {
		this.destinoList = destinoList;
	}
}
