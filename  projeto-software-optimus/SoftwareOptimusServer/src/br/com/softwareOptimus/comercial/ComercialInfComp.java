package br.com.softwareOptimus.comercial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbComInfComp")
public class ComercialInfComp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6286660988532944671L;

	@Id
	@GeneratedValue
	private Long idComInfComp;
	
	@ManyToOne
	private Comercial Comercial;
	
	private String textInfComp;
	
	@Column (length = 6 , nullable = false , unique = false)
	private String codInfComp;

	public Long getIdComInfComp() {
		return idComInfComp;
	}

	public void setIdComInfComp(Long idComInfComp) {
		this.idComInfComp = idComInfComp;
	}

	public Comercial getComercial() {
		return Comercial;
	}

	public void setComercial(Comercial Comercial) {
		this.Comercial = Comercial;
	}

	public String getTextInfComp() {
		return textInfComp;
	}

	public void setTextInfComp(String textInfComp) {
		this.textInfComp = textInfComp;
	}

	public String getCodInfComp() {
		return codInfComp;
	}

	public void setCodInfComp(String codInfComp) {
		this.codInfComp = codInfComp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComInfComp == null) ? 0 : idComInfComp.hashCode());
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
		ComercialInfComp other = (ComercialInfComp) obj;
		if (idComInfComp == null) {
			if (other.idComInfComp != null)
				return false;
		} else if (!idComInfComp.equals(other.idComInfComp))
			return false;
		return true;
	}
}
