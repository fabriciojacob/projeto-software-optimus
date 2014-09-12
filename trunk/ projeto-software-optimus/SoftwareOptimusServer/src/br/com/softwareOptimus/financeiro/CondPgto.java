package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbCondPgto")
public class CondPgto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889866416730394328L;
	
	@Id
	@GeneratedValue
	private Long idCondPgto;
	
	private Integer parcela;
	
	private String descricao;
	
	private boolean inativar;

	public Long getIdCondPgto() {
		return idCondPgto;
	}

	public void setIdCondPgto(Long idCondPgto) {
		this.idCondPgto = idCondPgto;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public boolean isInativar() {
		return inativar;
	}

	public void setInativar(boolean inativar) {
		this.inativar = inativar;
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
				+ ((idCondPgto == null) ? 0 : idCondPgto.hashCode());
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
		CondPgto other = (CondPgto) obj;
		if (idCondPgto == null) {
			if (other.idCondPgto != null)
				return false;
		} else if (!idCondPgto.equals(other.idCondPgto))
			return false;
		return true;
	}

}
