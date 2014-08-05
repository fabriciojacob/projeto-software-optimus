package br.com.softwareOptimus.fiscal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbCFOP")
public class CodigoFiscalOperacao extends CodigoFiscalGenerico  {
	
	private String cfop;
	
	@Override
	public Long getId() {
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getCfop() {
		return cfop;
	}
	
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

}
