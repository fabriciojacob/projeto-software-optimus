package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.UnidMedRN;

@ManagedBean(name = "unidMedBean")
@ViewScoped
public class UnidMedBean implements Serializable{

	private static final long serialVersionUID = -3988883087479983925L;
	private UnidMed unidMed = new UnidMed();
	private boolean disable = false;
	private List<UnidMed> unidMedLis = new ArrayList<UnidMed>();
	private String busca;
	private String filtro;
	private Long id;
	private boolean alt = true, sal = true, rem = true, unidAbre = true,
			desc = true;

	public void salvarUnid() {
		try {
			UnidMedRN unidRN = new UnidMedRN();
			this.unidMed.setIdUnidMed(null);
			Integer retorno = unidRN.validaCampoNulo(this.unidMed);
			if (retorno == 0) {
				unidRN.salvar(unidMed);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Unidade salva com sucesso"));
				this.sal = true;
				limpa();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Unidade "
									+ e.getMessage()));
		}
	}

	public void buscaUnid() {
		limpa();
		UnidMedRN unidRN = new UnidMedRN();
		if (!busca.equals("") && !filtro.equals("")) {
			if (filtro.equals("id")) {
				this.unidMedLis = unidRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("unid")) {
				this.unidMedLis = unidRN.consultaUnid(busca);
			} else if (filtro.equals("desc")) {
				this.unidMedLis = unidRN.consultaDesc(busca);
			}
		} else {
			this.unidMedLis = unidRN.lista();
		}
	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		limpa();
		desabilita();
	}

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		habilita();
		limpa();
	}

	public void limpa() {
		this.unidMed = new UnidMed();
		this.unidMedLis = new ArrayList<UnidMed>();
	}

	public void altUnid() {
		try {
			UnidMedRN unidRN = new UnidMedRN();
			Integer retorno = unidRN.validaCampoNulo(this.unidMed);
			if (retorno == 0) {
				unidRN.altUnid(unidMed);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Unidade alterada com sucesso"));
				this.alt = true;
				this.rem = true;
				limpa();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na alteraÃ§Ã£o da Unidade "
									+ e.getMessage()));
		}
	}

	public void editUnid() {
		UnidMedRN unidRN = new UnidMedRN();
		this.unidMed = unidRN.editUnid(id);
		this.alt = false;
		this.rem = false;
		this.sal = true;
		habilita();
	}

	public void remUnid() {
		UnidMedRN unidRN = new UnidMedRN();
		try {
			unidRN.remove(unidMed.getIdUnidMed());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Unidade removida com sucesso"));
			this.alt = true;
			this.rem = true;
			limpa();
			desabilita();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoï¿½ï¿½o da Unidade "
									+ e.getMessage()));
		}

	}

	public void habilita() {
		this.unidAbre = false;
		this.desc = false;
	}

	public void desabilita() {
		this.unidAbre = true;
		this.desc = true;
	}

	public boolean isUnidAbre() {
		return unidAbre;
	}

	public void setUnidAbre(boolean unidAbre) {
		this.unidAbre = unidAbre;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}

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
}
