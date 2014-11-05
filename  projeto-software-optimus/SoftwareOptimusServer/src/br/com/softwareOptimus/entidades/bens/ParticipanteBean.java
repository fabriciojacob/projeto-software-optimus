package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.TipoTelefone;
import br.com.softwareOptimus.entidades.RN.ParticipanteRN;
import br.com.softwareOptimus.entidades.RN.geral.EmailRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;
import br.com.softwareOptimus.entidades.RN.geral.TelefoneRN;

@ManagedBean
@ViewScoped
public class ParticipanteBean {

	private PessoaFisica pessoaFisica = new PessoaFisica();
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Long id, idLogr, idTel, idEmail;
	private List<Email> listaEmail = new ArrayList<>();
	private List<Logradouro> listaEnd = new ArrayList<>();
	public List<PessoaFisica> listaPessoaFisica = new ArrayList<>();
	public List<PessoaJuridica> listaPessoaJuridica = new ArrayList<>();
	private ParticipanteRN participanteRN;
	private LogradouroRN logrRN;
	private Logradouro logradouro = new Logradouro();
	private String tipoLogrSelecionado = null, selecionadaPessoa = null,
			tipoParticipante = null, tipoPJ = null, filtro = null,
			textoConsulta = null, tipoSelecionadoTel = null, dddTel;
	private List<Telefone> listaTelefone = new ArrayList<>();
	private boolean salvar = true, cancelar = true, enderecos = true,
			salReg = true, email = true, telefone = true, padraoNFE,
			novo = false, consulta = false, tipoParPerFis = true,
			inaParPerFis = true, nomeParPesFis = true, cpfParPesFis = true,
			rgParPesFis = true, tipoParPerJur = true, inaParPerJur = true,
			nomeParPesJur = true, razParPesJur = true, cnpjParPesJur = true,
			inscParPesJur = true, cnaeParPesJur = true;
	private Telefone tel = new Telefone();
	private Email emails = new Email();

	public void salvarPJ() {
		this.participanteRN = new ParticipanteRN();
		if (tipoParticipante.equals(NaturezaPessoa.FORNECEDOR.toString())) {
			this.pessoaJuridica.setNaturezaPessoa(NaturezaPessoa.FORNECEDOR);
		} else if (tipoParticipante.equals(NaturezaPessoa.CLIENTE.toString())) {
			this.pessoaJuridica.setNaturezaPessoa(NaturezaPessoa.CLIENTE);
		} else if (tipoParticipante.equals(NaturezaPessoa.TRANSPORTADORA
				.toString())) {
			this.pessoaJuridica.equals(NaturezaPessoa.TRANSPORTADORA);
		} else {
			this.pessoaJuridica.equals(NaturezaPessoa.CONTADOR);
		}
		Integer retorno = this.participanteRN.validaCampoNuloPJ(pessoaJuridica);
		if (retorno == 0) {
			try {
				participanteRN.salvarPJ(pessoaJuridica);
				msgAcerto("Registro salvo com sucesso");
				this.novo = false;
				this.enderecos = false;
				this.salReg = false;
				this.email = false;
				this.telefone = false;
			} catch (Exception e) {
				msgErro("Problemas na gravacao ", e);
			}

		} else {
			msgNull("Existem campos Nulo no Formulário");
		}
	}

	public void salvarPF() {
		try {
			participanteRN = new ParticipanteRN();
			if (tipoParticipante.equals(NaturezaPessoa.FORNECEDOR.toString())) {
				this.pessoaFisica.setNaturezaPessoa(NaturezaPessoa.FORNECEDOR);
			} else if (tipoParticipante.equals(NaturezaPessoa.CLIENTE
					.toString())) {
				this.pessoaFisica.setNaturezaPessoa(NaturezaPessoa.CLIENTE);
			} else if (tipoParticipante.equals(NaturezaPessoa.TRANSPORTADORA
					.toString())) {
				this.pessoaFisica
						.setNaturezaPessoa(NaturezaPessoa.TRANSPORTADORA);
			} else {
				this.pessoaFisica.setNaturezaPessoa(NaturezaPessoa.CONTADOR);
			}
			Integer retorno = this.participanteRN
					.validaCampoNuloPF(this.pessoaFisica);
			if (retorno == 0) {
				participanteRN.salvarPF(pessoaFisica);
				msgAcerto("Registro salvo com sucesso");
				this.novo = false;
				this.enderecos = false;
				this.salReg = false;
				this.email = false;
				this.telefone = false;
			} else {
				msgErro("Existem campos não preenchidos", null);
			}
		} catch (Exception e) {
			msgErro("Problemas ao salvar", e);
		}
	}

	public void salvarLogr(Municipio municipio) {
		logradouro.setIdEndereco(null);
		if (tipoLogrSelecionado.equals(TipoLogradouro.COBRANCA.toString())) {
			logradouro.setTipoLogr(TipoLogradouro.COBRANCA);
		} else if (tipoLogrSelecionado
				.equals(TipoLogradouro.ENTREGA.toString())) {
			logradouro.setTipoLogr(TipoLogradouro.ENTREGA);
		} else if (tipoLogrSelecionado.equals(TipoLogradouro.COMERCIAL
				.toString())) {
			logradouro.setTipoLogr(TipoLogradouro.COMERCIAL);
		} else {
			logradouro.setTipoLogr(TipoLogradouro.RESIDENCIAL);
		}

		try {
			logrRN = new LogradouroRN();
			try {
				if (this.pessoaFisica.getIdPessoa() == null) {
					logradouro.setPessoa(this.pessoaJuridica);
				} else {
					logradouro.setPessoa(this.pessoaFisica);
				}
			} catch (NullPointerException e) {
				logradouro.setPessoa(this.pessoaJuridica);
			}
			logradouro.setMunicipio(municipio);
			logrRN.salvar(logradouro);
			msgAcerto("Logradouro salvo com sucesso");
			listaLogradouro();
			this.logradouro = new Logradouro();
		} catch (Exception e) {
			msgErro("Problemas na gravacao do endereço", e);
		}
	}

	public void listaLogradouro() {
		this.participanteRN = new ParticipanteRN();
		if (this.listaEnd != null) {
			this.listaEnd.clear();
		}
		try {
			try {
				if (this.pessoaFisica.getIdPessoa() == 0) {
					this.listaEnd = participanteRN
							.listaLogr(this.pessoaJuridica);
				} else {
					this.listaEnd = participanteRN.listaLogr(this.pessoaFisica);
				}
			} catch (NullPointerException e) {
				this.listaEnd = participanteRN.listaLogr(this.pessoaJuridica);
			}
		} catch (Exception e) {
			msgErro("Problemas na listagem dos logradouros", e);
		}
	}

	public void novo() {
		this.pessoaJuridica = new PessoaJuridica();
		this.pessoaFisica = new PessoaFisica();
		this.listaEnd = new ArrayList<>();
		this.listaEmail = new ArrayList<>();
		this.listaTelefone = new ArrayList<>();
		this.salvar = false;
		this.cancelar = false;
		this.novo = true;
		this.salReg = true;
		this.enderecos = true;
		this.email = true;
		this.telefone = true;
		habilitar();
	}

	public void pesquisaPJ() {
		this.participanteRN = new ParticipanteRN();
		String cnpj = "cnpj";
		try {
			if (this.listaPessoaJuridica != null) {
				this.listaPessoaJuridica.clear();
			}
			if (!textoConsulta.equals("") && !filtro.equals("")) {
				if (filtro.equals(cnpj)) {
					this.listaPessoaJuridica = this.participanteRN
							.listaPJCNPJ(textoConsulta);
				} else {
					this.listaPessoaJuridica = this.participanteRN
							.listaPJNome(textoConsulta);
				}
			} else {
				this.listaPessoaJuridica = this.participanteRN
						.listaPJNome(textoConsulta);
			}
			this.salvar = false;
			this.cancelar = false;
			this.enderecos = false;
			this.salReg = false;
			this.email = false;
			this.telefone = false;
		} catch (Exception e) {
			msgErro("Problemas na pesquisa", e);
		}

	}

	public void pesquisaPF() {
		this.participanteRN = new ParticipanteRN();
		String cpf = "cpf";
		try {
			if (this.listaPessoaFisica != null) {
				this.listaPessoaFisica.clear();
			}
			if (!textoConsulta.equals("") && !filtro.equals("")) {
				if (filtro.equals(cpf)) {
					this.listaPessoaFisica = this.participanteRN
							.listaPFCPF(textoConsulta);
				} else if (filtro.equals("nomeFantasia")) {
					this.listaPessoaFisica = this.participanteRN
							.listaPFNome(textoConsulta);
				}
			} else {
				this.listaPessoaFisica = this.participanteRN
						.listaPFNome(textoConsulta);
			}
			this.salvar = false;
			this.cancelar = false;
			this.enderecos = false;
			this.salReg = false;
			this.email = false;
			this.telefone = false;
		} catch (Exception e) {
			msgErro("Problemas na pesquisa", e);
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

	public void msgNull(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", msg));
	}

	public void editar() {
		this.participanteRN = new ParticipanteRN();
		try {
			this.pessoaFisica = this.participanteRN.carregaIDPF(id);
			this.tipoParticipante = this.pessoaFisica.getNaturezaPessoa()
					.toString();
			habilitar();
		} catch (Exception e) {
			msgErro("Problemas na edição", e);
		}
		listaLogradouro();
		listaEmail();
		listaTelefone();
		this.salvar = false;
		this.cancelar = false;
		this.enderecos = false;
		this.salReg = false;
		this.email = false;
		this.telefone = false;
	}

	public void editarPJ() {
		this.participanteRN = new ParticipanteRN();
		try {
			this.pessoaJuridica = this.participanteRN.carregaIDPJ(id);
			this.tipoParticipante = this.pessoaJuridica.getNaturezaPessoa()
					.toString();
			habilitar();
		} catch (Exception e) {
			msgErro("Problemas na edição", e);
		}
		listaLogradouro();
		listaEmail();
		listaTelefone();
		this.salvar = false;
		this.cancelar = false;
		this.enderecos = false;
		this.salReg = false;
		this.email = false;
		this.telefone = false;
	}

	public void excluirLogr() {
		LogradouroRN logrRN = new LogradouroRN();
		try {
			logrRN.excluirLogr(idLogr);
			msgAcerto("Logradouro excluido com sucesso");
			listaLogradouro();
		} catch (Exception e) {
			msgErro("Problemas na exclusão do logradouro", e);
		}
	}

	public void listaEmail() {
		EmailRN emailRN = new EmailRN();
		try {
			if (this.listaEmail != null) {
				this.listaEmail.clear();
			}
			if (this.pessoaFisica.getIdPessoa() == null) {
				this.listaEmail = emailRN.listaEmail(pessoaJuridica);
			} else {
				this.listaEmail = emailRN.listaEmail(pessoaFisica);
			}
		} catch (Exception e) {
			msgErro("Problemas na listagem dos emails", e);
		}
	}

	public void excluirEmail() {
		EmailRN emailRN = new EmailRN();
		try {
			emailRN.excluir(idEmail);
			msgAcerto("Email excluido com sucesso");
			listaEmail();
		} catch (Exception e) {
			msgErro("Problemas na exclusão do email", e);
		}
	}

	public void salvarEmail() {
		EmailRN emailRN = new EmailRN();
		Integer pNfe = 0, checkNFe = 0;
		Integer retorno = emailRN.validaCampoNulo(this.emails);
		if (retorno == 0) {
			try {
				try {
					if (this.pessoaFisica.getIdPessoa() == 0) {
						checkNFe = emailRN.validaEmailNFE(pessoaJuridica);
					} else {
						checkNFe = emailRN.validaEmailNFE(pessoaFisica);
					}
				} catch (NullPointerException e) {
					checkNFe = emailRN.validaEmailNFE(pessoaJuridica);
				}
			} catch (Exception e) {
				msgErro("Problemas na validação do email", e);
			}
			if (padraoNFE && checkNFe == 1) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Ja existe um email como padrão NFE"));
			} else {
				try {
					if (this.pessoaFisica.getIdPessoa() == 0) {
						emails.setPessoa(pessoaJuridica);
					} else {
						emails.setPessoa(pessoaFisica);
					}
				} catch (NullPointerException e) {
					emails.setPessoa(pessoaJuridica);
				}
				if (padraoNFE) {
					pNfe = 1;
					emails.setPadraoNFe(pNfe);
				} else {
					emails.setPadraoNFe(pNfe);
				}
				try {
					emailRN.salvar(emails);
					msgAcerto("Email salvo com sucesso");
					this.emails = new Email();
					listaEmail();
				} catch (Exception e) {
					msgErro("Problemas na inclusão do email", e);
				}
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Existem campos nulos no formulário"));
		}
	}

	public void excluirTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		try {
			telefoneRN.excluir(idTel);
			msgAcerto("Telefone excluido com sucesso");
			listaTelefone();
		} catch (Exception e) {
			msgErro("Problemas na exclusao do telefone", e);
		}
	}

	public void listaTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		try {
			if (this.listaTelefone != null) {
				this.listaTelefone.clear();
			}
			try {
				if (this.pessoaFisica.getIdPessoa() == 0) {
					this.listaTelefone = telefoneRN
							.listaTelefone(pessoaJuridica);
				} else {
					this.listaTelefone = telefoneRN.listaTelefone(pessoaFisica);
				}
			} catch (NullPointerException e) {
				this.listaTelefone = telefoneRN.listaTelefone(pessoaJuridica);
			}
		} catch (Exception e) {
			msgErro("Problemas em listar os telefones", e);
		}
	}

	public void salvarTelefone() {
		TelefoneRN telefoneRN = new TelefoneRN();
		if (tipoSelecionadoTel.equals(TipoTelefone.CELULAR.toString())) {
			this.tel.setTipoFone(TipoTelefone.CELULAR);
		} else if (tipoSelecionadoTel.equals(TipoTelefone.COMERCIAL.toString())) {
			this.tel.setTipoFone(TipoTelefone.COMERCIAL);
		} else if (tipoSelecionadoTel.equals(TipoTelefone.RESIDENCIAL
				.toString())) {
			this.tel.setTipoFone(TipoTelefone.RESIDENCIAL);
		}
		try {
			try {
				if (this.pessoaFisica.getIdPessoa() == 0) {
					this.tel.setPessoa(pessoaJuridica);
				} else {
					this.tel.setPessoa(pessoaFisica);
				}
			} catch (NullPointerException e) {
				this.tel.setPessoa(pessoaJuridica);
			}
			Integer retorno = telefoneRN.validaCampoNulo(tel, dddTel);
			if (retorno == 0) {
				this.tel.setNumero(this.dddTel + this.tel.getNumero());
				telefoneRN.salvar(tel);
				msgAcerto("Telefone salvo com sucesso");
				this.dddTel = new String();
				listaTelefone();
				this.tel = new Telefone();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			msgErro("Problemas em salvar o telefone", e);
		}
	}

	public void habilitar() {
		this.tipoParPerFis = false;
		this.inaParPerFis = false;
		this.nomeParPesFis = false;
		this.cpfParPesFis = false;
		this.rgParPesFis = false;
		// ***********************
		this.tipoParPerJur = false;
		this.inaParPerJur = false;
		this.nomeParPesJur = false;
		this.razParPesJur = false;
		this.cnpjParPesJur = false;
		this.inscParPesJur = false;
		this.cnaeParPesJur = false;
	}

	public void desabilitar() {
		this.tipoParPerFis = true;
		this.inaParPerFis = true;
		this.nomeParPesFis = true;
		this.cpfParPesFis = true;
		this.rgParPesFis = true;
		// ***********************
		this.tipoParPerJur = true;
		this.inaParPerJur = true;
		this.nomeParPesJur = true;
		this.razParPesJur = true;
		this.cnpjParPesJur = true;
		this.inscParPesJur = true;
		this.cnaeParPesJur = true;
	}

	public String getDddTel() {
		return dddTel;
	}

	public void setDddTel(String dddTel) {
		this.dddTel = dddTel;
	}

	public ParticipanteRN getParticipanteRN() {
		return participanteRN;
	}

	public void setParticipanteRN(ParticipanteRN participanteRN) {
		this.participanteRN = participanteRN;
	}

	public LogradouroRN getLogrRN() {
		return logrRN;
	}

	public void setLogrRN(LogradouroRN logrRN) {
		this.logrRN = logrRN;
	}

	public boolean isTipoParPerFis() {
		return tipoParPerFis;
	}

	public void setTipoParPerFis(boolean tipoParPerFis) {
		this.tipoParPerFis = tipoParPerFis;
	}

	public boolean isInaParPerFis() {
		return inaParPerFis;
	}

	public void setInaParPerFis(boolean inaParPerFis) {
		this.inaParPerFis = inaParPerFis;
	}

	public boolean isNomeParPesFis() {
		return nomeParPesFis;
	}

	public void setNomeParPesFis(boolean nomeParPesFis) {
		this.nomeParPesFis = nomeParPesFis;
	}

	public boolean isCpfParPesFis() {
		return cpfParPesFis;
	}

	public void setCpfParPesFis(boolean cpfParPesFis) {
		this.cpfParPesFis = cpfParPesFis;
	}

	public boolean isRgParPesFis() {
		return rgParPesFis;
	}

	public void setRgParPesFis(boolean rgParPesFis) {
		this.rgParPesFis = rgParPesFis;
	}

	public String getTipoPJ() {
		return tipoPJ;
	}

	public void setTipoPJ(String tipoPJ) {
		this.tipoPJ = tipoPJ;
	}

	public String getSelecionadaPessoa() {
		return selecionadaPessoa;
	}

	public void setSelecionadaPessoa(String selecionadaPessoa) {
		this.selecionadaPessoa = selecionadaPessoa;
	}

	public List<Logradouro> getListaEnd() {
		return listaEnd;
	}

	public void setListaEnd(List<Logradouro> listaEnd) {
		this.listaEnd = listaEnd;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoLogrSelecionado() {
		return tipoLogrSelecionado;
	}

	public void setTipoLogrSelecionado(String tipoLogrSelecionado) {
		this.tipoLogrSelecionado = tipoLogrSelecionado;
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

	public boolean isEnderecos() {
		return enderecos;
	}

	public void setEnderecos(boolean enderecos) {
		this.enderecos = enderecos;
	}

	public boolean isSalReg() {
		return salReg;
	}

	public void setSalReg(boolean salReg) {
		this.salReg = salReg;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public boolean isTelefone() {
		return telefone;
	}

	public void setTelefone(boolean telefone) {
		this.telefone = telefone;
	}

	public boolean isPadraoNFE() {
		return padraoNFE;
	}

	public void setPadraoNFE(boolean padraoNFE) {
		this.padraoNFE = padraoNFE;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public List<Email> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(List<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdLogr() {
		return idLogr;
	}

	public void setIdLogr(Long idLogr) {
		this.idLogr = idLogr;
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

	public String getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(String tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public List<PessoaFisica> getListaPessoaFisica() {
		return listaPessoaFisica;
	}

	public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
		this.listaPessoaFisica = listaPessoaFisica;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getTextoConsulta() {
		return textoConsulta;
	}

	public void setTextoConsulta(String textoConsulta) {
		this.textoConsulta = textoConsulta;
	}

	public String getTipoSelecionadoTel() {
		return tipoSelecionadoTel;
	}

	public void setTipoSelecionadoTel(String tipoSelecionadoTel) {
		this.tipoSelecionadoTel = tipoSelecionadoTel;
	}

	public Telefone getTel() {
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}

	public Email getEmails() {
		return emails;
	}

	public void setEmails(Email emails) {
		this.emails = emails;
	}

	public List<PessoaJuridica> getListaPessoaJuridica() {
		return listaPessoaJuridica;
	}

	public void setListaPessoaJuridica(List<PessoaJuridica> listaPessoaJuridica) {
		this.listaPessoaJuridica = listaPessoaJuridica;
	}

	public boolean isTipoParPerJur() {
		return tipoParPerJur;
	}

	public void setTipoParPerJur(boolean tipoParPerJur) {
		this.tipoParPerJur = tipoParPerJur;
	}

	public boolean isInaParPerJur() {
		return inaParPerJur;
	}

	public void setInaParPerJur(boolean inaParPerJur) {
		this.inaParPerJur = inaParPerJur;
	}

	public boolean isNomeParPesJur() {
		return nomeParPesJur;
	}

	public void setNomeParPesJur(boolean nomeParPesJur) {
		this.nomeParPesJur = nomeParPesJur;
	}

	public boolean isRazParPesJur() {
		return razParPesJur;
	}

	public void setRazParPesJur(boolean razParPesJur) {
		this.razParPesJur = razParPesJur;
	}

	public boolean isCnpjParPesJur() {
		return cnpjParPesJur;
	}

	public void setCnpjParPesJur(boolean cnpjParPesJur) {
		this.cnpjParPesJur = cnpjParPesJur;
	}

	public boolean isInscParPesJur() {
		return inscParPesJur;
	}

	public void setInscParPesJur(boolean inscParPesJur) {
		this.inscParPesJur = inscParPesJur;
	}

	public boolean isCnaeParPesJur() {
		return cnaeParPesJur;
	}

	public void setCnaeParPesJur(boolean cnaeParPesJur) {
		this.cnaeParPesJur = cnaeParPesJur;
	}

}
