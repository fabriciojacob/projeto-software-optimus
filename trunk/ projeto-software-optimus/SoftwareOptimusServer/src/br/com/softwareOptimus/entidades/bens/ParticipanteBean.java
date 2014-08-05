package br.com.softwareOptimus.entidades.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.entidades.TipoLogradouro;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.ParticipanteRN;
import br.com.softwareOptimus.entidades.RN.geral.LogradouroRN;

@ManagedBean
public class ParticipanteBean {

	private PessoaFisica pessoaFisica = new PessoaFisica();
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Long id, idLogr, idTel, idEmail;
	private List<Email> listaEmail = new ArrayList<>();
	private List<Logradouro> listaEnd = new ArrayList<>();
	public List<PessoaFisica> listaPessoaFisica = new ArrayList<>();
	private ParticipanteRN participanteRN;
	private LogradouroRN logrRN;
	private Logradouro logradouro = new Logradouro();
	private String tipoLogrSelecionado = null, selecionadaPessoa = null,
			tipoParticipante = null, tipoPJ = null, filtro = null,
			textoConsulta = null;
	private List<Telefone> listaTelefone = new ArrayList<>();
	private boolean salvar = true, cancelar = true, enderecos = true,
			salReg = true, email = true, telefone = true, padraoNFE,
			novo = false, consulta = false;

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
			participanteRN.salvarPF(pessoaFisica);
			msgAcerto("Registro salvo com sucesso");
			this.selecionadaPessoa = "FISICA";
		} catch (Exception e) {
			msgErro("Problemas ao salvar", e);
		}
	}

	public void salvarLogr(Municipio municipio, Pessoa pessoa) {
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
				logradouro.setPessoa(pessoaFisica);
			} else {
				logradouro.setPessoa(pessoaJuridica);
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

			if (selecionadaPessoa.equals("FISICA")) {
				this.listaEnd = participanteRN.listaLogr(pessoaFisica);
			} else {
				this.listaEnd = participanteRN.listaLogr(pessoaJuridica);
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

	}

	public void pesquisaPF() {
		this.participanteRN = new ParticipanteRN();
		String cpf = "cpf";
		try {
			if (filtro.equals(cpf)) {
				if (this.listaPessoaFisica != null) {
					this.listaPessoaFisica.clear();
				}
				this.listaPessoaFisica = this.participanteRN
						.listaPFCPF(textoConsulta);
			} else {
				if (this.pessoaFisica != null) {
					this.listaPessoaFisica.clear();
				}
				this.listaPessoaFisica = this.participanteRN
						.listaPFNome(textoConsulta);
			}
			this.selecionadaPessoa = "FISICA";
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

	public void editar() {
		EmpresaRN empresaRN = new EmpresaRN();
		this.pessoaJuridica = empresaRN.pesquisaId(id);
		// listaLogradouro();
		this.salvar = false;
		this.cancelar = false;
		this.enderecos = false;
		this.salReg = false;
		this.email = false;
		this.telefone = false;
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

}
