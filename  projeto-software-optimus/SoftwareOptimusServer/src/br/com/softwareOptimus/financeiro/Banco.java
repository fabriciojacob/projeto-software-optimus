package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbBanco")
public class Banco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180261796892588279L;
	
	@Id
	private String idBanco;
	
	private String nome;
	
	@OneToMany(mappedBy = "banco")
	private Collection<ContaBancaria> contaCorrente;
	
	public Collection<ContaBancaria> getContaCorrente() {
		return contaCorrente;
	}
	
	public void setContaCorrente(Collection<ContaBancaria> contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public String getIdBanco() {
		return idBanco;
	}
	
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBanco == null) ? 0 : idBanco.hashCode());
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
		Banco other = (Banco) obj;
		if (idBanco == null) {
			if (other.idBanco != null)
				return false;
		} else if (!idBanco.equals(other.idBanco))
			return false;
		return true;
	}
	
	
}
