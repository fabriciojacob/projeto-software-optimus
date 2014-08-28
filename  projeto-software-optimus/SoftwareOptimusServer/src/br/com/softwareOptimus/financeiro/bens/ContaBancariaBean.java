package br.com.softwareOptimus.financeiro.bens;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.financeiro.ContaBancaria;

@ManagedBean
@ViewScoped
public class ContaBancariaBean {
	
	private ContaBancaria contaBancaria = new ContaBancaria();
	
	public void salvar(){
		
	}
	

	public void msgAcerto(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
	}

	public void msgErro(String msg, Exception e) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msg
						+ e.getMessage()));
	}

}
