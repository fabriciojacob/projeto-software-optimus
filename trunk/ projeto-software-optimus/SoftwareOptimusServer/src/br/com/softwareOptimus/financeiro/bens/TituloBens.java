package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.financeiro.RN.TituloRN;

@ManagedBean
@ViewScoped
public class TituloBens {

	private Titulo titulo;
	private String nomePesquisa;
	private Long empresaSelecionada, participanteSelecionado;
	private boolean btSalvarTitulo = true, btNovoTitulo = false;
	private List<Pessoa> participantes = new ArrayList<>();
	private TituloRN regraNegocio = new TituloRN();
	private Pessoa pessoa;
	private Pessoa empresa;

	public void novo() {
		this.titulo = new Titulo();
		this.btSalvarTitulo = false;
	}

	public void pesquisaParticipante() {
		if (this.participantes != null) {
			this.participantes.clear();
		}
		try {
			this.participantes = this.regraNegocio
					.listaParticipante(this.nomePesquisa);
		} catch (Exception e) {
			msgErro("Problemas na pesquisa ", e);
		}
	}

	public void selecionaEmpresa() {
		this.regraNegocio = new TituloRN();
		try {
			this.empresa = this.regraNegocio.participante(empresaSelecionada);
			this.titulo.setEmpresa(empresa);
		} catch (Exception e) {
			msgErro("Problemas na seleção da empresa ", e);
		}

	}

	public void salvarTitulo() {
		this.regraNegocio = new TituloRN();
		try {
			this.regraNegocio.salvar(titulo);
			msgAcerto("Registro salvo com sucesso ");
		} catch (Exception e) {
			msgErro("Problemas ao salvar o titulo ", e);
		}
	}

	public void selecionaParticipante() {
		this.regraNegocio = new TituloRN();
		try {
			this.pessoa = this.regraNegocio
					.participante(participanteSelecionado);
			this.titulo.setPessoa(this.pessoa);
		} catch (Exception e) {
			msgErro("Problemas na seleção do participante ", e);
		}
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Pessoa> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Pessoa> participante) {
		this.participantes = participante;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public Long getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Long empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public Long getParticipanteSelecionado() {
		return participanteSelecionado;
	}

	public void setParticipanteSelecionado(Long participanteSelecionado) {
		this.participanteSelecionado = participanteSelecionado;
	}

	public TituloRN getRegraNegocio() {
		return regraNegocio;
	}

	public void setRegraNegocio(TituloRN regraNegocio) {
		this.regraNegocio = regraNegocio;
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

	public boolean isBtSalvarTitulo() {
		return btSalvarTitulo;
	}

	public void setBtSalvarTitulo(boolean btSalvarTitulo) {
		this.btSalvarTitulo = btSalvarTitulo;
	}

	public boolean isBtNovoTitulo() {
		return btNovoTitulo;
	}

	public void setBtNovoTitulo(boolean btNovoTitulo) {
		this.btNovoTitulo = btNovoTitulo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

}
