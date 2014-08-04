package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.entidades.TipoTelefone;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.geral.EmailRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;
import br.com.softwareOptimus.entidades.RN.geral.TelefoneRN;
import br.com.softwareOptimus.fiscal.Regime;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

@ManagedBean(name = "empresaBean")
@SessionScoped
public class EmpresaBean {

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Logradouro logradouro = new Logradouro();
	private String tipoSelecionado = null;
	private String tipoSelecionadoTel = null;
	private String tipoRegime = null;
	private String tipoConsulta = null;
	private boolean disable = false;
	private String filtro = null;
	private List<PessoaJuridica> retornoListaPessoa = new ArrayList<>();
	private List<Logradouro> listaEnd = new ArrayList<>();
	private Long id, idReg, idLogr, idTel, idEmail;
	private VigenciaRegime regime = new VigenciaRegime();
	private List<VigenciaRegime> listaReg = new ArrayList<>();
	private Email emails = new Email();
	private List<Email> listaEmail = new ArrayList<>();
	private List<Telefone> listaTelefone = new ArrayList<>();
	private Telefone tel = new Telefone();
	private boolean padraoNFE;
	private boolean salvar = true, cancelar = true, enderecos = true,
			salReg = true, email = true, telefone = true;
	private boolean novo = false, consulta = false;

	public String getTipoSelecionadoTel() {
		return tipoSelecionadoTel;
	}

	public void setTipoSelecionadoTel(String tipoSelecionadoTel) {
		this.tipoSelecionadoTel = tipoSelecionadoTel;
	}

	public boolean isPadraoNFE() {
		return padraoNFE;
	}

	public void setPadraoNFE(boolean padraoNFE) {
		this.padraoNFE = padraoNFE;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Telefone getTel() {
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}

	public boolean isTelefone() {
		return telefone;
	}

	public void setTelefone(boolean telefone) {
		this.telefone = telefone;
	}

	public List<Email> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(List<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public Email getEmails() {
		return emails;
	}

	public void setEmails(Email emails) {
		this.emails = emails;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public Long getIdTel() {
		return idTel;
	}

	public void setIdTel(Long idTel) {
		this.idTel = idTel;
	}

	public Long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public boolean isSalReg() {
		return salReg;
	}

	public void setSalReg(boolean salReg) {
		this.salReg = salReg;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public boolean isSalvar() {
		return salvar;
	}

	public void setSalvar(boolean salvar) {
		this.salvar = salvar;
	}

	public boolean isCancelar() {
		return cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public boolean isEnderecos() {
		return enderecos;
	}

	public void setEnderecos(boolean enderecos) {
		this.enderecos = enderecos;
	}

	public Long getIdLogr() {
		return idLogr;
	}

	public void setIdLogr(Long idLogr) {
		this.idLogr = idLogr;
	}

	public List<VigenciaRegime> getListaReg() {
		return listaReg;
	}

	public void setListaReg(List<VigenciaRegime> listaReg) {
		this.listaReg = listaReg;
	}

	public Long getIdReg() {
		return idReg;
	}

	public void setIdReg(Long idReg) {
		this.idReg = idReg;
	}

	public List<Logradouro> getListaEnd() {
		return listaEnd;
	}

	public void setListaEnd(List<Logradouro> listaEnd) {
		this.listaEnd = listaEnd;
	}

	public String getTipoRegime() {
		return tipoRegime;
	}

	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}

	public VigenciaRegime getRegime() {
		return regime;
	}

	public void setRegime(VigenciaRegime regime) {
		this.regime = regime;
	}

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
			this.novo = false;
			this.enderecos = false;
			this.salReg = false;
			this.email = false;
			this.telefone = false;
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
		if (tipoSelecionado.equals(TipoLogradouro.COBRANCA.toString())) {
			logr.setTipoLogr(TipoLogradouro.COBRANCA);
		} else if (tipoSelecionado.equals(TipoLogradouro.ENTREGA.toString())) {
			logr.setTipoLogr(TipoLogradouro.ENTREGA);
		} else if (tipoSelecionado.equals(TipoLogradouro.COMERCIAL.toString())) {
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
							"EndereÃ§o salvo com sucesso"));
			listaLogradouro();
			this.logradouro = new Logradouro();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do endereÃ§o "
									+ e.getMessage()));
		}
	}

	public void pesquisa() {
		EmpresaRN empresaRN = new EmpresaRN();
		String cnpj = "cnpj";
		try {
			if (filtro.equals(cnpj)) {
				if (this.retornoListaPessoa != null) {
					this.retornoListaPessoa.clear();
				}
				this.retornoListaPessoa = empresaRN.pesquisaCNPJ(tipoConsulta);
			} else {
				if (this.retornoListaPessoa != null) {
					this.retornoListaPessoa.clear();
				}
				this.retornoListaPessoa = empresaRN.pesquisaNome(tipoConsulta);
			}
			this.salvar = false;
			this.cancelar = false;
			this.enderecos = false;
			this.salReg = false;
			this.email = false;
			this.telefone = false;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na consulta do registro "
									+ e.getMessage()));
		}
	}

	public void salvarRegime() {
		EmpresaRN empresaRN = new EmpresaRN();
		int retorno = validaRegime(this.pessoaJuridica,
				this.regime.getDataInicio(), empresaRN);
		if (retorno == 0) {
			this.regime.setIdVigReg(null);
			if (tipoRegime.equals(Regime.LUCROPRESUMIDO.toString())) {
				this.regime.setRegime(Regime.LUCROPRESUMIDO);
			} else if (tipoRegime.equals(Regime.LUCROREAL.toString())) {
				this.regime.setRegime(Regime.LUCROREAL);
			} else {
				this.regime.setRegime(Regime.SIMPLES);
			}
			try {
				this.regime.setPessaoJuridica(this.pessoaJuridica);
				empresaRN.salvarRegime(this.regime);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Regime salvo com sucesso"));
				listaRegime();
				this.regime = new VigenciaRegime();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Problemas na gravacao do regime"
										+ e.getMessage()));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Ja existe esse regime cadastrado"));
		}

	}

	public int validaRegime(PessoaJuridica pessoa, Date data,
			EmpresaRN empresaRN) {
		int retorno = 0;
		try {
			List<VigenciaRegime> listaRegime = empresaRN.validaRegime(pessoa,
					data);
			if(listaRegime.isEmpty()){
				retorno = 0;
			}else{
				retorno =1;
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na verificação do regime"
									+ e.getMessage()));
			retorno = 1;
		}
		return retorno;
	}

	public void listaLogradouro() {
		EmpresaRN empresaRN = new EmpresaRN();
		if (this.listaEnd != null) {
			this.listaEnd.clear();
		}
		this.listaEnd = empresaRN.listaLogr(this.pessoaJuridica);
	}

	public void listaRegime() {
		EmpresaRN empresaRN = new EmpresaRN();
		try {
			if (this.listaReg != null) {
				this.listaReg.clear();
			}
			this.listaReg = empresaRN.listaReg(this.pessoaJuridica);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na listagem dos regimes"
									+ e.getMessage()));
		}
	}

	public void editEmp() {
		EmpresaRN empresaRN = new EmpresaRN();
		this.pessoaJuridica = empresaRN.pesquisaId(id);
		listaLogradouro();
		listaRegime();
		listaEmail();
		listaTelefone();
		this.salvar = false;
		this.cancelar = false;
		this.enderecos = false;
		this.salReg = false;
		this.email = false;
		this.telefone = false;
	}

	public void novo() {
		this.pessoaJuridica = new PessoaJuridica();
		this.listaEnd = new ArrayList<>();
		this.listaReg = new ArrayList<>();
		this.listaEmail = new ArrayList<>();
		this.listaTelefone = new ArrayList<>();
		this.salvar = false;
		this.cancelar = false;
		this.novo = true;
		this.salReg = true;
		this.enderecos = true;
		this.email = true;
		this.telefone = true;

	}

	public void excluirRegime() {
		EmpresaRN empresaRN = new EmpresaRN();
		try {
			empresaRN.excluirVigReg(idReg);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Regime excluido com sucesso"));
			listaRegime();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na exclusï¿½o do regime"
									+ e.getMessage()));
		}
	}

	public void excluirLogr() {
		LogradouroRN logrRN = new LogradouroRN();
		try {
			logrRN.excluirLogr(idLogr);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Logradouro excluido com sucesso"));
			listaLogradouro();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na exclusï¿½o do logradouro"
									+ e.getMessage()));
		}
	}

	public void listaEmail() {
		EmailRN emailRN = new EmailRN();
		try {
			if (this.listaEmail != null) {
				this.listaEmail.clear();
			}
			this.listaEmail = emailRN.listaEmail(pessoaJuridica);
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na listagem de emails"
											+ e.getMessage()));
		}
	}

	public void excluirEmail() {
		EmailRN emailRN = new EmailRN();
		try {
			emailRN.excluir(idEmail);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Email excluido com sucesso"));
			listaEmail();
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na exclusï¿½o do email"
											+ e.getMessage()));
		}
	}

	public void salvarEmail() {
		EmailRN emailRN = new EmailRN();
		Integer pNfe = 0;
		try {
			emails.setPessoa(pessoaJuridica);
			if (padraoNFE) {
				pNfe = 1;
				emails.setPadraoNFe(pNfe);
			} else {
				emails.setPadraoNFe(pNfe);
			}
			emailRN.salvar(emails);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Email salvo com sucesso"));
			this.emails = new Email();
			listaEmail();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na exclusao do email" + e.getMessage()));
		}
	}

	public void excluirTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		try {
			telefoneRN.excluir(idTel);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Telefone excluido com sucesso"));
			listaTelefone();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na exclusao do telefone"
									+ e.getMessage()));
		}
	}

	public void listaTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		try {
			if (this.listaTelefone != null) {
				this.listaTelefone.clear();
			}
			this.listaTelefone = telefoneRN.listaTelefone(pessoaJuridica);
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas em listar os telefones"
											+ e.getMessage()));
		}
	}

	public void salvarTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();

		if (tipoSelecionadoTel.equals(TipoTelefone.CELULAR.toString())) {
			this.tel.setTipoFone(TipoTelefone.CELULAR);
		} else if (tipoSelecionadoTel.equals(TipoTelefone.COMERCIAL.toString())) {
			this.tel.setTipoFone(TipoTelefone.COMERCIAL);
		} else {
			this.tel.setTipoFone(TipoTelefone.RESIDENCIAL);
		}
		try {
			this.tel.setPessoa(pessoaJuridica);
			telefoneRN.salvar(tel);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Telefone salvo com sucesso"));
			listaTelefone();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas em salvar o telefone" + e.getMessage()));
		}
	}
}
