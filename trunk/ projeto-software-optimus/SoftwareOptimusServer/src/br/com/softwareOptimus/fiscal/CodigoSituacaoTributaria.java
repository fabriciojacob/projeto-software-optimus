package br.com.softwareOptimus.fiscal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbCST")
public class CodigoSituacaoTributaria extends CodigoFiscalGenerico  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5231539704225409903L;

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
