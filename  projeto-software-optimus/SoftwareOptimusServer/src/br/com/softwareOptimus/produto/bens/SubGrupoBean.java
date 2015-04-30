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
	private SubGrupo subGrupo = new SubGrupo();
	private Categoria categoria = new Categoria();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	private List<SubGrupo> listaSubGrupo = new ArrayList<SubGrupo>();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idCateg;

	public void novo() {
		this.sal = false;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		limpar();
		habilita();
	}

	public void alterar() {
		try {
			SubGrupoRN subRN = new SubGrupoRN();
			Integer retorno = subRN.validaCampoNulo(this.subGrupo);
			if (retorno == 0) {
				subRN.altSub(this.subGrupo);
				this.info("SubGrupo alterado com sucesso");
				this.alt = true;
				this.rem = true;
				this.vig = true;
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
		this.sal = true;
		this.alt = true;
		this.rem = true;
		this.vig = true;
		limpar();
		desabilita();
	}

	public void limpar() {
		this.subGrupo = new SubGrupo();
		this.categoria = new Categoria();
		this.listaCategoria = new ArrayList<Categoria>();
		this.listaSubGrupo = new ArrayList<SubGrupo>();
	}

	public void salvar() {
		try {
			SubGrupoRN subRN = new SubGrupoRN();
			this.subGrupo.setIdSubGrupo(null);
			Integer retorno = subRN.validaCampoNulo(this.subGrupo);
			if (retorno == 0) {
				subRN.salvar(this.subGrupo);
				this.info("SubGrupo salvo com sucesso");
				this.vig = false;
				this.sal = true;
				this.alt = false;
				this.rem = false;
			} else {
				this.error("Existem campos nulos no formulário");
			}
		} catch (Exception e) {
			this.error("Problemas na gravação do SubGrupo " + e.getMessage());
		}
	}

	public void remover() {
		try {
			SubGrupoRN subRN = new SubGrupoRN();
			Integer retorno = subRN.verificaRemocao(this.subGrupo);
			if (retorno == 0) {
				subRN.remover(this.subGrupo);
				this.info("SubGrupo removido com sucesso");
				this.alt = true;
				this.rem = true;
				this.vig = true;
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
		SubGrupoRN subRN = new SubGrupoRN();
		if (!busca.equals("") && (!filtro.equals(""))) {
			if (filtro.equals("id")) {
				this.listaSubGrupo = subRN.consultaId(Long.parseLong(busca));
			} else if (filtro.equals("desc")) {
				this.listaSubGrupo = subRN.consultaDesc(busca);
			}
		} else {
			this.listaSubGrupo = subRN.listar();
		}
	}

	public void remCategoria() {
		try {
			SubGrupoRN subRN = new SubGrupoRN();
			Integer retorno = subRN.VerificaRemCatSub(this.subGrupo,
					this.idCateg);
			if (retorno == 0) {
				subRN.removerCat(this.idCateg);
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
		SubGrupoRN subRN = new SubGrupoRN();
		this.subGrupo = subRN.editSub(this.id);
		listaCategoria();
		habilita();
		this.alt = false;
		this.vig = false;
		this.rem = false;
		this.sal = true;
	}

	public void incluirCategoria() {
		try {
			SubGrupoRN subRN = new SubGrupoRN();
			this.categoria.setIdCategoria(null);
			this.categoria.setSubGrupo(subGrupo);
			Integer retorno = subRN.validaCampoNuloCategoria(this.categoria);
			if (retorno == 0) {
				subRN.salvarCategoria(this.categoria);
				listaCategoria();
				this.categoria = new Categoria();
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
			SubGrupoRN subRN = new SubGrupoRN();
			if (this.listaCategoria != null) {
				this.listaCategoria.clear();
			}
			this.listaCategoria = subRN.listarCatg(this.subGrupo);
		} catch (Exception e) {
			this.error("Problemas ao listar as Categorias " + e.getMessage());
		}
	}

	public void habilita() {
		this.desc = false;
	}

	public void desabilita() {
		this.desc = true;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public List<SubGrupo> getListaSubGrupo() {
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
		return busca;
	}

	public String getFiltro() {
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
		return categoria;
	}

	public SubGrupo getSubGrupo() {
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
}
