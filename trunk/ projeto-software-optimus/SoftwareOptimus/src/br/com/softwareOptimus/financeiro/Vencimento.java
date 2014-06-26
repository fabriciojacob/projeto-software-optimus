package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbVencimento")
public class Vencimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6607670811741431162L;
	
	@Id
	@GeneratedValue
	private Long idVenc;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataVencimento;
	
	@ManyToOne
	private CondPgto condPgto;

	public Long getIdVenc() {
		return idVenc;
	}

	public void setIdVenc(Long idVenc) {
		this.idVenc = idVenc;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public CondPgto getCondPgto() {
		return condPgto;
	}

	public void setCondPgto(CondPgto condPgto) {
		this.condPgto = condPgto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenc == null) ? 0 : idVenc.hashCode());
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
		Vencimento other = (Vencimento) obj;
		if (idVenc == null) {
			if (other.idVenc != null)
				return false;
		} else if (!idVenc.equals(other.idVenc))
			return false;
		return true;
	}
	
	

}
