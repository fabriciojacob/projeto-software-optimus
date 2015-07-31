package br.com.softwareOptimus.produto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbSubGrupo")
public class SubGrupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586902736478003490L;

	@Id
	@GeneratedValue
	private Long idSubGrupo;
	
	@Column ( length = 100 , nullable = true , unique = false)
	private String descricao;
	
	@OneToMany(mappedBy = "subGrupo")
	private List<Categoria> categoriaList;
	
	public String getDescricao() {
		return descricao;
	}
	
	public Long getIdSubGrupo() {
		return idSubGrupo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setIdSubGrupo(Long idSubGrupo) {
		this.idSubGrupo = idSubGrupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSubGrupo == null) ? 0 : idSubGrupo.hashCode());
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
		SubGrupo other = (SubGrupo) obj;
		if (idSubGrupo == null) {
			if (other.idSubGrupo != null)
				return false;
		} else if (!idSubGrupo.equals(other.idSubGrupo))
			return false;
		return true;
	}
	
}
