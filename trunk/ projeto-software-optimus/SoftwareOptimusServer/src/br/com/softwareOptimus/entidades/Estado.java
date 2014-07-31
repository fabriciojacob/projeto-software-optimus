package br.com.softwareOptimus.entidades;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.softwareOptimus.fiscal.GradeTributaria;

@Entity
@Table(name = "tbEstado")
public class Estado implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -652813449840837138L;

	@Id
	@GeneratedValue
	private Long idUf;

	private String descricao;

	private Integer codIbge;

	@ManyToOne
	private Pais pais;

	@OneToMany(mappedBy = "origem")
	private Collection<GradeTributaria> grades1;
	
	@OneToMany(mappedBy = "destino")
	private Collection<GradeTributaria> grades2;
	

	@OneToMany(mappedBy = "uf")
	private Collection<Municipio> municipio;

	public Collection<Municipio> getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Collection<Municipio> municipio) {
		this.municipio = municipio;
	}

	public Collection<GradeTributaria> getGrades1() {
		return grades1;
	}

	public void setGrades1(Collection<GradeTributaria> grades1) {
		this.grades1 = grades1;
	}

	public Collection<GradeTributaria> getGrades2() {
		return grades2;
	}

	public void setGrades2(Collection<GradeTributaria> grades2) {
		this.grades2 = grades2;
	}

	public Integer getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(Integer codIbge) {
		this.codIbge = codIbge;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUf == null) ? 0 : idUf.hashCode());
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
		Estado other = (Estado) obj;
		if (idUf == null) {
			if (other.idUf != null)
				return false;
		} else if (!idUf.equals(other.idUf))
			return false;
		return true;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		@SuppressWarnings("unused")
		Estado estado = new Estado();
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
		Estado estado = (Estado) arg2;
		return String.valueOf(estado.getIdUf());
	}

}
