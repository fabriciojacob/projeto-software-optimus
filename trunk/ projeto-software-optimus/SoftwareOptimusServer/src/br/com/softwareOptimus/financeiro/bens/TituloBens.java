package br.com.softwareOptimus.financeiro.bens;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.CondPgto;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.FormaPgto;
import br.com.softwareOptimus.financeiro.Rubrica;
import br.com.softwareOptimus.financeiro.StatusConta;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.financeiro.RN.ContaBancariaRN;
import br.com.softwareOptimus.financeiro.RN.ExtratoContaRN;
import br.com.softwareOptimus.financeiro.RN.TituloRN;

@ManagedBean
@ViewScoped
public class TituloBens {

	private Titulo titulo = new Titulo();
	private String nomePesquisa, statusBaixa, tipoData, tipoTitulo,
			tipoTitulo2;
	private Long empresaSelecionada, participanteSelecionado,
			tituloSelecionado;
	private List<Pessoa> participantes = new ArrayList<>();
	private List<Titulo> titulos = new ArrayList<>();
	private List<ContaBancaria> listaContas = new ArrayList<>();
	private ContaBancaria contaBancaria = new ContaBancaria();
	private TituloRN regraNegocio;
	private Pessoa pessoa;
	private Pessoa empresa;
	private boolean btAdicionar = true;
	private int verifica = 0;
	private Date dataIni, dataFim;
	private String tipoBaixa;
	private boolean checktitulo = true;

	public void pesquisaTitulo() {
		Integer tipoTi;
		regraNegocio = new TituloRN();
		Integer status = 0;
		if (statusBaixa.equals(StatusConta.BAIXADA.toString())) {
			status = 0;
		} else if (statusBaixa.equals(StatusConta.PENDENTE.toString())) {
			status = 1;
		} else {
			status = 2;
		}
		try {
			if (tipoData.equals("PAGAMENTO")) {
				if (tipoTitulo2.equals(TipoTitulo.PAGAR.toString())) {
					tipoTi = 0;
					titulos = regraNegocio.pesquisaPagamento(dataIni, dataFim,
							empresa, pessoa, tipoTi, status);
				} else {
					tipoTi = 1;
					titulos = regraNegocio.pesquisaPagamento(dataIni, dataFim,
							empresa, pessoa, tipoTi, status);
				}
			} else if (tipoData.equals("VENCIMENTO")) {
				if (tipoTitulo2.equals(TipoTitulo.PAGAR.toString())) {
					titulos = regraNegocio.pesquisaVencimento(dataIni, dataFim,
							empresa, pessoa, 0, status);
				} else {
					titulos = regraNegocio.pesquisaVencimento(dataIni, dataFim,
							empresa, pessoa, 1, status);
				}
			} else {
				if (tipoTitulo2.equals(TipoTitulo.PAGAR.toString())) {
					tipoTi = 0;
					titulos = regraNegocio.pesquisaLancamento(dataIni, dataFim,
							empresa, pessoa, 0, status);
				} else {
					tipoTi = 1;
					titulos = regraNegocio.pesquisaLancamento(dataIni, dataFim,
							empresa, pessoa, tipoTi, status);
				}
			}
		} catch (Exception e) {
			msgErro("Problemas na pesquisa do titulo", e);
		}
	}

	public void pesquisaParticipante() {
		this.regraNegocio = new TituloRN();
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

	public void listaContaBancaria() {
		ContaBancariaRN contaRN = new ContaBancariaRN();
		try {
			listaContas = contaRN.listaGeral();
		} catch (Exception e) {
			msgErro("Problemas la lista das contas", e);
		}
	}

	public void selecionaEmpresa() {
		this.regraNegocio = new TituloRN();
		try {
			this.empresa = this.regraNegocio.participante(empresaSelecionada);
			this.titulo.setEmpresa(empresa);
			msgAcerto("Empresa selecionada");
			verifica = verifica + 1;
			if (verifica >= 2) {
				btAdicionar = false;
			}
		} catch (Exception e) {
			msgErro("Problemas na seleção da empresa ", e);
		}

	}

	public void baixa() {
		ExtratoContaRN extratoBanco;
		setChecktitulo(true);
		if (tipoBaixa.toString() == "BANCO") {
			extratoBanco = new ExtratoContaRN();
		} else {

		}

	}

	public void salvarTitulo(CondPgto condPgto, FormaPgto formaPgto) {
		this.regraNegocio = new TituloRN();
		titulo.setCondPgto(condPgto);
		titulo.setFormaPgto(formaPgto);
		if (tipoTitulo.equals(TipoTitulo.PAGAR.toString())) {
			titulo.setTipoTitulo(TipoTitulo.PAGAR);
		} else {
			titulo.setTipoTitulo(TipoTitulo.RECEBER);
		}
		titulo.setRubrica(Rubrica.MANUAL);
		titulo.setStatus(StatusConta.PENDENTE);
		try {
			this.regraNegocio.salvar(titulo);
			msgAcerto("Registro salvo com sucesso ");
			this.titulo = new Titulo();
			btAdicionar = true;
			verifica = 0;
		} catch (Exception e) {
			msgErro("Problemas ao salvar o titulo ", e);
		}
	}

	public void editarTitulo() {
		this.regraNegocio = new TituloRN();
		try {
			this.regraNegocio.editar(titulo);
			msgAcerto("Registro editado com sucesso ");
		} catch (Exception e) {
			msgErro("Problemas na edição do titulo ", e);
		}
	}

	public void selecionaParticipante() {
		this.regraNegocio = new TituloRN();
		try {
			this.pessoa = this.regraNegocio
					.participante(participanteSelecionado);
			this.titulo.setPessoa(this.pessoa);
			verifica = verifica + 1;
			if (verifica >= 2) {
				btAdicionar = false;
			}
		} catch (Exception e) {
			msgErro("Problemas na seleção do participante ", e);
		}
	}

	public void selecionaTitulo() {
		this.titulo = new Titulo();
		try {
			this.titulo = regraNegocio.retornaTitulo(tituloSelecionado);
			msgAcerto("Titulo selecionado");
			setChecktitulo(false);
			listaContaBancaria();
		} catch (Exception e) {
			msgErro("Problemas na pesquisa do titulo", e);
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

	public boolean isBtAdicionar() {
		return btAdicionar;
	}

	public void setBtAdicionar(boolean btAdicionar) {
		this.btAdicionar = btAdicionar;
	}

	public int getVerifica() {
		return verifica;
	}

	public void setVerifica(int verifica) {
		this.verifica = verifica;
	}

	public String getStatusBaixa() {
		return statusBaixa;
	}

	public void setStatusBaixa(String statusBaixa) {
		this.statusBaixa = statusBaixa;
	}

	public String getTipoData() {
		return tipoData;
	}

	public void setTipoData(String tipoData) {
		this.tipoData = tipoData;
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

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public String getTipoTitulo() {
		return tipoTitulo;
	}

	public void setTipoTitulo(String tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
	}

	public Long getTituloSelecionado() {
		return tituloSelecionado;
	}

	public void setTituloSelecionado(Long tituloSelecionado) {
		this.tituloSelecionado = tituloSelecionado;
	}

	public String getTipoBaixa() {
		return tipoBaixa;
	}

	public void setTipoBaixa(String tipoBaixa) {
		this.tipoBaixa = tipoBaixa;
	}

	public String getTipoTitulo2() {
		return tipoTitulo2;
	}

	public void setTipoTitulo2(String tipoTitulo2) {
		this.tipoTitulo2 = tipoTitulo2;
	}

	public boolean isChecktitulo() {
		return checktitulo;
	}

	public void setChecktitulo(boolean checktitulo) {
		this.checktitulo = checktitulo;
	}

	public List<ContaBancaria> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<ContaBancaria> listaContas) {
		this.listaContas = listaContas;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

}
