package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbGradeTributaria")
public class GradeTributaria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 260554637064890437L;
	
	@Id
	@GeneratedValue
	private Long idGradeTrib;
	
	private String descricao;
	
	@OneToMany(mappedBy = "grade")
	private Collection<GradeTributariaVigencia> grade;

	public Long getIdGradeTrib() {
		return idGradeTrib;
	}

	public void setIdGradeTrib(Long idGradeTrib) {
		this.idGradeTrib = idGradeTrib;
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
		result = prime * result
				+ ((idGradeTrib == null) ? 0 : idGradeTrib.hashCode());
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
		GradeTributaria other = (GradeTributaria) obj;
		if (idGradeTrib == null) {
			if (other.idGradeTrib != null)
				return false;
		} else if (!idGradeTrib.equals(other.idGradeTrib))
			return false;
		return true;
	}
	
}
