package br.com.softwareOptimus.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbTelefone")
public class Telefone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3902116913286307347L;
	
	@Id
	@GeneratedValue
	private Long idTelefone;
	
	private Integer numero;
	
	private TipoTelefone tipoFone;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoFone() {
		return tipoFone;
	}

	public void setTipoFone(TipoTelefone tipoFone) {
		this.tipoFone = tipoFone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTelefone == null) ? 0 : idTelefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (idTelefone == null) {
			if (other.idTelefone != null)
				return false;
		} else if (!idTelefone.equals(other.idTelefone))
			return false;
		return true;
	}
	
}
