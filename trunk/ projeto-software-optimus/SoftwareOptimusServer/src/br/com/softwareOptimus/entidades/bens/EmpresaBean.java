package br.com.softwareOptimus.entidades.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.Pessoa;
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
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "empresaBean")
@ViewScoped
public class EmpresaBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = 8428074836380205888L;
	private PessoaJuridica pessoaJuridica;
	private Pessoa pessoa;
	private List<Pessoa> listaEmpresa;
	private Logradouro logradouro;
	private String tipoSelecionado = null;
	private String tipoSelecionadoTel = null;
	private String tipoRegime = null;
	private String tipoConsulta = null;
	private boolean disable = false;
	private String filtro = null, dddTel;
	private List<PessoaJuridica> retornoListaPessoa;
	private List<Logradouro> listaEnd;
	private Long id, idReg, idLogr, idTel, idEmail;
	private VigenciaRegime regime;
	private List<VigenciaRegime> listaReg;
	private Email emails;
	private List<Email> listaEmail;
	private List<Telefone> listaTelefone;
	private Telefone tel;
	private EmpresaRN empresaRN;
	private LogradouroRN logrRN;
	private EmailRN emailRN;
	private TelefoneRN telefoneRN;
	private boolean padraoNFE;
	private boolean salvar = true, cancelar = true, enderecos = true,
			salReg = true, email = true, telefone = true, ina = true,
			nomeFant = true, nomeRaz = true, cnpj = true, inscEst = true,
			cnae = true, datIni = true, reg = true;
	private boolean novo = false, consulta = false;

	public EmpresaBean() {
		retornaListaEmp();
	}

	public void salvarEmp() {
		try {
			Integer retorno = this.getEmpresaRN().validaCampoNulo(
					this.getPessoaJuridica());
			if (retorno == 0) {
				this.getPessoaJuridica().setTipoPessoaJuridica(
						TipoPessoaJuridica.FABRICANTE);
				this.getEmpresaRN().salvar(this.getPessoaJuridica());
				this.info("Empresa salva com sucesso");
				setDisable(false);
				this.setNovo(false);
				this.setEnderecos(false);
				this.setSalReg(false);
				this.setEmail(false);
				this.setTelefone(false);
			} else {
				this.error("Existem campos nulos no formul�rio");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da empresa " + e.getMessage());
		}
	}

	public void salvarLogr(Municipio municipio) {
		Logradouro logr = new Logradouro();
		logr = this.getLogradouro();
		logr.setIdEndereco(null);
		if (this.getTipoSelecionado()
				.equals(TipoLogradouro.COBRANCA.toString())) {
			logr.setTipoLogr(TipoLogradouro.COBRANCA);
		} else if (this.getTipoSelecionado().equals(
				TipoLogradouro.ENTREGA.toString())) {
			logr.setTipoLogr(TipoLogradouro.ENTREGA);
		} else if (this.getTipoSelecionado().equals(
				TipoLogradouro.COMERCIAL.toString())) {
			logr.setTipoLogr(TipoLogradouro.COMERCIAL);
		} else {
			logr.setTipoLogr(TipoLogradouro.RESIDENCIAL);
		}

		try {
			logr.setPessoa(this.getPessoaJuridica());
			logr.setMunicipio(municipio);
			this.getLogrRN().salvar(logr);
			this.info("Endere�o salvo com sucesso");
			listaLogradouro();
			this.logradouro = new Logradouro();
		} catch (Exception e) {
			this.error("Problemas na gravacao do endere�o " + e.getMessage());
		}
	}

	public void pesquisa() {
		String cnpj = "cnpj";
		try {
			this.getRetornoListaPessoa().clear();
			if (!this.getTipoConsulta().equals("")
					&& !this.getFiltro().equals("")) {
				if (this.getFiltro().equals(cnpj)) {
					this.setRetornoListaPessoa(this.getEmpresaRN()
							.pesquisaCNPJ(this.getTipoConsulta()));
				} else if (this.getFiltro().equals("nomeFantasia")) {
					this.setRetornoListaPessoa(this.getEmpresaRN()
							.pesquisaNome(this.getTipoConsulta()));
				}
			} else {
				this.setRetornoListaPessoa(this.getEmpresaRN().pesquisaNome(
						this.getTipoConsulta()));
			}
			this.setSalvar(false);
			this.setCancelar(false);
			this.setEnderecos(false);
			this.setSalReg(false);
			this.setEmail(false);
			this.setTelefone(false);
		} catch (Exception e) {
			this.error("Problemas na consulta do registro " + e.getMessage());
		}
	}

	public void salvarRegime() {
		int retorno = validaRegime(this.getPessoaJuridica(), this.getRegime()
				.getDataInicio(), this.getEmpresaRN());
		if (retorno == 0) {
			this.getRegime().setIdVigReg(null);
			if (this.getTipoRegime().equals(Regime.LUCROPRESUMIDO.toString())) {
				this.getRegime().setRegime(Regime.LUCROPRESUMIDO);
			} else if (this.getTipoRegime().equals(Regime.LUCROREAL.toString())) {
				this.getRegime().setRegime(Regime.LUCROREAL);
			} else {
				this.getRegime().setRegime(Regime.SIMPLES);
			}
			try {
				this.getRegime().setPessaoJuridica(this.getPessoaJuridica());
				this.getEmpresaRN().salvarRegime(this.getRegime());
				this.info("Regime salvo com sucesso");
				listaRegime();
				this.setRegime(null);
			} catch (Exception e) {
				this.error("Problemas na gravacao do regime" + e.getMessage());
			}
		} else {
			this.error("Ja existe esse regime cadastrado");
		}

	}

	public int validaRegime(PessoaJuridica pessoa, Date data,
			EmpresaRN empresaRN) {
		int retorno = 0;
		try {
			List<VigenciaRegime> listaRegime = empresaRN.validaRegime(pessoa,
					data);
			if (listaRegime.isEmpty()) {
				retorno = 0;
			} else {
				retorno = 1;
			}
		} catch (Exception e) {
			this.error("Problemas na verifica��o do regime" + e.getMessage());
			retorno = 1;
		}
		return retorno;
	}

	public void listaLogradouro() {
		this.getListaEnd().clear();
		this.setListaEnd(this.getEmpresaRN()
				.listaLogr(this.getPessoaJuridica()));
	}

	public void listaRegime() {
		try {
			this.getListaReg().clear();
			this.setListaReg(this.getEmpresaRN().listaReg(
					this.getPessoaJuridica()));
		} catch (Exception e) {
			this.error("Problemas na listagem dos regimes" + e.getMessage());
		}
	}

	public void empresaSelecionado(SelectEvent event) {
		PessoaJuridica pj = (PessoaJuridica) event.getObject();
		this.setPessoaJuridica(this.getEmpresaRN().pesquisaId(pj.getIdPessoa()));
		listaLogradouro();
		listaRegime();
		listaEmail();
		listaTelefone();
		this.setSalvar(false);
		this.setCancelar(false);
		this.setEnderecos(false);
		this.setSalReg(false);
		this.setEmail(false);
		this.setTelefone(false);
		habilita();
	}

	public void novo() {
		this.setPessoaJuridica(null);
		this.setListaEnd(null);
		this.setListaReg(null);
		this.setListaEmail(null);
		this.setListaTelefone(null);
		this.setSalvar(false);
		this.setCancelar(false);
		this.setNovo(true);
		this.setSalReg(true);
		this.setEnderecos(true);
		this.setEmail(true);
		this.setTelefone(true);
		habilita();
	}

	public void excluirRegime() {
		try {
			this.getEmpresaRN().excluirVigReg(this.getIdReg());
			this.info("Regime excluido com sucesso");
			listaRegime();
		} catch (Exception e) {
			this.error("Problemas na exclus�o do regime" + e.getMessage());
		}
	}

	public void excluirLogr() {
		try {
			this.getLogrRN().excluirLogr(idLogr);
			this.info("Logradouro excluido com sucesso");
			listaLogradouro();
		} catch (Exception e) {
			this.error("Problemas na exclus�o do logradouro" + e.getMessage());
		}
	}

	public void listaEmail() {
		try {
			this.getListaEmail().clear();
			this.setListaEmail(this.getEmailRN().listaEmail(
					this.getPessoaJuridica()));
		} catch (Exception e) {
			this.error("Problemas na listagem de emails" + e.getMessage());
		}
	}

	public void excluirEmail() {
		try {
			this.getEmailRN().excluir(this.getIdEmail());
			this.info("Email excluido com sucesso");
			listaEmail();
		} catch (Exception e) {
			this.error("Problemas na exclus�o do email" + e.getMessage());
		}
	}

	public void salvarEmail() {
		Integer pNfe = 0, checkNFe = 0;
		try {
			checkNFe = this.getEmailRN().validaEmailNFE(
					this.getPessoaJuridica());
			if (this.isPadraoNFE() && checkNFe == 1) {
				this.error("Ja existe um email como padr�o NFE");
			} else {
				this.getEmails().setPessoa(this.getPessoaJuridica());
				if (this.isPadraoNFE()) {
					pNfe = 1;
					this.getEmails().setPadraoNFe(pNfe);
				} else {
					this.getEmails().setPadraoNFe(pNfe);
				}
				this.getEmailRN().salvar(this.getEmails());
				this.info("Email salvo com sucesso");
				this.setEmails(null);
			}
			listaEmail();
		} catch (Exception e) {
			this.error("Problemas na exclus�o do email" + e.getMessage());
		}
	}

	public void excluirTelefone() {
		try {
			this.getTelefoneRN().excluir(this.getIdTel());
			this.info("Telefone excluido com sucesso");
			listaTelefone();
		} catch (Exception e) {
			this.error("Problemas na exclus�o do telefone" + e.getMessage());
		}
	}

	public void listaTelefone() {
		try {
			this.getListaTelefone().clear();
			this.setListaTelefone(this.getTelefoneRN().listaTelefone(
					this.getPessoaJuridica()));
		} catch (Exception e) {
			this.error("Problemas em listar os telefones" + e.getMessage());
		}
	}

	public void salvarTelefone() {
		if (this.getTipoSelecionadoTel()
				.equals(TipoTelefone.CELULAR.toString())) {
			this.getTel().setTipoFone(TipoTelefone.CELULAR);
		} else if (this.getTipoSelecionadoTel().equals(
				TipoTelefone.COMERCIAL.toString())) {
			this.getTel().setTipoFone(TipoTelefone.COMERCIAL);
		} else if (this.getTipoSelecionadoTel().equals(
				TipoTelefone.RESIDENCIAL.toString())) {
			this.getTel().setTipoFone(TipoTelefone.RESIDENCIAL);
		}
		try {
			Integer retorno = this.getTelefoneRN().validaCampoNulo(
					this.getTel(), this.getDddTel());
			if (retorno == 0) {
				this.getTel().setNumero(
						this.getDddTel() + this.getTel().getNumero());
				this.getTel().setPessoa(this.getPessoaJuridica());
				this.getTelefoneRN().salvar(this.getTel());
				this.setDddTel(null);
				this.setTel(null);
				this.info("Telefone salvo com sucesso");
				listaTelefone();
			} else {
				this.error("Existem campos nulos no formul�rio");
			}
		} catch (Exception e) {
			this.error("Problemas em salvar o telefone" + e.getMessage());
		}
	}

	public void habilita() {
		this.setIna(false);
		this.setNomeFant(false);
		this.setNomeRaz(false);
		this.setCnpj(false);
		this.setInscEst(false);
		this.setCnae(false);
		this.setDatIni(false);
		this.setReg(false);
	}

	public void desabilita() {
		this.setIna(true);
		this.setNomeFant(true);
		this.setNomeRaz(true);
		this.setCnpj(true);
		this.setInscEst(true);
		this.setCnae(true);
		this.setDatIni(true);
		this.setReg(true);
	}

	public boolean isIna() {
		return this.ina;
	}

	public String getDddTel() {
		if (this.dddTel == null) {
			this.dddTel = new String();
		}
		return this.dddTel;
	}

	public void retornaListaEmp() {
		if(empresaRN == null){
			empresaRN = new EmpresaRN();
		}
		try {
			listaEmpresa = empresaRN.listaEmpresa();
		} catch (Exception e) {
			error("Problemas na lista de empresas: " + e.toString());
		}
	}

	public void setDddTel(String dddTel) {
		this.dddTel = dddTel;
	}

	public void setIna(boolean ina) {
		this.ina = ina;
	}

	public boolean isNomeFant() {
		return this.nomeFant;
	}

	public void setNomeFant(boolean nomeFant) {
		this.nomeFant = nomeFant;
	}

	public boolean isNomeRaz() {
		return this.nomeRaz;
	}

	public void setNomeRaz(boolean nomeRaz) {
		this.nomeRaz = nomeRaz;
	}

	public boolean isCnpj() {
		return this.cnpj;
	}

	public void setCnpj(boolean cnpj) {
		this.cnpj = cnpj;
	}

	public boolean isInscEst() {
		return this.inscEst;
	}

	public void setInscEst(boolean inscEst) {
		this.inscEst = inscEst;
	}

	public boolean isCnae() {
		return this.cnae;
	}

	public void setCnae(boolean cnae) {
		this.cnae = cnae;
	}

	public boolean isDatIni() {
		return this.datIni;
	}

	public void setDatIni(boolean datIni) {
		this.datIni = datIni;
	}

	public boolean isReg() {
		return reg;
	}

	public void setReg(boolean reg) {
		this.reg = reg;
	}

	public String getTipoSelecionadoTel() {
		if (this.tipoSelecionadoTel == null) {
			this.tipoSelecionadoTel = new String();
		}
		return this.tipoSelecionadoTel;
	}

	public void setTipoSelecionadoTel(String tipoSelecionadoTel) {
		this.tipoSelecionadoTel = tipoSelecionadoTel;
	}

	public boolean isPadraoNFE() {
		return this.padraoNFE;
	}

	public void setPadraoNFE(boolean padraoNFE) {
		this.padraoNFE = padraoNFE;
	}

	public List<Telefone> getListaTelefone() {
		if (this.listaTelefone == null) {
			this.listaTelefone = new ArrayList<>();
		}
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Telefone getTel() {
		if (this.tel == null) {
			this.tel = new Telefone();
		}
		return this.tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}

	public boolean isTelefone() {
		return this.telefone;
	}

	public void setTelefone(boolean telefone) {
		this.telefone = telefone;
	}

	public List<Email> getListaEmail() {
		if (this.listaEmail == null) {
			this.listaEmail = new ArrayList<Email>();
		}
		return this.listaEmail;
	}

	public void setListaEmail(List<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public Email getEmails() {
		if (this.emails == null) {
			this.emails = new Email();
		}
		return this.emails;
	}

	public void setEmails(Email emails) {
		this.emails = emails;
	}

	public boolean isEmail() {
		return this.email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public Long getIdTel() {
		return this.idTel;
	}

	public void setIdTel(Long idTel) {
		this.idTel = idTel;
	}

	public Long getIdEmail() {
		return this.idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public boolean isSalReg() {
		return this.salReg;
	}

	public void setSalReg(boolean salReg) {
		this.salReg = salReg;
	}

	public boolean isNovo() {
		return this.novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public boolean isSalvar() {
		return this.salvar;
	}

	public void setSalvar(boolean salvar) {
		this.salvar = salvar;
	}

	public boolean isCancelar() {
		return this.cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	public boolean isConsulta() {
		return this.consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public boolean isEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(boolean enderecos) {
		this.enderecos = enderecos;
	}

	public Long getIdLogr() {
		return this.idLogr;
	}

	public void setIdLogr(Long idLogr) {
		this.idLogr = idLogr;
	}

	public List<VigenciaRegime> getListaReg() {
		if (this.listaReg == null) {
			this.listaReg = new ArrayList<>();
		}
		return this.listaReg;
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
		if (this.listaEnd == null) {
			this.listaEnd = new ArrayList<>();
		}
		return this.listaEnd;
	}

	public void setListaEnd(List<Logradouro> listaEnd) {
		this.listaEnd = listaEnd;
	}

	public String getTipoRegime() {
		if (this.tipoRegime == null) {
			this.tipoRegime = new String();
		}
		return this.tipoRegime;
	}

	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}

	public VigenciaRegime getRegime() {
		if (this.regime == null) {
			this.regime = new VigenciaRegime();
		}
		return this.regime;
	}

	public void setRegime(VigenciaRegime regime) {
		this.regime = regime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PessoaJuridica> getRetornoListaPessoa() {
		if (this.retornoListaPessoa == null) {
			this.retornoListaPessoa = new ArrayList<PessoaJuridica>();
		}
		return this.retornoListaPessoa;
	}

	public void setRetornoListaPessoa(List<PessoaJuridica> retornoListaPessoa) {
		this.retornoListaPessoa = retornoListaPessoa;
	}

	public String getFiltro() {
		if (this.filtro == null) {
			this.filtro = new String();
		}
		return this.filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public boolean isDisable() {
		return this.disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public PessoaJuridica getPessoaJuridica() {
		if (this.pessoaJuridica == null) {
			this.pessoaJuridica = new PessoaJuridica();
		}
		return this.pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Logradouro getLogradouro() {
		if (this.logradouro == null) {
			this.logradouro = new Logradouro();
		}
		return this.logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoSelecionado() {
		if (this.tipoSelecionado == null) {
			this.tipoSelecionado = new String();
		}
		return this.tipoSelecionado;
	}

	public void setTipoSelecionado(String tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}

	public String getTipoConsulta() {
		if (this.tipoConsulta == null) {
			this.tipoConsulta = new String();
		}
		return this.tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public EmpresaRN getEmpresaRN() {
		if (this.empresaRN == null) {
			this.empresaRN = new EmpresaRN();
		}
		return this.empresaRN;
	}

	public void setEmpresaRN(EmpresaRN empresaRN) {
		this.empresaRN = empresaRN;
	}

	public LogradouroRN getLogrRN() {
		if (this.logrRN == null) {
			this.logrRN = new LogradouroRN();
		}
		return this.logrRN;
	}

	public void setLogrRN(LogradouroRN logrRN) {
		this.logrRN = logrRN;
	}

	public EmailRN getEmailRN() {
		if (this.emailRN == null) {
			this.emailRN = new EmailRN();
		}
		return this.emailRN;
	}

	public void setEmailRN(EmailRN emailRN) {
		this.emailRN = emailRN;
	}

	public TelefoneRN getTelefoneRN() {
		if (this.telefoneRN == null) {
			this.telefoneRN = new TelefoneRN();
		}
		return this.telefoneRN;
	}

	public void setTelefoneRN(TelefoneRN telefoneRN) {
		this.telefoneRN = telefoneRN;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Pessoa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

}
