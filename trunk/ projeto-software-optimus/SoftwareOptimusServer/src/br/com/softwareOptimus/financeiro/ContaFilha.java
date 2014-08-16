package br.com.softwareOptimus.financeiro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbContaFilha")
public class ContaFilha implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5286675569550310034L;
	
	@Id
	@GeneratedValue
	private Long idContaFilha;
	
	private String descricao;
	
	@ManyToOne
	private Conta conta;

	public Long getIdContaFilha() {
		return idContaFilha;
	}

	public void setIdContaFilha(Long idContaFilha) {
		this.idContaFilha = idContaFilha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idContaFilha == null) ? 0 : idContaFilha.hashCode());
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
		ContaFilha other = (ContaFilha) obj;
		if (idContaFilha == null) {
			if (other.idContaFilha != null)
				return false;
		} else if (!idContaFilha.equals(other.idContaFilha))
			return false;
		return true;
	}
	

}
