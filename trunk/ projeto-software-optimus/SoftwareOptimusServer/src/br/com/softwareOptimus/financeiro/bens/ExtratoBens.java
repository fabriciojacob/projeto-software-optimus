package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;
import br.com.softwareOptimus.financeiro.RN.CaixaRN;
import br.com.softwareOptimus.financeiro.RN.ContaBancariaRN;
import br.com.softwareOptimus.financeiro.RN.ExtratoRN;

@ViewScoped
@ManagedBean
public class ExtratoBens {

	private Extrato extrato = new Extrato();
	private ExtratoRN extratoRN = new ExtratoRN();
	private List<Extrato> listaExtrato = new ArrayList<>();
	private Date dataIni, dataFim;
	private ContaBancaria conta;
	private Caixa caixa;
	private List<ContaBancaria> contas = new ArrayList<>();
	private List<Caixa> caixas = new ArrayList<>();
	private boolean ativaCaixa = true, ativaConta = true;
	private String destinoExtrato;

	public void pesquisaExtrato() {
		try {
			listaExtrato.clear();
			listaExtrato = extratoRN.pesquisa(dataIni, dataFim, caixa, conta);
		} catch (Exception e) {
			msgErro("Problemas na listagem do extrato ", e);
		}
	}

	public void ativoTipoFiltro() {
		try {
			if (destinoExtrato.equals("CONTA")) {
				ContaBancariaRN contaBancariaRN = new ContaBancariaRN();
				contas = contaBancariaRN.listaGeral();
				caixas.clear();
				ativaConta = false;
				ativaCaixa = true;
			} else {
				CaixaRN caixaRN = new CaixaRN();
				caixas = caixaRN.listaCaixa();
				contas.clear();
				ativaCaixa = false;
				ativaConta = true;
			}
		} catch (Exception e) {
			msgErro("Problemas no tipo do filtro", e);
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

	public Extrato getExtrato() {
		return extrato;
	}

	public void setExtrato(Extrato extrato) {
		this.extrato = extrato;
	}

	public ExtratoRN getExtratoRN() {
		return extratoRN;
	}

	public void setExtratoRN(ExtratoRN extratoRN) {
		this.extratoRN = extratoRN;
	}

	public List<Extrato> getListaExtrato() {
		return listaExtrato;
	}

	public void setListaExtrato(List<Extrato> listaExtrato) {
		this.listaExtrato = listaExtrato;
	}

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public String getDestinoExtrato() {
		return destinoExtrato;
	}

	public void setDestinoExtrato(String destinoExtrato) {
		this.destinoExtrato = destinoExtrato;
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}

	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}

	public List<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}

	public boolean isAtivaCaixa() {
		return ativaCaixa;
	}

	public void setAtivaCaixa(boolean ativaCaixa) {
		this.ativaCaixa = ativaCaixa;
	}

	public boolean isAtivaConta() {
		return ativaConta;
	}

	public void setAtivaConta(boolean ativaConta) {
		this.ativaConta = ativaConta;
	}

}
