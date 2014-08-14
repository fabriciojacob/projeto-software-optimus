package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.GradeTributaria;

@ManagedBean
@ViewScoped
public class GradeTributariaBean {

	private GradeTributaria grade = new GradeTributaria();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private String busca, filtro, tipCst, tipTrib;
	private Long id;
	private boolean sal = true, alt = true, rem = true;
	
	public void novo() {
		
	}
	
	public void salvar(){
		
	}
	
	public void alterar(){
		
	}
	
	public void remover(){
		
	}
	
	public void buscar(){
		
	}
	
	public void editGrade(){
		
	}
	
	public void limpar(){
		
	}
	
	public void cancelar(){
		
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
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

	public String getTipCst() {
		return tipCst;
	}

	public void setTipCst(String tipCst) {
		this.tipCst = tipCst;
	}

	public String getTipTrib() {
		return tipTrib;
	}

	public void setTipTrib(String tipTrib) {
		this.tipTrib = tipTrib;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
