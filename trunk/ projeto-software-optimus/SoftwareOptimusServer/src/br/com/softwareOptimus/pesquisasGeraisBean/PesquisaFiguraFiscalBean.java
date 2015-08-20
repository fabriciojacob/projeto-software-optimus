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
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pesquisaFiguraFiscalBean")
@ViewScoped
public class PesquisaFiguraFiscalBean extends FacesUtil implements Serializable {

	private GradeTributariaRN gradeTribRN;
	private FiguraFiscalRN figFiscalRN;
	private GradeTributaria gradeTributaria;
	private FiguraFiscal figuraFiscal;
	private List<GradeTributaria> gradeTributariaList;
	private LazyDataModel<FiguraFiscal> figuraFiscalList;

	private static final long serialVersionUID = 5527469039512067571L;

	public PesquisaFiguraFiscalBean(){
		figuraFiscalList = new LazyDataModel<FiguraFiscal>() {

			private static final long serialVersionUID = 8237501022051609919L;
			@Override
			public List<FiguraFiscal> load(int first, int pageSize, String sortField, SortOrder sortOrder, 
					Map<String, Object> filters) {
				setRowCount(getFigFiscalRN().countFiguraFiscalPaginacao(getFiguraFiscal(), getGradeTributaria()));
				return getFigFiscalRN().buscaFiguraFiscalPaginacao(getFiguraFiscal(), getGradeTributaria(), first, pageSize);
			}
		};
	}
	
	public void selecionaFiguraFiscal(FiguraFiscal figuraFiscal){
		RequestContext.getCurrentInstance().closeDialog(figuraFiscal);
	}
	
 	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 600);
		opcoes.put("contentWidth", 800);
		
		RequestContext.getCurrentInstance().openDialog("/privado/pesquisasGerais/pesquisaFiguraFiscal", opcoes, null);
	}

	public GradeTributariaRN getGradeTribRN() {
		if(this.gradeTribRN == null){
			this.gradeTribRN = new GradeTributariaRN();
		}
		return gradeTribRN;
	}

	public void setGradeTribRN(GradeTributariaRN gradeTribRN) {
		this.gradeTribRN = gradeTribRN;
	}

	public FiguraFiscalRN getFigFiscalRN() {
		if(this.figFiscalRN == null){
			this.figFiscalRN = new FiguraFiscalRN();
		}
		return figFiscalRN;
	}

	public void setFigFiscalRN(FiguraFiscalRN figFiscalRN) {
		this.figFiscalRN = figFiscalRN;
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

	public FiguraFiscal getFiguraFiscal() {
		if(this.figuraFiscal == null){
			this.figuraFiscal = new FiguraFiscal();
		}
		return figuraFiscal;
	}

	public void setFiguraFiscal(FiguraFiscal figuraFiscal) {
		this.figuraFiscal = figuraFiscal;
	}

	public List<GradeTributaria> getGradeTributariaList() {
		if(this.gradeTributariaList == null){
			this.gradeTributariaList = new ArrayList<GradeTributaria>();
			this.gradeTributariaList.addAll(this.getGradeTribRN().listar());
		}
		return gradeTributariaList;
	}

	public void setGradeTributariaList(List<GradeTributaria> gradeTributariaList) {
		this.gradeTributariaList = gradeTributariaList;
	}

	public LazyDataModel<FiguraFiscal> getFiguraFiscalList() {
		return figuraFiscalList;
	}

	public void setFiguraFiscalList(LazyDataModel<FiguraFiscal> figuraFiscalList) {
		this.figuraFiscalList = figuraFiscalList;
	}
}
