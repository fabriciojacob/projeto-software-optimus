package br.com.softwareOptimus.produto.bens;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.RN.UnidMedRN;
import br.com.softwareOptimus.produto.UnidMed;

@ManagedBean(name = "unidMedBean")
@SessionScoped
public class UnidMedBean {

	private UnidMed unidMed = new UnidMed();
	private boolean disable = false;
	private List<UnidMed> unidMedLis;
	private String busca;
	private String filtro;
	private Long id;
	private boolean alt = true, sal = true;

	public boolean isAlt() {
		return alt;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean isSal() {
		return sal;
	}

	public void setSal(boolean sal) {
		this.sal = sal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public UnidMed getUnidMed() {
		return unidMed;
	}

	public void setUnidMed(UnidMed unidMed) {
		this.unidMed = unidMed;
	}

	public List<UnidMed> getUnidMedLis() {
		return unidMedLis;
	}

	public void setUnidMedLis(List<UnidMed> unidMedLis) {
		this.unidMedLis = unidMedLis;
	}

	public void salvarUnid() {
		try {
			UnidMedRN unidRN = new UnidMedRN();
			unidMed.setIdUnidMed(null);
			unidRN.salvar(unidMed);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Unidade salva com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Unidade "
									+ e.getMessage()));
		}
	}

	public void buscaUnid() {
		UnidMedRN unidRN = new UnidMedRN();
		if (!busca.equals("")) {
			if (filtro.equals("id")) {
				unidMedLis = unidRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("unid")) {
				unidMedLis = unidRN.consultaUnid(busca);
			} else if (filtro.equals("desc")) {
				unidMedLis = unidRN.consultaDesc(busca);
			}
		} else {
			unidMedLis = unidRN.lista();
		}
	}

	public void limpar() {
		unidMed = new UnidMed();
		unidMedLis.clear();
	}
	
	public void altUnid(){
		try {
			unidMedLis.clear();
			UnidMedRN unidRN = new UnidMedRN();
			unidRN.altUnid(unidMed);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Unidade alterada com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na alteração da Unidade "
									+ e.getMessage()));
		}
		this.alt = true;
	}

	public void editUnid() {
		UnidMedRN unidRN = new UnidMedRN();
		unidMed = unidRN.editUnid(id);
		this.alt = false;
	}
}
