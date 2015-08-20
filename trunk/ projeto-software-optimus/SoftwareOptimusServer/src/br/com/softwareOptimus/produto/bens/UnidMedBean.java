package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.produto.RN.UnidMedRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "unidMedBean")
@ViewScoped
public class UnidMedBean extends FacesUtil implements Serializable {

	private static final long serialVersionUID = -3988883087479983925L;
	private UnidMed unidMed;
	private boolean disable = false;
	private List<UnidMed> unidMedLis;
	private UnidMedRN unidRN;
	private String busca;
	private String filtro;
	private boolean alt = true;
	private boolean sal = true;
	private boolean rem = true;
	private boolean unidAbre = true;
	private boolean desc = true;

	public void salvarUnid() {
		try {
			this.getUnidMed().setIdUnidMed(null);
			Integer retorno = this.getUnidRN().validaCampoNulo(this.getUnidMed());
			if (retorno == 0) {
				this.getUnidRN().salvar(getUnidMed());
				this.info("Unidade salva com sucesso");
				this.setSal(true);
				limpa();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Unidade " + e.getMessage());
		}
	}

	public void buscaUnid() {
		limpa();
		if (!this.getBusca().equals("") && !this.getFiltro().equals("")) {
			if (this.getFiltro().equals("id")) {
				this.setUnidMedLis(this.getUnidRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("unid")) {
				this.setUnidMedLis(this.getUnidRN().consultaUnid(this.getBusca()));
			} else if (this.getFiltro().equals("desc")) {
				this.setUnidMedLis(this.getUnidRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setUnidMedLis(this.getUnidRN().lista());
		}
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		limpa();
		desabilita();
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		habilita();
		limpa();
	}

	public void limpa() {
		this.setUnidMed(null);
		this.setUnidMedLis(null);
	}

	public void altUnid() {
		try {
			Integer retorno = this.getUnidRN().validaCampoNulo(this.getUnidMed());
			if (retorno == 0) {
				this.getUnidRN().altUnid(this.getUnidMed());
				this.info("Unidade alterada com sucesso");
				this.setAlt(true);
				this.setRem(true);
				limpa();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração da Unidade " + e.getMessage());
		}
	}

	public void unidMedSelecionado(SelectEvent event) {
		UnidMed unid;
		try {
			unid = (UnidMed) event.getObject();
			this.setUnidMed(unid);			
		} catch (Exception e) {
			this.error("Problemas na edição"+ e.getMessage());
		}
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		habilita();
	}

	public void remUnid() {
		try {
			this.getUnidRN().remove(this.getUnidMed().getIdUnidMed());
			this.info("Unidade removida com sucesso");
			this.setAlt(true);
			this.setRem(true);
			limpa();
			desabilita();
		} catch (Exception e) {
			this.error("Problemas na remoção da Unidade " + e.getMessage());
		}
	}

	public void habilita() {
		this.setUnidAbre(false);
		this.setDesc(false);
	}

	public void desabilita() {
		this.setUnidAbre(true);
		this.setDesc(true);
	}

	public boolean isUnidAbre() {
		return unidAbre;
	}

	public void setUnidAbre(boolean unidAbre) {
		this.unidAbre = unidAbre;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}

	public boolean isAlt() {
		return alt;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean isSal() {
		return sal;
	}

	public void setSal(boolean sal) {
		this.sal = sal;
	}

	public String getFiltro() {
		if(this.filtro == null){
			this.filtro = new String();
		}
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBusca() {
		if(this.busca == null){
			this.busca = new String();
		}
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public UnidMed getUnidMed() {
		if(this.unidMed == null){
			this.unidMed = new UnidMed();
		}
		return unidMed;
	}

	public void setUnidMed(UnidMed unidMed) {
		this.unidMed = unidMed;
	}

	public List<UnidMed> getUnidMedLis() {
		if(this.unidMedLis == null){
			this.unidMedLis = new ArrayList<UnidMed>();
		}
		return unidMedLis;
	}

	public void setUnidMedLis(List<UnidMed> unidMedLis) {
		this.unidMedLis = unidMedLis;
	}

	public UnidMedRN getUnidRN() {
		if(this.unidRN == null){
			this.unidRN = new UnidMedRN();
		}
		return unidRN;
	}

	public void setUnidRN(UnidMedRN unidRN) {
		this.unidRN = unidRN;
	}
}
