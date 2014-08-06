package br.com.softwareOptimus.fiscal;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CodigoFiscalGenerico implements Serializable, Converter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6551663029170042741L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (length = 350, nullable = true , unique = false)
	private String descricao;
	
	private IO io;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CodigoFiscalGenerico other = (CodigoFiscalGenerico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unused")
		CodigoFiscalGenerico estado = new CodigoFiscalGenerico();
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
		CodigoFiscalGenerico estado = (CodigoFiscalGenerico) arg2;
		return String.valueOf(estado.getId());
	}
	
}
