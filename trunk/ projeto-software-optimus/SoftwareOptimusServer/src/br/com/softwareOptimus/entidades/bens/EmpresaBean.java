package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;

@ManagedBean(name = "empresaBean")
@SessionScoped
public class EmpresaBean {

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Logradouro logradouro = new Logradouro();
	private String tipoSelecionado = null;
	private String tipoConsulta = null;
	private boolean disable = false;
	private String filtro = null;
	private List<PessoaJuridica> retornoListaPessoa = new ArrayList<>();
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<PessoaJuridica> getRetornoListaPessoa() {
		return retornoListaPessoa;
	}

	public void setRetornoListaPessoa(List<PessoaJuridica> retornoListaPessoa) {
		this.retornoListaPessoa = retornoListaPessoa;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoSelecionado() {
		return tipoSelecionado;
	}

	public void setTipoSelecionado(String tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public void salvarEmp() {
		try {

			EmpresaRN empresaRN = new EmpresaRN();
			this.pessoaJuridica
					.setTipoPessoaJuridica(TipoPessoaJuridica.FABRICANTE);
			empresaRN.salvar(pessoaJuridica);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Empresa salva com sucesso"));
			setDisable(false);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da empresa "
									+ e.getMessage()));
		}
	}

	public void salvarLogr(Municipio municipio) {
		Logradouro logr = new Logradouro();
		logr = this.logradouro;
		logr.setIdEndereco(null);
		if (tipoSelecionado == TipoLogradouro.COBRANCA.toString()) {
			logr.setTipoLogr(TipoLogradouro.COBRANCA);
		} else if (tipoSelecionado == TipoLogradouro.ENTREGA.toString()) {
			logr.setTipoLogr(TipoLogradouro.ENTREGA);
		} else if (tipoSelecionado == TipoLogradouro.COMERCIAL.toString()) {
			logr.setTipoLogr(TipoLogradouro.COMERCIAL);
		} else {
			logr.setTipoLogr(TipoLogradouro.RESIDENCIAL);
		}

		try {
			LogradouroRN logrRN = new LogradouroRN();
			logr.setPessoa(pessoaJuridica);
			logr.setMunicipio(municipio);
			logrRN.salvar(logr);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Endereço salvo com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do endereço "
									+ e.getMessage()));
		}
	}

	public boolean habilitaButton() {
		return true;
	}

	public boolean desabilitaButton() {
		return false;
	}

	public void pesquisa() {
		EmpresaRN empresaRN = new EmpresaRN();
		String cnpj = "cnpj";
		try {
			if (filtro.equals(cnpj)) {
				this.retornoListaPessoa = empresaRN.pesquisaCNPJ(tipoConsulta);
			} else {
				this.retornoListaPessoa = empresaRN.pesquisaNome(tipoConsulta);
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na consulta do registro "
									+ e.getMessage()));
		}
	}

	public void editEmp() {
		EmpresaRN empresaRN = new EmpresaRN();
		this.pessoaJuridica = empresaRN.pesquisaId(id);
	}
}
