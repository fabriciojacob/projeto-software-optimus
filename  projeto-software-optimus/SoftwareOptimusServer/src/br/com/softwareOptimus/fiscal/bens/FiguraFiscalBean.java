package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.FiguraFiscalRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;
import br.com.softwareOptimus.fiscal.RN.PautaMVARN;

@ManagedBean(name = "figuraFiscalBean")
@ViewScoped
public class FiguraFiscalBean {

	private FiguraFiscal figura = new FiguraFiscal();
	private GradeTributaria grade = new GradeTributaria();
	private PautaMVARN pautaRN = new PautaMVARN();
	private AliquotaRN aliqRN = new AliquotaRN();
	private List<FiguraFiscal> listaFigura = new ArrayList<FiguraFiscal>();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private List<PautaMVA> listaPauta = new ArrayList<PautaMVA>();
	private List<Aliquota> listaAliquota = new ArrayList<Aliquota>();
	private Boolean sal = true, alt = true, rem = true, inc = true, outInc = true;
	private String busca, filtro, tipoGrade;
	private Long id;
	
	public FiguraFiscalBean(){
		setListaAliquota(this.aliqRN.listaAliqIcms());
		setListaPauta(this.pautaRN.lista());
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.inc = true;
		this.outInc = true;
		limpar();
	}

	public void salvar() {
		try {
			FiguraFiscalRN figRN = new FiguraFiscalRN();
			this.figura.setIdFigura(null);
			Integer retorno = figRN.validaCampoNulo(this.figura);
			if (retorno == 0) {
				figRN.salvar(this.figura);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Figura salva com sucesso"));
				this.inc = false;
				this.outInc = false;
			}else{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Figura "
									+ e.getMessage()));
		}
	}

	public void alterar() {

	}

	public void remover() {

	}

	public void limpar() {
		this.figura = new FiguraFiscal();
		this.listaFigura = new ArrayList<FiguraFiscal>();
		this.busca = "";
		this.filtro = "";
	}

	public void cancelar() {

	}

	public void editFigura() {

	}
	
	public void editGrade(){
		
	}
	
	public void excluirGrade(){
		
	}
	
	public void buscar(){
		
	}
	
	public void incluirGrade(){
		GradeTributariaRN gradeRN = new GradeTributariaRN();
		
	}

	public Boolean getInc() {
		return inc;
	}

	public void setInc(Boolean inc) {
		this.inc = inc;
	}

	public Boolean getOutInc() {
		return outInc;
	}

	public void setOutInc(Boolean outInc) {
		this.outInc = outInc;
	}

	public FiguraFiscal getFigura() {
		return figura;
	}

	public void setFigura(FiguraFiscal figura) {
		this.figura = figura;
	}

	public Boolean getSal() {
		return sal;
	}

	public void setSal(Boolean sal) {
		this.sal = sal;
	}

	public Boolean getAlt() {
		return alt;
	}

	public void setAlt(Boolean alt) {
		this.alt = alt;
	}

	public Boolean getRem() {
		return rem;
	}

	public void setRem(Boolean rem) {
		this.rem = rem;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FiguraFiscal> getListaFigura() {
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}

	public String getTipoGrade() {
		return tipoGrade;
	}

	public void setTipoGrade(String tipoGrade) {
		this.tipoGrade = tipoGrade;
	}

	public List<PautaMVA> getListaPauta() {
		return listaPauta;
	}

	public void setListaPauta(List<PautaMVA> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public List<Aliquota> getListaAliquota() {
		return listaAliquota;
	}

	public void setListaAliquota(List<Aliquota> listaAliquota) {
		this.listaAliquota = listaAliquota;
	}
}
