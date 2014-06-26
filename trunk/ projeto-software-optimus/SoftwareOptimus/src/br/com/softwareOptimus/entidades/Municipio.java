package br.com.softwareOptimus.entidades;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbMunicipio")
@Cacheable(true)
public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190834454652723153L;
	
	@Id
	@GeneratedValue
	private Long idMunicipio;
	
	private String descricao;
	
	private Integer codIbge;
	
	@ManyToOne
	private Estado uf;

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(Integer codIbge) {
		this.codIbge = codIbge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMunicipio == null) ? 0 : idMunicipio.hashCode());
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
		Municipio other = (Municipio) obj;
		if (idMunicipio == null) {
			if (other.idMunicipio != null)
				return false;
		} else if (!idMunicipio.equals(other.idMunicipio))
			return false;
		return true;
	}
	
	
	
}
