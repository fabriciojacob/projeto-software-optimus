package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.PautaMVARN;

@ManagedBean(name = "pautaBean")
@ViewScoped
public class PautaBean {

	private PautaMVA pauta = new PautaMVA();
	private Boolean sal = true, alt = true, rem = true;
	private String busca, filtro;
	private List<PautaMVA> pautaList = new ArrayList<PautaMVA>();
	private Long id;

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		limpar();
	}

	public void alterar() {
		try {
			PautaMVARN pautaRN = new PautaMVARN();
			Integer retorno = pautaRN.validaCampoNulo(this.pauta);
			if (retorno == 0) {
				pautaRN.altPauta(this.pauta);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Pauta alterada com sucesso"));
				this.alt = true;
				this.rem = true;
				limpar();
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
			PautaMVARN pautaRN = new PautaMVARN();
			pautaRN.remover(this.pauta);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Alíquota removida com sucesso"));
			this.alt = true;
			this.rem = true;
			limpar();
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
		limpar();
	}

	public void salvar() {
		try {
			PautaMVARN pautaRN = new PautaMVARN();
			this.pauta.setIdPautaMVA(null);
			Integer retorno = pautaRN.validaCampoNulo(this.pauta);
			if (retorno == 0) {
				pautaRN.salva(this.pauta);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
								"Pauta salva com sucesso"));
				this.sal = true;
				limpar();
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

	public void limpar() {
		this.pautaList = new ArrayList<PautaMVA>();
		this.pauta = new PautaMVA();
		this.id = null;
	}

	public void buscaPauta() {
		limpar();
		PautaMVARN pautaRN = new PautaMVARN();
		if (!busca.equals("")) {
			if (filtro.equals("id")) {
				this.pautaList = pautaRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.pautaList = pautaRN.consultaDesc(busca);
			} else if (filtro.equals("valP")) {
				this.pautaList = pautaRN
						.consultaValP(Double.parseDouble(busca));
			} else if (filtro.equals("valMva")) {
				this.pautaList = pautaRN.consultaValMva(Double
						.parseDouble(busca));
			}
		} else {
			this.pautaList = pautaRN.lista();
		}
	}

	public void editPauta() {
		PautaMVARN pautaRN = new PautaMVARN();
		this.pauta = pautaRN.editPauta(id);
		this.alt = false;
		this.rem = false;
		this.sal = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PautaMVA> getPautaList() {
		return pautaList;
	}

	public void setPautaList(List<PautaMVA> pautaList) {
		this.pautaList = pautaList;
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

	public PautaMVA getPauta() {
		return pauta;
	}

	public void setPauta(PautaMVA pauta) {
		this.pauta = pauta;
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
