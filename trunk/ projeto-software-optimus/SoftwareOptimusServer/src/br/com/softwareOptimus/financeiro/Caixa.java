package br.com.softwareOptimus.financeiro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
		
@Entity
@Table(name = "tbCaixa")
public class Caixa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3679649773640077726L;
	
	@Id
	@GeneratedValue
	private Long idCaixa;
	
	private String descricao;
	
	private boolean inativar;

	public Long getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public boolean isInativar() {
		return inativar;
	}

	public void setInativar(boolean inativar) {
		this.inativar = inativar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCaixa == null) ? 0 : idCaixa.hashCode());
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
		Caixa other = (Caixa) obj;
		if (idCaixa == null) {
			if (other.idCaixa != null)
				return false;
		} else if (!idCaixa.equals(other.idCaixa))
			return false;
		return true;
	}
}
