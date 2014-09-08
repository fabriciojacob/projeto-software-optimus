package br.com.softwareOptimus.produto.bens;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;

@ManagedBean(name = "tipoProdutoBean")
@ViewScoped
public class TipoProdutoBean {

	private TipoProduto tipo = new TipoProduto();
	private CodTabelaGov tbGov = new CodTabelaGov();
	private List<TipoProduto> listaTipoProduto = new ArrayList<TipoProduto>();
	private List<CodTabelaGov> listaTbGov = new ArrayList<CodTabelaGov>();
	private boolean sal = true, alt = true, rem = true, vig = true,
			desc = true;
	private String busca, filtro;
	private Long id, idVig;

	public TipoProdutoBean(){
		
	}
	
	public void salvar() {

	}

	public void alterar() {

	}

	public void remover() {

	}

	public void cancelar() {

	}
	
	public void excluirVigTip(){
		
	}
	
	public void editarVigTip(){
		
	}
	
	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	public List<TipoProduto> getListaTipoProduto() {
		return listaTipoProduto;
	}

	public void setListaTipoProduto(List<TipoProduto> listaTipoProduto) {
		this.listaTipoProduto = listaTipoProduto;
	}

	public boolean isVig() {
		return vig;
	}

	public void setVig(boolean vig) {
		this.vig = vig;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
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

	public Long getIdVig() {
		return idVig;
	}

	public void setIdVig(Long idVig) {
		this.idVig = idVig;
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

	public CodTabelaGov getTbGov() {
		return tbGov;
	}

	public void setTbGov(CodTabelaGov tbGov) {
		this.tbGov = tbGov;
	}

	public List<CodTabelaGov> getListaTbGov() {
		return listaTbGov;
	}

	public void setListaTbGov(List<CodTabelaGov> listaTbGov) {
		this.listaTbGov = listaTbGov;
	}
}
