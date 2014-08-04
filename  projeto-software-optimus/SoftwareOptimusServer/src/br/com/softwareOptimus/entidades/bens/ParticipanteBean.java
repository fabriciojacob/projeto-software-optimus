package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.entidades.RN.ParticipanteRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;

@ManagedBean
public class ParticipanteBean {
	
	private Pessoa pessoaGeral = new Pessoa();
	private PessoaFisica pessoaFisica = new PessoaFisica();
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Long idPF, idPJ, idLogr, idTel, idEmail;
	private List<Email> listaEmail = new ArrayList<>();
	private List<Logradouro> listaEnd = new ArrayList<>();
	private ParticipanteRN participanteRN;
	private LogradouroRN logrRN;
	private Logradouro logradouro = new Logradouro();
	private String tipoPJ;
	private String tipoLogrSelecionado = null, selecionadaPessoa = null;
	private List<Telefone> listaTelefone = new ArrayList<>();
	private boolean salvar = true, cancelar = true, enderecos = true,
			salReg = true, email = true, telefone = true, padraoNFE,
			novo = false, consulta = false;

	public void salvar(){
		try{
			participanteRN = new ParticipanteRN();
			if(selecionadaPessoa.equals("FISICA")){
				this.pessoaFisica.setIdPessoa(pessoaGeral.getIdPessoa());
				participanteRN.salvarPessoa(pessoaGeral);
				participanteRN.salvarPF(pessoaFisica);
			}else{
				if(tipoPJ.equals(TipoPessoaJuridica.FABRICANTE)){
					this.pessoaJuridica.setTipoPessoaJuridica(TipoPessoaJuridica.FABRICANTE);
				}else if(tipoPJ.equals(TipoPessoaJuridica.DISTRIBUIDOR)){
					this.pessoaJuridica.setTipoPessoaJuridica(TipoPessoaJuridica.DISTRIBUIDOR);
				}else{
					this.pessoaJuridica.setTipoPessoaJuridica(TipoPessoaJuridica.OUTROS);
				}
				participanteRN.salvarPessoa(pessoaGeral);
				participanteRN.salvarPJ(pessoaJuridica);
			}
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Registro salvo com sucesso"));
			
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao"));
		}
	}

	public void salvarLogr(Municipio municipio) {
		logradouro = new Logradouro();
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
			if (selecionadaPessoa.equals("FISICA")) {
				this.listaEnd = participanteRN.listaLogrPJ(pessoaJuridica);
			} else {
				logradouro.setPessoa(pessoaJuridica);
			}

			logradouro.setMunicipio(municipio);
			logrRN.salvar(logradouro);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Endereço salvo com sucesso"));
			listaLogradouro();
			this.logradouro = new Logradouro();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao do endereço "
									+ e.getMessage()));
		}
	}

	public void listaLogradouro() {
		this.participanteRN = new ParticipanteRN();
		if (this.listaEnd != null) {
			this.listaEnd.clear();
		}
		try {

			if (selecionadaPessoa.equals("FISICA")) {
				this.listaEnd = participanteRN.listaLogrPJ(pessoaJuridica);
			} else {
				this.listaEnd = participanteRN.listaLogrPF(pessoaFisica);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na listagem dos logradouros"
									+ e.getMessage()));
		}
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

	public Long getIdPF() {
		return idPF;
	}

	public void setIdPF(Long idPF) {
		this.idPF = idPF;
	}

	public Long getIdPJ() {
		return idPJ;
	}

	public void setIdPJ(Long idPJ) {
		this.idPJ = idPJ;
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

	public Pessoa getPessoaGeral() {
		return pessoaGeral;
	}

	public void setPessoaGeral(Pessoa pessoaGeral) {
		this.pessoaGeral = pessoaGeral;
	}
	
	

}
