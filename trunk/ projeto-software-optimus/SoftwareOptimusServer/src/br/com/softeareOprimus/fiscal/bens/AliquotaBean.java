package br.com.softeareOprimus.fiscal.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.softwareOptimus.fiscal.Aliquota;

@ManagedBean(name = "aliquotaBean")
@SessionScoped
public class AliquotaBean {
	
	private Aliquota aliquota = new Aliquota();
	private List<Aliquota> aliqList = new ArrayList<Aliquota>();
	private String busca, filtro, tipCst, tipTrib;
	private int id;
	private boolean sal = true, alt = true, rem = true;
	
	public String getTipTrib() {
		return tipTrib;
	}

	public void setTipTrib(String tipTrib) {
		this.tipTrib = tipTrib;
	}

	public String getTipCst() {
		return tipCst;
	}

	public void setTipCst(String tipCst) {
		this.tipCst = tipCst;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Aliquota> getAliqList() {
		return aliqList;
	}

	public void setAliqList(List<Aliquota> aliqList) {
		this.aliqList = aliqList;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
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

	public Aliquota getAliquota() {
		return aliquota;
	}

	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
	}

	public void novo(){
		
	}

	public void salvar(){
		
	}
	
	public void alterar(){
		
	}
	
	public void remover(){
		
	}
	
	public void consultar(){
		
	}
	
	public void cancelar(){
		
	}
	
	public void buscaAliq(){
		
	}
	
	public void editAliq(){
		
	}
}
