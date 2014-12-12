package br.com.softwareOptimus.produto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbSetor")
public class Setor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8548273193726403343L;

	@Id
	@GeneratedValue
	private Long idSetor;
	
	@Column ( length = 100 , nullable = true , unique = false)
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "tbVincGrupSetor", joinColumns = @JoinColumn(name = "setor"), inverseJoinColumns = @JoinColumn(name = "grupo"))
	private Collection<Grupo> grupo;
	
	public String getDescricao() {
		return descricao;
	}
	
	public Collection<Grupo> getGrupo() {
		return grupo;
	}
	
	public Long getIdSetor() {
		return idSetor;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setGrupo(Collection<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
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
		Setor other = (Setor) obj;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		return true;
	}
}
