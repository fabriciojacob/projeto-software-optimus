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
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unused")
		CodigoSituacaoTributaria estado = new CodigoSituacaoTributaria();
		@SuppressWarnings("unused")
		int ufId;

		try {
			ufId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Type the name of a Dog and select it (or use the dropdow)",
							"Type the name of a Dog and select it (or use the dropdow)"));
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null) {
			return "";
		}
		CodigoSituacaoTributaria estado = (CodigoSituacaoTributaria) arg2;
		return String.valueOf(estado.getId());
	}
}
