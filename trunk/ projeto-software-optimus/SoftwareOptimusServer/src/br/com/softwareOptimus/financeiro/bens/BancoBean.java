package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.financeiro.Banco;
import br.com.softwareOptimus.financeiro.RN.BancoRN;

@ManagedBean(name="bancoBean")
@SessionScoped
public class BancoBean {
	
	private BancoRN bancoRN = new BancoRN();
	private Banco banco = new Banco();
	private List<Banco> listaBanco = new ArrayList<>();

	public BancoBean() {
		try{
		setListaBanco(this.bancoRN.pesquisa());
		}catch (Exception e){
			msgErro("Problemas ao listar os bancos", e);
		}
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
	
	public Banco getBanco() {
		return banco;
	}
	
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public BancoRN getBancoRN() {
		return bancoRN;
	}

	public void setBancoRN(BancoRN bancoRN) {
		this.bancoRN = bancoRN;
	}

	public List<Banco> getListaBanco() {
		return listaBanco;
	}

	public void setListaBanco(List<Banco> listaBanco) {
		this.listaBanco = listaBanco;
	}

}
