package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.PautaRN;

@ManagedBean(name = "pautaBean")
@ViewScoped
public class PautaBean {

	private Pauta pauta = new Pauta();
	private PautaMVA pautaMVA = new PautaMVA();
	private Boolean sal = true, alt = true, rem = true, vig = true,
			desc = true;
	private String busca, filtro;
	private List<PautaMVA> listaPautaMVA = new ArrayList<PautaMVA>();
	private List<Pauta> listaPauta = new ArrayList<Pauta>();
	private Long id, idPautaMVA;

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		habilita();
		limpar();
	}

	public void alterar() {
		try {
			PautaRN pautaRN = new PautaRN();
			Integer retorno = pautaRN.validaCampoNulo(this.pauta);
			if (retorno == 0) {
				pautaRN.altPauta(this.pauta);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Pauta alterada com sucesso"));
				this.alt = true;
				this.rem = true;
				this.vig = true;
				limpar();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na alteração da Pauta "
											+ e.getMessage()));
		}
	}

	public void remover() {
		try {
			PautaRN pautaRN = new PautaRN();
			Integer retorno = pautaRN.verificaRemocao(this.pauta);
			if (retorno == 0) {
				pautaRN.remover(this.pauta);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Pauta removida com sucesso"));
				this.alt = true;
				this.rem = true;
				this.vig = true;
				limpar();
				desabilita();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Remoção não permitida! Existem grades vinculadas a esta pauta."));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção da Pauta " + e.getMessage()));
		}
	}

	public void cancelar() {
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		limpar();
		desabilita();
	}

	public void salvar() {
		try {
			PautaRN pautaRN = new PautaRN();
			this.pauta.setIdPauta(null);
			Integer retorno = pautaRN.validaCampoNulo(this.pauta);
			if (retorno == 0) {
				pautaRN.salvar(this.pauta);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Pauta salva com sucesso"));
				this.vig = false;
				this.sal = true;
				this.alt = true;
				this.rem = true;
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Info", "Problemas na gravacao da Pauta "
											+ e.getMessage()));
		}
	}

	public void incluirPautaMVA() {
		try {
			PautaRN pautaRN = new PautaRN();
			this.pautaMVA.setIdPautaMVA(null);
			this.pautaMVA.setPauta(this.pauta);
			Integer retorno = pautaRN.validaCampoNuloVig(this.pautaMVA);
			if (retorno == 0) {
				pautaRN.salvaVig(this.pautaMVA);
				listaVigencia();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Vigência salva com sucesso"));
				this.pautaMVA = new PautaMVA();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
								"Existem campos nulos no formulário"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravacao da Vigência "
									+ e.getMessage()));
		}
	}

	public void listaVigencia() {
		try {
			PautaRN pautaRN = new PautaRN();
			if (this.listaPautaMVA != null) {
				this.listaPautaMVA.clear();
			}
			this.listaPautaMVA = pautaRN.listar(this.pauta);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas ao listar as Vigências "
									+ e.getMessage()));
		}

	}

	public void limpar() {
		this.listaPautaMVA = new ArrayList<PautaMVA>();
		this.listaPauta = new ArrayList<Pauta>();
		this.pautaMVA = new PautaMVA();
		this.pauta = new Pauta();
		this.id = null;
		this.idPautaMVA = null;
	}

	public void buscaPauta() {
		limpar();
		PautaRN pautaRN = new PautaRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaPauta = pautaRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaPauta = pautaRN.consultaDesc(busca);
			}
		} else {
			this.listaPauta = pautaRN.listar();
		}
	}

	public void editPauta() {
		PautaRN pautaRN = new PautaRN();
		this.pauta = pautaRN.editPauta(id);
		habilita();
		listaVigencia();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void excluirPautaMVA() {
		try {
			PautaRN pautaRN = new PautaRN();
			pautaRN.removerVig(this.idPautaMVA);
			listaVigencia();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Vigência da Pauta removida com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na remoção da vigência da Pauta "
									+ e.getMessage()));
		}
	}

	public void habilita() {
		this.desc = false;
	}

	public void desabilita() {
		this.desc = true;
	}

	public Boolean getDesc() {
		return desc;
	}

	public void setDesc(Boolean desc) {
		this.desc = desc;
	}

	public Boolean getVig() {
		return vig;
	}

	public void setVig(Boolean vig) {
		this.vig = vig;
	}

	public List<Pauta> getListaPauta() {
		return listaPauta;
	}

	public void setListaPauta(List<Pauta> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public List<PautaMVA> getListaPautaMVA() {
		return listaPautaMVA;
	}

	public void setListaPautaMVA(List<PautaMVA> listaPautaMVA) {
		this.listaPautaMVA = listaPautaMVA;
	}

	public Long getIdPautaMVA() {
		return idPautaMVA;
	}

	public void setIdPautaMVA(Long idPautaMVA) {
		this.idPautaMVA = idPautaMVA;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public PautaMVA getPautaMVA() {
		return pautaMVA;
	}

	public void setPautaMVA(PautaMVA pautaMVA) {
		this.pautaMVA = pautaMVA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PautaMVA> getPautaList() {
		return listaPautaMVA;
	}

	public void setPautaList(List<PautaMVA> pautaList) {
		this.listaPautaMVA = pautaList;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBuscaPauta() {
		return busca;
	}

	public void setBuscaPauta(String buscaPauta) {
		this.busca = buscaPauta;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(PautaMVA pauta) {
		this.pautaMVA = pauta;
	}

	public Boolean getSal() {
		return sal;
	}

	public void setSal(Boolean sal) {
		this.sal = sal;
	}

	public Boolean getAlt() {
		return alt;
	}

	public void setAlt(Boolean alt) {
		this.alt = alt;
	}

	public Boolean getRem() {
		return rem;
	}

	public void setRem(Boolean rem) {
		this.rem = rem;
	}
}
