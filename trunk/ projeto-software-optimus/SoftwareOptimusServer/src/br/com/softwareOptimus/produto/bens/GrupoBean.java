package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.SubGrupo;

@ManagedBean(name = "grupoBean")
@ViewScoped
public class GrupoBean {
	
	private Grupo grupo = new Grupo();
	private SubGrupo subGrupo = new SubGrupo();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private List<SubGrupo > listaSubGrupo = new ArrayList<SubGrupo>();
	private String busca, filtro;
	private boolean sal = true, alt = true, rem = true, desc = true,
			vig = true;
	private Long id, idSub;
	
	public void novo(){
		
	}
	
	public void salvar(){
		
	}
	
	public void alterar(){
		
	}
	
	public void remover(){
		
	}
	
	public void cancelar(){
		
	}
	
	public void limpar(){
		
	}
	
	public void buscarGrup(){
		
	}
	
	public void removiSub(){
		
	}
	
	public void editGrupo(){
		
	}
	
	public void listaSub(){
		
	}
	
	public void incluirSub(){
		
	}
	
	public void habilita(){
		this.desc = false;
	}
	
	public void desabilita(){
		this.desc = true;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public SubGrupo getSubGrupo() {
		return subGrupo;
	}
	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}
	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}
	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}
	public List<SubGrupo> getListaSubGrupo() {
		return listaSubGrupo;
	}
	public void setListaSubGrupo(List<SubGrupo> listaSubGrupo) {
		this.listaSubGrupo = listaSubGrupo;
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
}
