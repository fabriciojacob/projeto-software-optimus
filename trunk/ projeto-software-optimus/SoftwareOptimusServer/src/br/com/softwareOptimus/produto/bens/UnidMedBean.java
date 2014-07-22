package br.com.softwareOptimus.produto.bens;

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
	
	public void salvarUnid(){
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
}
