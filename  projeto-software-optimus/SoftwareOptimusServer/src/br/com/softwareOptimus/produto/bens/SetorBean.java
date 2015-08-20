package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SetorRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "setorBean")
@ViewScoped
public class SetorBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = -6889204545055216922L;
	private Setor setor;
	private Grupo grupo;
	private List<Setor> listaSetor;
	private List<Grupo> listaGrupo;
	private List<Grupo> listaGrupoExib;
	private GrupoRN gruRN;
	private SetorRN setRN;
	private String busca, filtro;
	private boolean sal = true;
	private boolean alt = true;
	private boolean rem = true;
	private boolean desc = true;
	private boolean vig = true;
	private Long idGrup;

	public SetorBean() {
		this.setListaGrupo(this.getGruRN().listaGrupo());
	}

	public void novo() {
		limpar();
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(false);
		this.setListaGrupo(this.getGruRN().listaGrupo());
		habilita();
	}

	public void salvar() {
		try {
			this.getSetor().setIdSetor(null);
			Integer retorno = this.getSetRN().validaCampoNulo(this.getSetor(), this.getListaGrupoExib());
			if (retorno == 0) {
				this.getSetor().setGrupo(this.getListaGrupoExib());
				this.getSetRN().salvar(this.getSetor());
				this.info("Setor salvo com sucesso");
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
				this.setVig(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao do Setor " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			Integer retorno = this.getSetRN().validaCampoNulo(this.getSetor(), this.getListaGrupoExib());
			if (retorno == 0) {
				this.getSetor().setGrupo(this.getListaGrupoExib());
				this.getSetRN().altSet(this.getSetor());
				this.info("Setor alterado com sucesso");
				this.setSal(true);
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração do Setor " + e.getMessage());
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

	public void limpar() {
		this.setGrupo(null);
		this.setSetor(null);
		this.setListaSetor(null);
		this.setListaGrupoExib(null);;
	}

	public void remover() {
		try {
			Integer retorno = this.getSetRN().verificaRemocao(this.getSetor());
			if (retorno == 0) {
				this.getSetRN().remover(this.getSetor());
				this.info("Setor removido com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Produtos vinculados a este Setor. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção do Setor " + e.getMessage());
		}
	}

	public void remGru() {
		Integer retorno = this.getSetRN().verificaRemocaoRelGrupo(this.getSetor(), this.getIdGrup());
		if (retorno == 0) {
			List<Grupo> listaGruNovo = new ArrayList<Grupo>();
			listaGruNovo.addAll(this.getListaGrupoExib());
			for (Grupo gru : this.getListaGrupoExib()) {
				if (gru.getIdGrupo().equals(this.getIdGrup())) {
					listaGruNovo.remove(gru);
				}
			}
			this.setListaGrupoExib(null);
			this.getListaGrupoExib().addAll(listaGruNovo);
		} else {
			this.error("Remoção não permitida! Existem Produtos vinculados a este Setor e Grupo. ");
		}
	}

	public void setorSelecionado(SelectEvent event) {
		Setor set;
		try {
			set = (Setor) event.getObject();
			this.setSetor(this.getSetRN().editSet(set.getIdSetor()));
		} catch (Exception e) {
			this.error("Problemas na edição"+ e.getMessage());
		}
		this.setListaGrupoExib(null);
		this.getListaGrupoExib().addAll(this.getSetor().getGrupo());
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVig(false);
	}

	public void incluirGrup() {
		if (this.getGrupo() != null) {
			Integer retorno = verificaInclusaoGrupo();
			if (retorno == 0) {
				this.getListaGrupoExib().add(this.getGrupo());
			} else {
				this.error("Grupo já vinculado no Setor!");
			}
		} else {
			this.error("Escolha uma Grupo para incluir.");
		}
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
	}

	private Integer verificaInclusaoGrupo() {
		Integer retorno = 0;
		for (Grupo gru : this.getListaGrupoExib()) {
			if (gru.getIdGrupo().equals(this.getGrupo().getIdGrupo()))
				retorno++;
		}
		return retorno;
	}

	public Setor getSetor() {
		if(this.setor == null){
			this.setor = new Setor();
		}
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Grupo getGrupo() {
		if(this.grupo == null){
			this.grupo = new Grupo();
		}
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Setor> getListaSetor() {
		if(this.listaSetor == null){
			this.listaSetor = new ArrayList<Setor>();
		}
		return listaSetor;
	}

	public void setListaSetor(List<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public List<Grupo> getListaGrupo() {
		if(this.listaGrupo == null){
			this.listaGrupo = new ArrayList<Grupo>();
		}
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
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

	public boolean isSal() {
		return sal;
	}

	public void setSal(boolean sal) {
		this.sal = sal;
	}

	public boolean isAlt() {
		return alt;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
	}

	public List<Grupo> getListaGrupoExib() {
		if(this.listaGrupoExib == null){
			this.listaGrupoExib = new ArrayList<Grupo>();
		}
		return listaGrupoExib;
	}

	public void setListaGrupoExib(List<Grupo> listaGrupoExib) {
		this.listaGrupoExib = listaGrupoExib;
	}

	public Long getIdGrup() {
		return idGrup;
	}

	public void setIdGrup(Long idGrup) {
		this.idGrup = idGrup;
	}

	public GrupoRN getGruRN() {
		if(this.gruRN == null){
			this.gruRN = new GrupoRN();
		}
		return gruRN;
	}

	public void setGruRN(GrupoRN gruRN) {
		this.gruRN = gruRN;
	}

	public SetorRN getSetRN() {
		if(this.setRN == null){
			this.setRN = new SetorRN();
		}
		return setRN;
	}

	public void setSetRN(SetorRN setRN) {
		this.setRN = setRN;
	}
}
