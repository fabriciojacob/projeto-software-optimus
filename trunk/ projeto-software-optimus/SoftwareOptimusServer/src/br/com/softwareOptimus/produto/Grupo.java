package br.com.softwareOptimus.produto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbGrupo")
public class Grupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7183243498748843553L;
	
	@Id
	@GeneratedValue
	private Long idGrupo;
	
	@Column ( length = 100 , nullable = true , unique = false)
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "tbVincSubGrupo", joinColumns = @JoinColumn(name = "grupo"), inverseJoinColumns = @JoinColumn(name = "subGrupo"))
	private Collection<SubGrupo> subGrupo;
	
	@ManyToMany(mappedBy = "grupo")
	private List<Setor> setorList;
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public Collection<SubGrupo> getSubGrupo() {
		return subGrupo;
	}
	
	public Long getIdGrupo() {
		return idGrupo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	public void setSubGrupo(Collection<SubGrupo> subGrupo) {
		this.subGrupo = subGrupo;
	}

	public List<Setor> getSetorList() {
		return setorList;
	}

	public void setSetorList(List<Setor> setorList) {
		this.setorList = setorList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
			return false;
		return true;
	}

}
