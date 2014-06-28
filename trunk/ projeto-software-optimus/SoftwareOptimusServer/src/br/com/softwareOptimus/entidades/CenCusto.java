package br.com.softwareOptimus.entidades;

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
@Table(name = "tbCenCusto")
public class CenCusto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6458499992104230742L;

	@Id
	@GeneratedValue
	private Long idCenCusto;

	private String nomeCenCusto;

	@Temporal(TemporalType.DATE)
	private Calendar datInclusao;

	@ManyToOne
	private Pessoa empresa;

	public Long getIdCenCusto() {
		return idCenCusto;
	}

	public void setIdCenCusto(Long idCenCusto) {
		this.idCenCusto = idCenCusto;
	}

	public String getNomeCenCusto() {
		return nomeCenCusto;
	}

	public void setNomeCenCusto(String nomeCenCusto) {
		this.nomeCenCusto = nomeCenCusto;
	}

	public Calendar getDatInclusao() {
		return datInclusao;
	}

	public void setDatInclusao(Calendar datInclusao) {
		this.datInclusao = datInclusao;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCenCusto == null) ? 0 : idCenCusto.hashCode());
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
		CenCusto other = (CenCusto) obj;
		if (idCenCusto == null) {
			if (other.idCenCusto != null)
				return false;
		} else if (!idCenCusto.equals(other.idCenCusto))
			return false;
		return true;
	}
}
