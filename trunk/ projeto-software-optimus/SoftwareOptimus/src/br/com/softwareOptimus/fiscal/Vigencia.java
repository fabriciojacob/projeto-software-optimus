package br.com.softwareOptimus.fiscal;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbVigencia")
public class Vigencia {
	
	@Id
	@GeneratedValue
	private Long idVigencia;
	
	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	@ManyToOne
	private Aliquota aliquota;
	
	@ManyToOne
	private CodTabelaGov codTabelaGov;
	
	public CodTabelaGov getCodTabelaGov() {
		return codTabelaGov;
	}
	
	public void setCodTabelaGov(CodTabelaGov codTabelaGov) {
		this.codTabelaGov = codTabelaGov;
	}
	
	public Aliquota getAliquota() {
		return aliquota;
	}
	
	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
	}
	
	public Date getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Long getIdVigencia() {
		return idVigencia;
	}

	public void setIdVigencia(Long idVigencia) {
		this.idVigencia = idVigencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idVigencia == null) ? 0 : idVigencia.hashCode());
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
		Vigencia other = (Vigencia) obj;
		if (idVigencia == null) {
			if (other.idVigencia != null)
				return false;
		} else if (!idVigencia.equals(other.idVigencia))
			return false;
		return true;
	}
	
}
