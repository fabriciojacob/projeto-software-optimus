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
	private boolean chkId = false;
	private boolean chkUnid = false;
	private boolean chkDesc = false;	
	
	public boolean isChkId() {
		return chkId;
	}

	public void setChkId(boolean chkId) {
		this.chkId = chkId;
	}

	public boolean isChkUnid() {
		return chkUnid;
	}

	public void setChkUnid(boolean chkUnid) {
		this.chkUnid = chkUnid;
	}

	public boolean isChkDesc() {
		return chkDesc;
	}

	public void setChkDesc(boolean chkDesc) {
		this.chkDesc = chkDesc;
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
	
	public void buscaUnid(){
		UnidMedRN unidRN = new UnidMedRN();
		if (chkId == true && busca != null) {
			unidMedLis = unidRN.consultaId(Long.parseLong(busca));
		}else if(chkUnid == true && busca != null){
			unidMedLis = unidRN.consultaUnid(busca);
		}else if (chkDesc == true && busca != null){
			unidMedLis = unidRN.consultaDesc(busca);
		}
	}
}
