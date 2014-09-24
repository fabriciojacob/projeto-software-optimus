package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.SubGrupo;

@ManagedBean(name = "subGrupoBean")
@ViewScoped
public class SubGrupoBean {

	private SubGrupo subGrupo = new SubGrupo();
	private Categoria categoria = new Categoria();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	private List<SubGrupo> listaSubGrupo = new ArrayList<SubGrupo>();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idCateg;

	public SubGrupoBean() {

	}

	public void novo() {

	}

	public void alterar() {

	}

	public void cancelar() {

	}

	public void limpar() {

	}

	public void salvar() {

	}

	public void remover() {

	}
	
	public void vincCategoria(){
		
	}
	
	public void buscaSub(){
		
	}
	
	public void remCategoria(){
		
	}
	
	public void editSub(){
		
	}

	public void habilita() {

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
	
	public void desabilita() {

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
