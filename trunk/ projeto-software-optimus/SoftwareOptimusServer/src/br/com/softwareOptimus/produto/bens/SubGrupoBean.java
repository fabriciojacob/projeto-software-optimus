package br.com.softwareOptimus.produto.bens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.produto.RN.SubGrupoRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "subGrupoBean")
@ViewScoped
public class SubGrupoBean extends FacesUtil implements Serializable{

	private static final long serialVersionUID = 6025267193479395126L;
	private SubGrupo subGrupo;
	private Categoria categoria;
	private List<Categoria> listaCategoria;
	private List<SubGrupo> listaSubGrupo;
	private SubGrupoRN subRN;
	private String busca, filtro;
	private boolean sal = true;
	private boolean alt = true;
	private boolean rem = true;
	private boolean desc = true;
	private boolean vig = true;
	private Long id;
	private Long idCateg;

	public void novo() {
		this.setSal(false);
		this.setAlt(true);
		this.setRem(true);
		this.setVig(true);
		limpar();
		habilita();
	}

	public void alterar() {
		try {
			Integer retorno = this.getSubRN().validaCampoNulo(this.getSubGrupo());
			if (retorno == 0) {
				this.getSubRN().altSub(this.getSubGrupo());
				this.info("SubGrupo alterado com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);
				limpar();
				desabilita();
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na alteração do SubGrupo " + e.getMessage());
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
		this.setSubGrupo(null);
		this.setCategoria(null);
		this.setListaCategoria(null);
		this.setListaSubGrupo(null);
	}

	public void salvar() {
		try {
			this.getSubGrupo().setIdSubGrupo(null);
			Integer retorno = this.getSubRN().validaCampoNulo(this.getSubGrupo());
			if (retorno == 0) {
				this.getSubRN().salvar(this.getSubGrupo());
				this.info("SubGrupo salvo com sucesso");
				this.setSal(true);
				this.setAlt(false);
				this.setRem(false);
				this.setVig(false);
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravação do SubGrupo " + e.getMessage());
		}
	}

	public void remover() {
		try {
			Integer retorno = this.getSubRN().verificaRemocao(this.getSubGrupo());
			if (retorno == 0) {
				this.getSubRN().remover(this.getSubGrupo());
				this.info("SubGrupo removido com sucesso");
				this.setAlt(true);
				this.setRem(true);
				this.setVig(true);				
				limpar();
				desabilita();
			} else {
				this.error("Remoção não permitida! Existem Grupos ou Produtos vinculados a este SubGrupo. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção do SubGrupo " + e.getMessage());
		}
	}

	public void buscaSub() {
		limpar();
		if (!this.getBusca().equals("") && (!this.getFiltro().equals(""))) {
			if (this.getFiltro().equals("id")) {
				this.setListaSubGrupo(this.getSubRN().consultaId(Long.parseLong(this.getBusca())));
			} else if (this.getFiltro().equals("desc")) {
				this.setListaSubGrupo(this.getSubRN().consultaDesc(this.getBusca()));
			}
		} else {
			this.setListaSubGrupo(this.getSubRN().listar());
		}
	}

	public void remCategoria() {
		try {
			Integer retorno = this.getSubRN().VerificaRemCatSub(this.getSubGrupo(), this.getIdCateg());
			if (retorno == 0) {
				this.getSubRN().removerCat(this.getIdCateg());
				listaCategoria();
				this.info("Categoria removida com sucesso");
			} else {
				this.error("Remoção não permitida! Existem Produtos vinculados a este SubGrupo e Categoria. ");
			}
		} catch (Exception e) {
			this.error("Problemas na remoção da Categoria " + e.getMessage());
		}
	}

	public void editSub() {
		this.setSubGrupo(this.getSubRN().editSub(this.id));
		listaCategoria();
		habilita();
		this.setSal(true);
		this.setAlt(false);
		this.setRem(false);
		this.setVig(false);
	}

	public void incluirCategoria() {
		try {
			this.getCategoria().setIdCategoria(null);
			this.getCategoria().setSubGrupo(this.getSubGrupo());
			Integer retorno = this.getSubRN().validaCampoNuloCategoria(this.getCategoria());
			if (retorno == 0) {
				this.getSubRN().salvarCategoria(this.getCategoria());
				listaCategoria();
				this.setCategoria(null);
				this.info("Categoria salva com sucesso");
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravacao do SubGrupo " + e.getMessage());
		}
	}

	public void listaCategoria() {
		try {
			this.getListaCategoria().clear();
			this.setListaCategoria(this.getSubRN().listarCatg(this.getSubGrupo()));
		} catch (Exception e) {
			this.error("Problemas ao listar as Categorias " + e.getMessage());
		}
	}

	public void habilita() {
		this.setDesc(false);
	}

	public void desabilita() {
		this.setDesc(true);
	}

	public List<Categoria> getListaCategoria() {
		if(this.listaCategoria == null){
			this.listaCategoria = new ArrayList<Categoria>();
		}
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
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

	public Long getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(Long idCateg) {
		this.idCateg = idCateg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusca() {
		if(this.busca == null){
			this.busca = new String();
		}
		return busca;
	}

	public String getFiltro() {
		if(this.filtro == null){
			this.filtro = new String();
		}
		return filtro;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
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

	public Categoria getCategoria() {
		if(this.categoria == null){
			this.categoria = new Categoria();
		}
		return categoria;
	}

	public SubGrupo getSubGrupo() {
		if(this.subGrupo == null){
			this.subGrupo = new SubGrupo();
		}
		return subGrupo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
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
}