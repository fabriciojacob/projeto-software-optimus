package br.com.softwareOptimus.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbPais")
public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6801947433059212464L;
	
	@Id
	@GeneratedValue
	private Long idPais;
	
	private String descricao;
	
	private Integer codIbge;
	
	@OneToMany(mappedBy = "pais")
	private Collection<Estado> estados;
	
	public Collection<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}
	
	public Integer getCodIbge() {
		return codIbge;
	}
	
	public void setCodIbge(Integer codIbge) {
		this.codIbge = codIbge;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
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
		result = prime * result + ((idPais == null) ? 0 : idPais.hashCode());
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
		Pais other = (Pais) obj;
		if (idPais == null) {
			if (other.idPais != null)
				return false;
		} else if (!idPais.equals(other.idPais))
			return false;
		return true;
	}
	
}
