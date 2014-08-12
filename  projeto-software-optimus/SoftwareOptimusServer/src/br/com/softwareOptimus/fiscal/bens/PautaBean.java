package br.com.softwareOptimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.softwareOptimus.fiscal.PautaMVA;

@ManagedBean(name = "pautaBean")
@SessionScoped
public class PautaBean {
	
	private PautaMVA pauta = new PautaMVA();
	private Boolean sal = true, alt = true, rem = true;
	private String busca, filtro;
	private List<PautaMVA> pautaList = new ArrayList<PautaMVA>();
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PautaMVA> getPautaList() {
		return pautaList;
	}

	public void setPautaList(List<PautaMVA> pautaList) {
		this.pautaList = pautaList;
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

	public String getBuscaPauta() {
		return busca;
	}

	public void setBuscaPauta(String buscaPauta) {
		this.busca = buscaPauta;
	}

	public PautaMVA getPauta() {
		return pauta;
	}

	public void setPauta(PautaMVA pauta) {
		this.pauta = pauta;
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

	public void novo(){
		
	}
	
	public void alterar() {
		
	}
	
	public void remover() {

	}
	
	public void cancelar() {
		
	}

	public void salvar(){
		
	}
	
	public void limpar(){
		
	}
	
	public void buscaPauta(){
		
	}
	
	public void editPauta(){
		
	}
}
