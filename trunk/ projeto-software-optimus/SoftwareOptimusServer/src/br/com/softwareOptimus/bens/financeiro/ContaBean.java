package br.com.softwareOptimus.bens.financeiro;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.RN.financeiro.ContaRN;
import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;

@ManagedBean(name = "contaBean")
public class ContaBean {

	private Conta conta = new Conta();
	private String descricaoPesquisa;
	private List<Conta> listaConta = new ArrayList<>();
	private List<ContaFilha> listaContaFilha = new ArrayList<>();
	private boolean inativa, desabilitarGravar, novo, cancelar, alterar,
			acumulada, consulta;
	private ContaRN contaRN;
	private Long id;

	public ContaBean() {
		desabilitarGravar = true;
		novo = false;
		cancelar = true;
		alterar = true;
		acumulada = false;
		consulta = true;
	}

	public void gravar() {
		try {
			this.contaRN = new ContaRN();
			this.contaRN.salvarConta(this.conta);
			msgAcerto("Conta salva com sucesso");
		} catch (Exception e) {
			msgErro("Problemas na gravação da conta", e);
		}
	}

	public void novo() {
		this.desabilitarGravar = false;
		this.consulta = false;
		this.cancelar = false;
		this.alterar = false;
		this.conta = new Conta();
	}

	public void editar() {
		this.contaRN = new ContaRN();
		try {
			this.conta = this.contaRN.pesquisaConta(id);
		} catch (Exception e) {
			msgErro("Problemas na pesquisa da conta", e);
		}
	}

	public void pesquisaConta() {
		this.contaRN = new ContaRN();
		try {
			this.listaConta = this.contaRN.pesquisaConta(descricaoPesquisa);
		} catch (Exception e) {
			msgErro("Problemas na pesquisa da conta", e);
		}
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getDescricaoPesquisa() {
		return descricaoPesquisa;
	}

	public void setDescricaoPesquisa(String descricaoPesquisa) {
		this.descricaoPesquisa = descricaoPesquisa;
	}

	public List<Conta> getListaConta() {
		return listaConta;
	}

	public void setListaConta(List<Conta> listaConta) {
		this.listaConta = listaConta;
	}

	public List<ContaFilha> getListaContaFilha() {
		return listaContaFilha;
	}

	public void setListaContaFilha(List<ContaFilha> listaContaFilha) {
		this.listaContaFilha = listaContaFilha;
	}

	public boolean isInativa() {
		return inativa;
	}

	public void setInativa(boolean inativa) {
		this.inativa = inativa;
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

	public boolean isDesabilitarGravar() {
		return desabilitarGravar;
	}

	public void setDesabilitarGravar(boolean desabilitarGravar) {
		this.desabilitarGravar = desabilitarGravar;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public boolean isCancelar() {
		return cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAcumulada() {
		return acumulada;
	}

	public void setAcumulada(boolean acumulada) {
		this.acumulada = acumulada;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

}
