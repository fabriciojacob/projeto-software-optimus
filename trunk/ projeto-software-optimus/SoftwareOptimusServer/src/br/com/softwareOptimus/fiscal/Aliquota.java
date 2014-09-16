package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbAliquota")
public class Aliquota implements Serializable, Converter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9015113293420670456L;

	@Id
	@GeneratedValue
	private Long idAliq;
	
	private Double aliquota;
	
	private Double reducao;
	
	@ManyToMany
	private Collection<CodigoSituacaoTributaria> cst;
	
	private TipoTrib tipo;
	
	private PisCofins pisCofins;
	
	public PisCofins getPisCofins() {
		return pisCofins;
	}

	public void setPisCofins(PisCofins pisCofins) {
		this.pisCofins = pisCofins;
	}

	public TipoTrib getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoTrib tipo) {
		this.tipo = tipo;
	}

	public Long getIdAliq() {
		return idAliq;
	}

	public void setIdAliq(Long idAliq) {
		this.idAliq = idAliq;
	}

	public Double getAliquota() {
		return aliquota;
	}

	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}

	public Double getReducao() {
		return reducao;
	}

	public void setReducao(Double reducao) {
		this.reducao = reducao;
	}
	
	public Collection<CodigoSituacaoTributaria> getCst() {
		return cst;
	}
	
	public void setCst(Collection<CodigoSituacaoTributaria> cst) {
		this.cst = cst;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAliq == null) ? 0 : idAliq.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aliquota other = (Aliquota) obj;
		if (idAliq == null) {
			if (other.idAliq != null)
				return false;
		} else if (!idAliq.equals(other.idAliq))
			return false;
		return true;
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unused")
		Aliquota estado = new Aliquota();
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
		Aliquota estado = (Aliquota) arg2;
		return String.valueOf(estado.getIdAliq());
	}

}
