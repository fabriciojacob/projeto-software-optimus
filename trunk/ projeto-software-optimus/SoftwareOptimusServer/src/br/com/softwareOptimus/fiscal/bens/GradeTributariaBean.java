package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;

@ManagedBean(name= "gradeTributariaBean")
@ViewScoped
public class GradeTributariaBean {

	private GradeTributaria grade = new GradeTributaria();
	private GradeTributariaVigencia gradeVig = new GradeTributariaVigencia();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private List<GradeTributariaVigencia> listaGradeVig = new ArrayList<GradeTributariaVigencia>();
	private AliquotaRN aliqRN = new AliquotaRN();
	private List<PautaMVA> listaPauta = new ArrayList<PautaMVA>();
	private List<Aliquota> listaAliquota = new ArrayList<Aliquota>();
	private String busca, filtro, tipoEntSai;
	private Long id, idGradeVig;
	private boolean sal = true, alt = true, rem = true, vig = true;
	
	public GradeTributariaBean(){
		setListaAliquota(this.aliqRN.listaAliqIcms());
		//setListaPauta(this.pautaRN.lista());
	}
	
	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		limpar();
	}
	
	public void salvar(){
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			//this.grade.setId(null);
			//Integer retorno = gradeRN.validaCampoNulo(this.grade);
			//if (retorno == 0) {
				//gradeRN.salva(this.grade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grade salva com sucesso"));
				this.sal = true;
				limpar();
			//} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			//}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na gravacao da Grade "
											+ e.getMessage()));
		}
	}
	
	public void alterar(){
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			//Integer retorno = gradeRN.validaCampoNulo(this.grade);
			//if (retorno == 0) {
				//gradeRN.altGrade(this.grade);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Grade alterada com sucesso"));
				this.alt = true;
				this.rem = true;
				limpar();
			//} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			//}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na alteração da Grade "
											+ e.getMessage()));
		}
	}
	
	public void remover(){
		try {
			GradeTributariaRN gradeRN = new GradeTributariaRN();
			//gradeRN.remover(this.grade);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Grade removida com sucesso"));
			this.alt = true;
			this.rem = true;
			limpar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção da Grade " + e.getMessage()));
		}
	}
	
	public void buscarGrade(){
		
	}
	
	public void editGrade(){
		
	}
	
	public void limpar(){
		this.grade = new GradeTributaria();
		this.listaGrade = new ArrayList<GradeTributaria>();
		this.listaAliquota = new ArrayList<Aliquota>();
		this.listaPauta = new ArrayList<PautaMVA>();
	}
	
	public void cancelar(){
		this.sal = true;
		this.alt = true;
		this.rem = true;
		limpar();
	}
	
	public void excluirGradeVig(){
		
	}
	
	public void incluirGradeVig(){
		
	}
	
	public Long getIdGradeVig() {
		return idGradeVig;
	}
	
	public void setIdGradeVig(Long idGradeVig) {
		this.idGradeVig = idGradeVig;
	}
	
	public boolean isVig() {
		return vig;
	}
	
	public void setVig(boolean vig) {
		this.vig = vig;
	}
	
	public GradeTributariaVigencia getGradeVig() {
		return gradeVig;
	}
	
	public void setGradeVig(GradeTributariaVigencia gradeVig) {
		this.gradeVig = gradeVig;
	}

	public List<Aliquota> getListaAliquota() {
		return listaAliquota;
	}

	public void setListaAliquota(List<Aliquota> listaAliquota) {
		this.listaAliquota = listaAliquota;
	}

	public List<PautaMVA> getListaPauta() {
		return listaPauta;
	}

	public void setListaPauta(List<PautaMVA> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public String getTipoEntSai() {
		return tipoEntSai;
	}

	public void setTipoEntSai(String tipoEntSai) {
		this.tipoEntSai = tipoEntSai;
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}
	
	public List<GradeTributariaVigencia> getListaGradeVig() {
		return listaGradeVig;
	}
	
	public void setListaGradeVig(List<GradeTributariaVigencia> listaGradeVig) {
		this.listaGradeVig = listaGradeVig;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
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

	public boolean isSal() {
		return sal;
	}

	public void setSal(boolean sal) {
		this.sal = sal;
	}

	public boolean isAlt() {
		return alt;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}
}
