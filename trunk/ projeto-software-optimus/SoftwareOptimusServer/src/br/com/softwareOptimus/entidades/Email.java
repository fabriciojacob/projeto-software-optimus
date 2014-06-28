package br.com.softwareOptimus.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbEmail")
public class Email<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2481921935091313257L;
	
	@GeneratedValue
	@Id
	private Long idEmail;
	
	private String email;
	
	private Integer padraoNFe;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(T pessoa) {
		this.pessoa = (Pessoa) pessoa;
	}

	public Long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getPadraoNFe() {
		return padraoNFe;
	}
	
	public void setPadraoNFe(Integer padraoNFe) {
		this.padraoNFe = padraoNFe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmail == null) ? 0 : idEmail.hashCode());
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
		Email other = (Email) obj;
		if (idEmail == null) {
			if (other.idEmail != null)
				return false;
		} else if (!idEmail.equals(other.idEmail))
			return false;
		return true;
	}
	
}
