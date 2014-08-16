package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;

@ManagedBean(name = "figuraFiscalBean")
@ViewScoped
public class FiguraFiscalBean {

	private FiguraFiscal figura = new FiguraFiscal();
	private GradeTributaria grade = new GradeTributaria();
	private List<FiguraFiscal> listaFigura = new ArrayList<FiguraFiscal>();
	private List<GradeTributaria> listaGrade = new ArrayList<GradeTributaria>();
	private Boolean sal = true, alt = true, rem = true;
	private String busca, filtro, tipoGrade;
	private Long id;
	
	public FiguraFiscalBean(){
		
	}

	public void novo() {
		limpar();
	}

	public void salvar() {

	}

	public void alterar() {

	}

	public void remover() {

	}

	public void limpar() {
		this.figura = new FiguraFiscal();
		this.listaFigura = new ArrayList<FiguraFiscal>();
		this.busca = "";
		this.filtro = "";
	}

	public void cancelar() {

	}

	public void editFigura() {

	}
	
	public void editGrade(){
		
	}
	
	public void excluirGrade(){
		
	}
	
	public void buscar(){
		
	}
	
	public void incluirGrade(){
		
	}

	public FiguraFiscal getFigura() {
		return figura;
	}

	public void setFigura(FiguraFiscal figura) {
		this.figura = figura;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FiguraFiscal> getListaFigura() {
		return listaFigura;
	}

	public void setListaFigura(List<FiguraFiscal> listaFigura) {
		this.listaFigura = listaFigura;
	}

	public List<GradeTributaria> getListaGrade() {
		return listaGrade;
	}

	public void setListaGrade(List<GradeTributaria> listaGrade) {
		this.listaGrade = listaGrade;
	}

	public GradeTributaria getGrade() {
		return grade;
	}

	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}

	public String getTipoGrade() {
		return tipoGrade;
	}

	public void setTipoGrade(String tipoGrade) {
		this.tipoGrade = tipoGrade;
	}
}
