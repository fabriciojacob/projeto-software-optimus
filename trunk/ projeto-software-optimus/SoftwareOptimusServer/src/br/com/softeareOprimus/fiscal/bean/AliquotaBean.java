package br.com.softeareOprimus.fiscal.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.softwareOptimus.fiscal.Aliquota;

@ManagedBean(name = "aliquotaBean")
@SessionScoped
public class AliquotaBean {
	
	private Aliquota aliquota = new Aliquota();
	private boolean sal = true, alt = true, rem = true;
	
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
}
