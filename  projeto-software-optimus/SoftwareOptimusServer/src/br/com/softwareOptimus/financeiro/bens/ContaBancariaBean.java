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
	private boolean btSalvar = true, btConsulta = false, btEditar = true, btNovo = false;
	private Long id;

	public void gravar(Banco banco) {
		this.contaBancariaRN = new ContaBancariaRN();
		try {
			if (tipoContaBancaria.equals(TipoContaBancaria.CORRENTE.toString())) {
				this.contaBancaria
						.setTipoContaBancaria(TipoContaBancaria.CORRENTE);
			} else {
				this.contaBancaria
						.setTipoContaBancaria(TipoContaBancaria.POUPANCA);
			}
			this.contaBancaria.setBanco(banco);
			contaBancariaRN.salvar(this.contaBancaria);
			msgAcerto("Conta salva com sucesso !!");
			this.btSalvar = true;
			this.btEditar = false;
		} catch (Exception e) {
			msgErro("Problemas ao gravar a conta bancária ", e);
		}
	}

	public void novo() {
		this.contaBancaria = new ContaBancaria();
		this.btSalvar = false;
	}

	public void editar() {
		try {
			if (tipoContaBancaria.equals(TipoContaBancaria.CORRENTE.toString())) {
				this.contaBancaria
						.setTipoContaBancaria(TipoContaBancaria.CORRENTE);
			} else {
				this.contaBancaria
						.setTipoContaBancaria(TipoContaBancaria.POUPANCA);
			}
			this.contaBancariaRN = new ContaBancariaRN();
			this.contaBancariaRN.alterar(contaBancaria);
			msgAcerto("Registro alterado com sucesso ");
		} catch (Exception e) {
			msgErro("Problemas na alteração ", e);
		}
	}

	public void pesquisaConta() {
		this.contaBancariaRN = new ContaBancariaRN();
		if (this.listaContas != null) {
			this.listaContas.clear();
		}
		try {
			this.listaContas = this.contaBancariaRN
					.pesquisaTitular(nomeTitular);
		} catch (Exception e) {
			msgErro("Problemas na pesquisa ", e);
		}
	}

	public void selecionar() {
		this.contaBancariaRN = new ContaBancariaRN();
		try {
			this.btSalvar = true;
			this.btEditar = false;
			this.contaBancaria = this.contaBancariaRN.pesquisaID(this.id);
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

	public boolean isBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(boolean btSalvar) {
		this.btSalvar = btSalvar;
	}

	public boolean isBtConsulta() {
		return btConsulta;
	}

	public void setBtConsulta(boolean btConsulta) {
		this.btConsulta = btConsulta;
	}

	public boolean isBtEditar() {
		return btEditar;
	}

	public void setBtEditar(boolean btEditar) {
		this.btEditar = btEditar;
	}

	public boolean isBtNovo() {
		return btNovo;
	}

	public void setBtNovo(boolean btNovo) {
		this.btNovo = btNovo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
