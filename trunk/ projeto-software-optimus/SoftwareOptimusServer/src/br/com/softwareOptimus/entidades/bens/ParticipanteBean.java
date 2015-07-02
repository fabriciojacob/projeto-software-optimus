package br.com.softwareOptimus.entidades.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

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
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ParticipanteBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = 8728030689995236693L;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	private Long idLogr, idTel, idEmail;
	private List<Email> listaEmail;
	private List<Logradouro> listaEnd;
	public List<PessoaFisica> listaPessoaFisica;
	private ParticipanteRN participanteRN;
	private LogradouroRN logrRN;
	private EmailRN emailRN;
	private TelefoneRN telefoneRN;
	private Logradouro logradouro;
	private String tipoLogrSelecionado = null;
	private String selecionadaPessoa = null;
	private String tipoParticipante = null;
	private String tipoPJ = null;
	private String tipoSelecionadoTel = null;
	private String dddTel;
	private List<Telefone> listaTelefone;
	private boolean salvar = true;
	private boolean cancelar = true;
	private boolean enderecos = true;
	private boolean salReg = true;
	private boolean email = true;
	private boolean telefone = true;
	private boolean padraoNFE;
	private boolean novo = false;
	private boolean consulta = false;
	private boolean tipoParPerFis = true;
	private boolean inaParPerFis = true;
	private boolean nomeParPesFis = true;
	private boolean cpfParPesFis = true;
	private boolean rgParPesFis = true;
	private boolean tipoParPerJur = true;
	private boolean inaParPerJur = true;
	private boolean nomeParPesJur = true;
	private boolean razParPesJur = true;
	private boolean cnpjParPesJur = true;
	private boolean inscParPesJur = true;
	private boolean cnaeParPesJur = true;
	private Telefone tel;
	private Email emails;

	public void salvarPJ() {
		if (this.getTipoParticipante().equals(NaturezaPessoa.FORNECEDOR.toString())) {
			this.getPessoaJuridica().setNaturezaPessoa(NaturezaPessoa.FORNECEDOR);
		} else if (this.getTipoParticipante().equals(NaturezaPessoa.CLIENTE.toString())) {
			this.getPessoaJuridica().setNaturezaPessoa(NaturezaPessoa.CLIENTE);
		} else if (this.getTipoParticipante().equals(NaturezaPessoa.TRANSPORTADORA.toString())) {
			this.getPessoaJuridica().setNaturezaPessoa(NaturezaPessoa.TRANSPORTADORA);
		} else {
			this.getPessoaJuridica().setNaturezaPessoa(NaturezaPessoa.CONTADOR);
		}
		Integer retorno = this.getParticipanteRN().validaCampoNuloPJ(this.getPessoaJuridica());
		if (retorno == 0) {
			try {
				this.getParticipanteRN().salvarPJ(this.getPessoaJuridica());
				this.info("Registro salvo com sucesso");
				this.setNovo(false);
				this.setEnderecos(false);
				this.setSalReg(false);
				this.setEmail(false);
				this.setTelefone(false);
			} catch (Exception e) {
				this.error("Problemas na gravacao " + e.getMessage());
			}
		} else {
			this.error("Existem campos Nulo no Formulário");
		}
	}

	public void salvarPF() {
		try {
			if (this.getTipoParticipante().equals(NaturezaPessoa.FORNECEDOR.toString())) {
				this.getPessoaFisica().setNaturezaPessoa(NaturezaPessoa.FORNECEDOR);
			} else if (this.getTipoParticipante().equals(NaturezaPessoa.CLIENTE.toString())) {
				this.getPessoaFisica().setNaturezaPessoa(NaturezaPessoa.CLIENTE);
			} else if (this.getTipoParticipante().equals(NaturezaPessoa.TRANSPORTADORA.toString())) {
				this.getPessoaFisica().setNaturezaPessoa(NaturezaPessoa.TRANSPORTADORA);
			} else {
				this.getPessoaFisica().setNaturezaPessoa(NaturezaPessoa.CONTADOR);
			}
			Integer retorno = this.getParticipanteRN().validaCampoNuloPF(this.getPessoaFisica());
			if (retorno == 0) {
				this.getParticipanteRN().salvarPF(this.getPessoaFisica());
				this.info("Registro salvo com sucesso");
				this.setNovo(false);
				this.setEnderecos(false);
				this.setSalReg(false);
				this.setEmail(false);
				this.setTelefone(false);
			} else {
				this.error("Existem campos não preenchidos");
			}
		} catch (Exception e) {
			this.error("Problemas ao salvar" + e.getMessage());
		}
	}

	public void salvarLogr(Municipio municipio) {
		this.getLogradouro().setIdEndereco(null);
		if (this.getTipoLogrSelecionado().equals(TipoLogradouro.COBRANCA.toString())) {
			this.getLogradouro().setTipoLogr(TipoLogradouro.COBRANCA);
		} else if (this.getTipoLogrSelecionado().equals(TipoLogradouro.ENTREGA.toString())) {
			this.getLogradouro().setTipoLogr(TipoLogradouro.ENTREGA);
		} else if (this.getTipoLogrSelecionado().equals(TipoLogradouro.COMERCIAL.toString())) {
			this.getLogradouro().setTipoLogr(TipoLogradouro.COMERCIAL);
		} else {
			this.getLogradouro().setTipoLogr(TipoLogradouro.RESIDENCIAL);
		}
		try {
			try {
				if (this.getPessoaFisica().getIdPessoa() == null) {
					this.getLogradouro().setPessoa(this.getPessoaJuridica());
				} else {
					this.getLogradouro().setPessoa(this.getPessoaFisica());
				}
			} catch (NullPointerException e) {
				this.getLogradouro().setPessoa(this.getPessoaJuridica());
			}
			this.getLogradouro().setMunicipio(municipio);
			this.getLogrRN().salvar(this.getLogradouro());
			this.info("Logradouro salvo com sucesso");
			listaLogradouro();
			this.setLogradouro(null);
		} catch (Exception e) {
			this.error("Problemas na gravacao do endereço"+ e.getMessage());
		}
	}

	public void listaLogradouro() {
		this.getListaEnd().clear();
		try {
			try {
				if (this.getPessoaFisica().getIdPessoa() == 0) {
					this.setListaEnd(this.getParticipanteRN().listaLogr(this.getPessoaJuridica()));
				} else {
					this.setListaEnd(this.getParticipanteRN().listaLogr(this.getPessoaFisica()));
				}
			} catch (NullPointerException e) {
				if(this.getPessoaJuridica().getIdPessoa() != 0 && this.getPessoaJuridica().getIdPessoa() != null){
					this.setListaEnd(this.getParticipanteRN().listaLogr(this.getPessoaJuridica()));
				}else{
					this.setListaEnd(this.getParticipanteRN().listaLogr(this.getPessoaFisica()));	
				}
			}
		} catch (Exception e) {
			this.error("Problemas na listagem dos logradouros"+ e.getMessage());
		}
	}

	public void novo() {
		this.setPessoaJuridica(null);
		this.setPessoaFisica(null);
		this.setListaEnd(null);
		this.setListaEmail(null);
		this.setListaTelefone(null);
		this.setSalvar(false);
		this.setCancelar(false);
		this.setNovo(true);
		this.setSalReg(true);
		this.setEnderecos(true);
		this.setEmail(true);
		this.setTelefone(true);
		habilitar();
	}

	public void pessoaJuridicaSelecionado(SelectEvent event){
		PessoaJuridica pj;
		try {
			pj = (PessoaJuridica) event.getObject();
			this.setPessoaJuridica(this.getParticipanteRN().carregaIDPJ(pj.getIdPessoa()));
			this.setTipoParticipante(this.getPessoaJuridica().getNaturezaPessoa().toString());
			habilitar();
		} catch (Exception e) {
			this.error("Problemas na edição"+ e.getMessage());
		}
		listaLogradouro();
		listaEmail();
		listaTelefone();
		this.setSalvar(false);
		this.setCancelar(false);
		this.setSalReg(false);
		this.setEnderecos(false);
		this.setEmail(false);
		this.setTelefone(false);
	}

	public void pessoaFisicaSelecionado(SelectEvent event){
		PessoaFisica pf;
		try {
			pf = (PessoaFisica) event.getObject();
			this.setPessoaFisica(this.getParticipanteRN().carregaIDPF(pf.getIdPessoa()));
			this.setTipoParticipante(this.getPessoaFisica().getNaturezaPessoa().toString());
			habilitar();
		} catch (Exception e) {
			this.error("Problemas na edição"+ e.getMessage());
		}
		listaLogradouro();
		listaEmail();
		listaTelefone();
		this.setSalvar(false);
		this.setCancelar(false);
		this.setSalReg(false);
		this.setEnderecos(false);
		this.setEmail(false);
		this.setTelefone(false);
	}

	public void excluirLogr() {
		try {
			this.getLogrRN().excluirLogr(idLogr);
			this.info("Logradouro excluido com sucesso");
			listaLogradouro();
		} catch (Exception e) {
			this.error("Problemas na exclusão do logradouro"+ e.getMessage());
		}
	}

	public void listaEmail() {
		try {
			this.getListaEmail().clear();
			if (this.getPessoaFisica().getIdPessoa() == null) {
				this.setListaEmail(this.getEmailRN().listaEmail(this.getPessoaJuridica()));
			} else {
				this.setListaEmail(this.getEmailRN().listaEmail(this.getPessoaFisica()));
			}
		} catch (Exception e) {
			this.error("Problemas na listagem dos emails"+ e.getMessage());
		}
	}

	public void excluirEmail() {
		try {
			this.getEmailRN().excluir(idEmail);
			this.info("Email excluido com sucesso");
			listaEmail();
		} catch (Exception e) {
			this.error("Problemas na exclusão do email"+ e.getMessage());
		}
	}

	public void salvarEmail() {
		Integer pNfe = 0, checkNFe = 0;
		Integer retorno = this.getEmailRN().validaCampoNulo(this.getEmails());
		if (retorno == 0) {
			try {
				try {
					if (this.getPessoaFisica().getIdPessoa() == 0) {
						checkNFe = this.getEmailRN().validaEmailNFE(this.getPessoaJuridica());
					} else {
						checkNFe = this.getEmailRN().validaEmailNFE(this.getPessoaFisica());
					}
				} catch (NullPointerException e) {
					checkNFe = this.getEmailRN().validaEmailNFE(this.getPessoaJuridica());
				}
			} catch (Exception e) {
				this.error("Problemas na validação do email"+ e.getMessage());
			}
			if (this.isPadraoNFE() && checkNFe == 1) {
				this.error("Ja existe um email como padrão NFE");
			} else {
				try {
					if (this.getPessoaFisica().getIdPessoa() == 0) {
						this.getEmails().setPessoa(this.getPessoaJuridica());
					} else {
						this.getEmails().setPessoa(this.getPessoaFisica());
					}
				} catch (NullPointerException e) {
					this.getEmails().setPessoa(this.getPessoaJuridica());
				}
				if (this.isPadraoNFE()) {
					pNfe = 1;
					this.getEmails().setPadraoNFe(pNfe);
				} else {
					this.getEmails().setPadraoNFe(pNfe);
				}
				try {
					this.getEmailRN().salvar(this.getEmails());
					this.info("Email salvo com sucesso");
					this.setEmails(null);
					listaEmail();
				} catch (Exception e) {
					this.error("Problemas na inclusão do email"+ e.getMessage());
				}
			}
		} else {
			this.error("Existem campos nulos no formulário");
		}
	}

	public void excluirTelefone() {
		try {
			this.getTelefoneRN().excluir(idTel);
			this.info("Telefone excluido com sucesso");
			listaTelefone();
		} catch (Exception e) {
			this.error("Problemas na exclusao do telefone"+ e.getMessage());
		}
	}

	public void listaTelefone() {
		try {
			this.getListaTelefone().clear();
			try {
				if (this.getPessoaFisica().getIdPessoa() == 0) {
					this.setListaTelefone(this.getTelefoneRN().listaTelefone(this.getPessoaJuridica()));
				} else {
					this.setListaTelefone(this.getTelefoneRN().listaTelefone(this.getPessoaFisica()));
				}
			} catch (NullPointerException e) {
				this.setListaTelefone(this.getTelefoneRN().listaTelefone(this.getPessoaJuridica()));
			}
		} catch (Exception e) {
			this.error("Problemas em listar os telefones"+ e.getMessage());
		}
	}

	public void salvarTelefone() {
		if (this.getTipoSelecionadoTel().equals(TipoTelefone.CELULAR.toString())) {
			this.getTel().setTipoFone(TipoTelefone.CELULAR);
		} else if (this.getTipoSelecionadoTel().equals(TipoTelefone.COMERCIAL.toString())) {
			this.getTel().setTipoFone(TipoTelefone.COMERCIAL);
		} else if (this.getTipoSelecionadoTel().equals(TipoTelefone.RESIDENCIAL.toString())) {
			this.getTel().setTipoFone(TipoTelefone.RESIDENCIAL);
		}
		try {
			try {
				if (this.getPessoaFisica().getIdPessoa() == 0) {
					this.getTel().setPessoa(this.getPessoaJuridica());
				} else {
					this.getTel().setPessoa(this.getPessoaFisica());
				}
			} catch (NullPointerException e) {
				this.getTel().setPessoa(this.getPessoaJuridica());
			}
			Integer retorno = this.getTelefoneRN().validaCampoNulo(this.getTel(), this.getDddTel());
			if (retorno == 0) {
				this.getTel().setNumero(this.getDddTel() + this.getTel().getNumero());
				this.getTelefoneRN().salvar(this.getTel());
				this.info("Telefone salvo com sucesso");
				this.setDddTel(null);
				listaTelefone();
				this.setTel(null);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas em salvar o telefone"+ e.getMessage());
		}
	}

	public void habilitar() {
		this.setTipoParPerFis(false);
		this.setInaParPerFis(false);
		this.setNomeParPesFis(false);
		this.setCpfParPesFis(false);
		this.setRgParPesFis(false);
		// ***********************
		this.setTipoParPerJur(false);
		this.setInaParPerJur(false);
		this.setNomeParPesJur(false);
		this.setRazParPesJur(false);
		this.setCnpjParPesJur(false);
		this.setInscParPesJur(false);
		this.setCnaeParPesJur(false);
	}

	public void desabilitar() {
		this.setTipoParPerFis(true);
		this.setInaParPerFis(true);
		this.setNomeParPesFis(true);
		this.setCpfParPesFis(true);
		this.setRgParPesFis(true);
		// ***********************
		this.setTipoParPerJur(true);
		this.setInaParPerJur(true);
		this.setNomeParPesJur(true);
		this.setRazParPesJur(true);
		this.setCnpjParPesJur(true);
		this.setInscParPesJur(true);
		this.setCnaeParPesJur(true);
	}

	public String getDddTel() {
		if(this.dddTel == null){
			this.dddTel = new String();
		}
		return dddTel;
	}

	public void setDddTel(String dddTel) {
		this.dddTel = dddTel;
	}

	public ParticipanteRN getParticipanteRN() {
		if(this.participanteRN == null){
			this.participanteRN = new ParticipanteRN();
		}
		return participanteRN;
	}

	public void setParticipanteRN(ParticipanteRN participanteRN) {
		this.participanteRN = participanteRN;
	}

	public LogradouroRN getLogrRN() {
		if(this.logrRN == null){
			this.logrRN = new LogradouroRN();
		}
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
		if(this.tipoPJ == null){
			this.tipoPJ = new String();
		}
		return tipoPJ;
	}

	public void setTipoPJ(String tipoPJ) {
		this.tipoPJ = tipoPJ;
	}

	public String getSelecionadaPessoa() {
		if(this.selecionadaPessoa == null){
			this.selecionadaPessoa = new String();
		}
		return selecionadaPessoa;
	}

	public void setSelecionadaPessoa(String selecionadaPessoa) {
		this.selecionadaPessoa = selecionadaPessoa;
	}

	public List<Logradouro> getListaEnd() {
		if(this.listaEnd == null){
			this.listaEnd  = new ArrayList<Logradouro>();
		}
		return listaEnd;
	}

	public void setListaEnd(List<Logradouro> listaEnd) {
		this.listaEnd = listaEnd;
	}

	public Logradouro getLogradouro() {
		if(this.logradouro == null){
			this.logradouro  = new Logradouro();
		}
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoLogrSelecionado() {
		if(this.tipoLogrSelecionado == null){
			this.tipoLogrSelecionado = new String();
		}
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
		if(this.listaEmail == null){
			this.listaEmail  = new ArrayList<Email>();
		}
		return listaEmail;
	}

	public void setListaEmail(List<Email> listaEmail) {
		this.listaEmail = listaEmail;
	}

	public List<Telefone> getListaTelefone() {
		if(this.listaTelefone == null){
			this.listaTelefone  = new ArrayList<Telefone>();
		}
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public PessoaFisica getPessoaFisica() {
		if(this.pessoaFisica == null){
			this.pessoaFisica  = new PessoaFisica();
		}
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		if(this.pessoaJuridica == null){
			this.pessoaJuridica = new PessoaJuridica();
		}
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
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
		if(this.tipoParticipante == null){
			this.tipoParticipante = new String();
		}
		return tipoParticipante;
	}

	public void setTipoParticipante(String tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public List<PessoaFisica> getListaPessoaFisica() {
		if(this.listaPessoaFisica == null){
			this.listaPessoaFisica  = new ArrayList<PessoaFisica>();
		}
		return listaPessoaFisica;
	}

	public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
		this.listaPessoaFisica = listaPessoaFisica;
	}

	public String getTipoSelecionadoTel() {
		if(this.tipoSelecionadoTel == null){
			this.tipoSelecionadoTel = new String();
		}
		return tipoSelecionadoTel;
	}

	public void setTipoSelecionadoTel(String tipoSelecionadoTel) {
		this.tipoSelecionadoTel = tipoSelecionadoTel;
	}

	public Telefone getTel() {
		if(this.tel == null){
			this.tel  = new Telefone();
		}
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}

	public Email getEmails() {
		if(this.emails == null){
			this.emails  = new Email();
		}
		return emails;
	}

	public void setEmails(Email emails) {
		this.emails = emails;
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

	public EmailRN getEmailRN() {
		if(this.emailRN == null){
			this.emailRN = new EmailRN();
		}
		return emailRN;
	}

	public void setEmailRN(EmailRN emailRN) {
		this.emailRN = emailRN;
	}

	public TelefoneRN getTelefoneRN() {
		if(this.telefoneRN == null){
			this.telefoneRN = new TelefoneRN();
		}
		return telefoneRN;
	}

	public void setTelefoneRN(TelefoneRN telefoneRN) {
		this.telefoneRN = telefoneRN;
	}
}
