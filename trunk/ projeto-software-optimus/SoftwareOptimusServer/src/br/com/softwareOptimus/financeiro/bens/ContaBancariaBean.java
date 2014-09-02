package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.financeiro.Banco;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.TipoContaBancaria;
import br.com.softwareOptimus.financeiro.RN.ContaBancariaRN;

@ManagedBean(name = "contaBancariaBean")
@ViewScoped
public class ContaBancariaBean {

	private ContaBancaria contaBancaria = new ContaBancaria();
	private ContaBancariaRN contaBancariaRN;
	private List<ContaBancaria> listaContas = new ArrayList<>();
	private String nomeTitular;
	private Integer txtConta, txtAgencia;
	private String tipoContaBancaria;

	public void gravar(Banco banco) {
		this.contaBancariaRN = new ContaBancariaRN();
		try {
			if(tipoContaBancaria == TipoContaBancaria.CORRENTE.toString()){
				this.contaBancaria.setTipoContaBancaria(TipoContaBancaria.CORRENTE);
			}else{
				this.contaBancaria.setTipoContaBancaria(TipoContaBancaria.POUPANCA);
			}
			this.contaBancaria.setBanco(banco);
			contaBancariaRN.salvar(this.contaBancaria);
			msgAcerto("Conta salva com sucesso !!");
		} catch (Exception e) {
			msgErro("Problemas ao gravar a conta bancária ", e);
		}
	}
	
	public void novo(){
		msgAcerto("teste");
	}

	public void pesquisaConta() {
		this.contaBancariaRN = new ContaBancariaRN();
		try {

		} catch (Exception e) {
			msgErro("Problemas na pesquisa ", e);
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

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public ContaBancariaRN getContaBancariaRN() {
		return contaBancariaRN;
	}

	public void setContaBancariaRN(ContaBancariaRN contaBancariaRN) {
		this.contaBancariaRN = contaBancariaRN;
	}

	public List<ContaBancaria> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<ContaBancaria> listaContas) {
		this.listaContas = listaContas;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Integer getTxtConta() {
		return txtConta;
	}

	public void setTxtConta(Integer txtConta) {
		this.txtConta = txtConta;
	}

	public Integer getTxtAgencia() {
		return txtAgencia;
	}

	public void setTxtAgencia(Integer txtAgencia) {
		this.txtAgencia = txtAgencia;
	}

	public String getTipoContaBancaria() {
		return tipoContaBancaria;
	}

	public void setTipoContaBancaria(String tipoContaBancaria) {
		this.tipoContaBancaria = tipoContaBancaria;
	}

}
