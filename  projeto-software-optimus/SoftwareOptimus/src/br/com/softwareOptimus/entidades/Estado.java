package br.com.softwareOptimus.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.softwareOptimus.fiscal.GradeTributaria;


@Entity
@Table(name="tbEstado")
public class Estado implements Serializable{

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
	
	@OneToMany(mappedBy = "estado")
	private Collection<GradeTributaria> grades;
	
	@OneToMany(mappedBy = "uf")
	private Collection<Municipio> municipio;
	
	public Collection<Municipio> getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Collection<Municipio> municipio) {
		this.municipio = municipio;
	}
	
	public Collection<GradeTributaria> getGrades() {
		return grades;
	}
	
	public void setGrades(Collection<GradeTributaria> grades) {
		this.grades = grades;
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
	
}
