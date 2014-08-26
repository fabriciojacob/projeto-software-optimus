package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;
import br.com.softwareOptimus.financeiro.RN.ContaRN;

@ManagedBean(name = "contaBean")
@ViewScoped
public class ContaBean {

	private Conta conta = new Conta();
	private ContaFilha contaFilha = new ContaFilha();
	private String descricaoPesquisa;
	private List<Conta> listaConta = new ArrayList<>();
	private List<ContaFilha> listaContaFilha = new ArrayList<>();
	private boolean inativa, desabilitarGravar, novo, cancelar, alterar,
			acumulada, consulta, cadastroContaFilha;
	private ContaRN contaRN;
	private Long id, idContaFilha;

	public ContaBean() {
		desabilitarGravar = true;
		novo = false;
		cancelar = true;
		alterar = true;
		acumulada = false;
		consulta = true;
		cadastroContaFilha = true;
	}

	public void gravar() {
		try {
			this.contaRN = new ContaRN();
			this.conta.setIdConta(null);
			this.contaRN.salvarConta(this.conta);
			msgAcerto("Conta salva com sucesso");
			this.desabilitarGravar = true;
			this.alterar = false;
			if(conta.isDesmembrada()){
				cadastroContaFilha = false;
			}
		} catch (Exception e) {
			msgErro("Problemas na gravação da conta", e);
		}
	}
	
	public void salvarContaFilha(){
		this.contaRN = new ContaRN();
		ContaFilha contaTemp = new ContaFilha();
		try{
			contaTemp.setDescricao(this.contaFilha.getDescricao());
			contaTemp.setConta(conta);
			this.contaRN.salvarContaFilha(contaTemp);
			msgAcerto("Conta filha salva com sucesso");
			listaContaFilha();
		}catch (Exception e){
			msgErro("Problemas ao salvar a conta filha ", e);
		}
	}

	public void novo() {
		this.desabilitarGravar = false;
		this.consulta = false;
		this.cancelar = false;
		this.alterar = true;
		this.conta = new Conta();
		if(this.listaContaFilha != null){
			this.listaContaFilha.clear();
		}
	}
	
	public void selecionar(){
		this.contaRN = new ContaRN();
		try {
			this.conta = this.contaRN.pesquisaConta(id);
			this.desabilitarGravar = true;
			this.cancelar = false;
			if(this.conta.isDesmembrada()){
				this.cadastroContaFilha = false;
			}
			listaContaFilha();
		} catch (Exception e) {
			msgErro("Problemas na seleção da conta", e);
		}
	}

	public void editar() {
		this.contaRN = new ContaRN();
		try {
			this.conta = this.contaRN.pesquisaConta(id);
			this.desabilitarGravar = true;
			this.cancelar = false;
			if(!this.conta.isDesmembrada()){
				this.cadastroContaFilha = true;
			}else{
				this.cadastroContaFilha = false;
			}
			msgAcerto("Dado editado com sucesso");
		} catch (Exception e) {
			msgErro("Problemas na pesquisa da conta", e);
		}
	}
	
	public void excluirContaFilha(){
		this.contaRN = new ContaRN();
		try{
			this.contaFilha = this.contaRN.localizaContaFilha(idContaFilha);
			this.contaRN.excluirContaFilha(contaFilha);
			listaContaFilha();
			msgAcerto("Conta excluída com sucesso");
		}catch (Exception e){
			msgErro("Problemas na exclusão", e);
		}
	}


	public void pesquisaConta() {
		this.contaRN = new ContaRN();
		try {
			if(this.listaConta != null){
				this.listaConta.clear();
			}
			this.listaConta = this.contaRN.pesquisaConta(descricaoPesquisa);
			this.alterar = false;
		} catch (Exception e) {
			msgErro("Problemas na pesquisa da conta", e);
		}
	}
	
	public void listaContaFilha(){
		this.contaRN = new ContaRN();
		try{
			if(this.listaContaFilha != null){
				this.listaContaFilha.clear();
			}
			this.listaContaFilha = this.contaRN.listaContaFilha(this.conta);
		}catch (Exception e){
			msgErro("Problemas ao listar as contas filhas ", e);
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

	public ContaFilha getContaFilha() {
		return contaFilha;
	}

	public void setContaFilha(ContaFilha contaFilha) {
		this.contaFilha = contaFilha;
	}

	public Long getIdContaFilha() {
		return idContaFilha;
	}

	public void setIdContaFilha(Long idContaFilha) {
		this.idContaFilha = idContaFilha;
	}

	public boolean isCadastroContaFilha() {
		return cadastroContaFilha;
	}

	public void setCadastroContaFilha(boolean cadastroContaFilha) {
		this.cadastroContaFilha = cadastroContaFilha;
	}
	
	

}
