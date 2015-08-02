package br.com.softwareOptimus.fiscal.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.fiscal.RN.PautaRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "pautaBean")
@ViewScoped
public class PautaBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = -7205875322346314575L;
	private Pauta pauta;
	private PautaMVA pautaMVA;
	private PautaRN pautaRN;
	private Boolean sal = true, alt = true, rem = true, vig = true,
			desc = true;
	private String busca, filtro;
	private List<PautaMVA> listaPautaMVA;
	private List<Pauta> listaPauta;
	private Long id, idPautaMVA;

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		habilita();
		limpar();
	}

	public void alterar() {
		try {
			Integer retorno = this.getPautaRN().validaCampoNulo(this.getPauta());
			if (retorno == 0) {
				this.getPautaRN().altPauta(this.getPauta());
				this.info("Pauta alterada com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração da Pauta " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getPautaRN().verificaRemocao(this.getPauta());
			if (retorno == 0) {
				this.getPautaRN().remover(this.getPauta());
				this.info("Pauta removida com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem grades vinculadas a esta pauta.");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção da Pauta " + e.getMessage());
		}
	}

	public void cancelar() {
		this.setSal(true);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		limpar();
		desabilita();
	}

	public void salvar() {
		try {
			this.getPauta().setIdPauta(null);
			Integer retorno = this.getPautaRN().validaCampoNulo(this.getPauta());
			if (retorno == 0) {
				this.getPautaRN().salvar(this.getPauta());
				this.info("Pauta salva com sucesso");
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
				this.setVig(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Pauta " + e.getMessage());
		}
	}

	public void incluirPautaMVA() {
		try {
			this.getPautaMVA().setIdPautaMVA(null);
			this.getPautaMVA().setPauta(this.getPauta());
			Integer retorno = this.getPautaRN().validaCampoNuloVig(this.getPautaMVA());
			if (retorno == 0) {
				this.getPautaRN().salvaVig(this.getPautaMVA());
				listaVigencia();
				this.info("Vigência salva com sucesso");
				this.setPautaMVA(null);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao da Vigência " + e.getMessage());
		}
	}

	public void listaVigencia() {
		try {
			this.getListaPautaMVA().clear();
			this.setListaPautaMVA(this.getPautaRN().listar(this.getPauta()));
		} catch (Exception e) {
			this.error("Problemas ao listar as Vigências " + e.getMessage());
		}
	}

	public void limpar() {
		this.setListaPautaMVA(null);
		this.setListaPauta(null);
		this.setPautaMVA(null);
		this.setPauta(new Pauta());
		this.setId(null);
		this.setIdPautaMVA(null);		
	}

	public void buscaPauta() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaPauta(this.getPautaRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaPauta(this.getPautaRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaPauta(this.getPautaRN().listar());
		}
	}

	public void editPauta() {
		this.setPauta(this.getPautaRN().editPauta(this.getId()));
		habilita();
		listaVigencia();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVig(false);
	}

	public void excluirPautaMVA() {
		try {
			this.getPautaRN().removerVig(this.getIdPautaMVA());
			listaVigencia();
			this.info("Vigência da Pauta removida com sucesso");
		} catch (Exception e) {
			this.error("Problemas na remoção da vigência da Pauta " + e.getMessage());
		}
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
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
		if(this.listaPauta == null){
			this.listaPauta = new ArrayList<Pauta>();
		}
		return listaPauta;
	}

	public void setListaPauta(List<Pauta> listaPauta) {
		this.listaPauta = listaPauta;
	}

	public List<PautaMVA> getListaPautaMVA() {
		if(this.listaPautaMVA == null){
			this.listaPautaMVA = new ArrayList<PautaMVA>();
		}
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
		if(this.pautaMVA == null){
			this.pautaMVA = new PautaMVA();
		}
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
		if(this.listaPautaMVA == null){
			this.listaPautaMVA = new ArrayList<PautaMVA>();
		}
		return listaPautaMVA;
	}

	public void setPautaList(List<PautaMVA> pautaList) {
		this.listaPautaMVA = pautaList;
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

	public String getFiltro() {
		if(this.filtro == null){
			this.filtro = new String();
		}
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBuscaPauta() {
		if(this.busca == null){
			this.busca = new String();
		}
		return busca;
	}

	public void setBuscaPauta(String buscaPauta) {
		this.busca = buscaPauta;
	}

	public Pauta getPauta() {
		if(this.pauta == null){
			this.pauta = new Pauta();
		}
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

	public PautaRN getPautaRN() {
		if(this.pautaRN == null){
			this.pautaRN = new PautaRN();
		}
		return pautaRN;
	}

	public void setPautaRN(PautaRN pautaRN) {
		this.pautaRN = pautaRN;
	}
}
