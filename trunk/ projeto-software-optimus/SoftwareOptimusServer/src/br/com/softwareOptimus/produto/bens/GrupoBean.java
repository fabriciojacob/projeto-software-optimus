package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.RN.GrupoRN;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "grupoBean")
@ViewScoped
public class GrupoBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = -8440394944937003096L;
	private Grupo grupo;
	private SubGrupo subGrupo;
	private List<Grupo> listaGrupo;
	private List<SubGrupo> listaSubGrupo;
	private List<SubGrupo> listaSubGrupoExib;
	private SubGrupoRN subRN;
	private GrupoRN gruRN;
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idSub;

	public GrupoBean() {
		this.setListaSubGrupo(this.getSubRN().listaSubGrupo());
	}

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(false);
		this.setListaSubGrupo(this.getSubRN().listaSubGrupo());
		limpar();
		habilita();
	}

	public void salvar() {
		try {
			this.getGrupo().setIdGrupo(null);
			Integer retorno = this.getGruRN().validaCampoNulo(this.getGrupo(), this.getListaSubGrupoExib());
			if (retorno == 0) {
				this.getGrupo().setSubGrupo(this.getListaSubGrupoExib());
				this.getGruRN().salvar(this.getGrupo());
				this.info("Grupo salvo com sucesso");
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
				this.setVig(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao do Grupo " + e.getMessage());
		}
	}

	public void alterar() {
		try {
			Integer retorno = this.getGruRN().validaCampoNulo(this.getGrupo(), this.getListaSubGrupoExib());
			if (retorno == 0) {
				this.getGrupo().setSubGrupo(this.getListaSubGrupoExib());
				this.getGruRN().altGru(this.getGrupo());
				this.info("Grupo alterado com sucesso");
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
			this.error("Problemas na alteração do Grupo " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getGruRN().verificaRemocao(this.getGrupo());
			if (retorno == 0) {
				this.getGruRN().remover(this.getGrupo());
				this.info("Grupo removido com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Setores ou Produtos vinculados a este Grupo. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção do Grupo " + e.getMessage());
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
		this.setGrupo(null);
		this.setListaGrupo(null);
		this.setListaSubGrupoExib(null);
	}

	public void buscarGrup() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaGrupo(this.getGruRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaGrupo(this.getGruRN().consultaDesc(this.getBusca()));
			}else if (this.getFiltro().equals("idSub")) {
				this.setListaGrupo(this.getGruRN().consultaIdSub(Long.parseLong(this.getBusca())));
			}else if (this.getFiltro().equals("descSub")) {
				this.setListaGrupo(this.getGruRN().consultaDescSub(this.getBusca()));
			}
		} else {
			this.setListaGrupo(this.getGruRN().listar());
		}
	}

	public void removiSub() {
		Integer retorno = this.getGruRN().verificaRemSubPro(this.getGrupo(), this.getIdSub());
		if (retorno == 0) {
			List<SubGrupo> listaSubNovo = new ArrayList<SubGrupo>();
			listaSubNovo.addAll(this.getListaSubGrupoExib());
			for (SubGrupo sub : this.getListaSubGrupoExib()) {
				if (sub.getIdSubGrupo().equals(this.getIdSub())) {
					listaSubNovo.remove(sub);
				}
			}
			this.setListaSubGrupoExib(null);
			this.getListaSubGrupoExib().addAll(listaSubNovo);
		} else {
			this.error("Remoção não permitida! Existem Produtos vinculados a este Grupo e SubGrupo. ");
		}
	}

	public void editGrupo() {
		limpar();
		this.setGrupo(this.getGruRN().editGru(this.getId()));
		this.getListaSubGrupoExib().addAll(this.getSubRN().listaSubGru(this.id));
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVig(false);
	}

	public void incluirSub() {
		if (this.getSubGrupo() != null) {
			Integer retorno = verificaInclusaoSubGrupo();
			if (retorno == 0) {
				this.getListaSubGrupoExib().add(this.getSubGrupo());
			} else {
				this.error("SubGrupo já vinculado no Grupo!");
			}
		} else {
			this.error("Escolha uma SubGrupo para incluir.");
		}
	}

	private Integer verificaInclusaoSubGrupo() {
		Integer retorno = 0;
		for (SubGrupo sub : this.getListaSubGrupoExib()) {
			if (sub.getIdSubGrupo().equals(this.getSubGrupo().getIdSubGrupo()))
				retorno++;
		}
		return retorno;
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
	}

	public List<SubGrupo> getListaSubGrupoExib() {
		if(this.listaSubGrupoExib == null){
			this.listaSubGrupoExib = new ArrayList<SubGrupo>();
		}
		return listaSubGrupoExib;
	}

	public void setListaSubGrupoExib(List<SubGrupo> listaSubGrupoExib) {
		this.listaSubGrupoExib = listaSubGrupoExib;
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

	public SubGrupo getSubGrupo() {
		if(this.subGrupo == null){
			this.subGrupo = new SubGrupo();
		}
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
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

	public List<SubGrupo> getListaSubGrupo() {
		if(this.listaSubGrupo == null){
			this.listaSubGrupo = new ArrayList<SubGrupo>();
		}
		return listaSubGrupo;
	}

	public void setListaSubGrupo(List<SubGrupo> listaSubGrupo) {
		this.listaSubGrupo = listaSubGrupo;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSub() {
		return idSub;
	}

	public void setIdSub(Long idSub) {
		this.idSub = idSub;
	}

	public SubGrupoRN getSubRN() {
		if(this.subRN == null){
			this.subRN = new SubGrupoRN();
		}
		return subRN;
	}

	public void setSubRN(SubGrupoRN subRN) {
		this.subRN = subRN;
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
}
