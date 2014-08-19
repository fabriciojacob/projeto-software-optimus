package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.AliquotaRN;
import br.com.softwareOptimus.fiscal.RN.GradeTributariaRN;

@ManagedBean
@ViewScoped
public class GradeTributariaBean {

	private GradeTributariaVigencia grade = new GradeTributariaVigencia();
	private List<GradeTributariaVigencia> listaGrade = new ArrayList<GradeTributariaVigencia>();
	//private PautaMVARN pautaRN = new PautaMVARN();
	private AliquotaRN aliqRN = new AliquotaRN();
	private List<PautaMVA> listaPauta = new ArrayList<PautaMVA>();
	private List<Aliquota> listaAliquota = new ArrayList<Aliquota>();
	private String busca, filtro, tipoEntSai;
	private Long id;
	private boolean sal = true, alt = true, rem = true;
	
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
			this.grade.setId(null);
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
	
	public void buscar(){
		
	}
	
	public void editGrade(){
		
	}
	
	public void limpar(){
		this.grade = new GradeTributariaVigencia();
		this.listaGrade = new ArrayList<GradeTributariaVigencia>();
		this.listaAliquota = new ArrayList<Aliquota>();
		this.listaPauta = new ArrayList<PautaMVA>();
	}
	
	public void cancelar(){
		this.sal = true;
		this.alt = true;
		this.rem = true;
		limpar();
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

	public GradeTributariaVigencia getGrade() {
		return grade;
	}

	public void setGrade(GradeTributariaVigencia grade) {
		this.grade = grade;
	}

	public List<GradeTributariaVigencia> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributariaVigencia> listaGrade) {
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
