package br.com.softwareOptimus.fiscal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbCST")
public class CodigoSituacaoTributaria extends CodigoFiscalGenerico {
	
	private String cst;
	
	private TipoCst tipoCst;
	
	public TipoCst getTipoCst() {
		return tipoCst;
	}
	
	public void setTipoCst(TipoCst tipoCst) {
		this.tipoCst = tipoCst;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}
	
}
