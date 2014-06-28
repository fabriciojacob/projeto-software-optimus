package br.com.softwareOptimus.fiscal;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbCodTableGov")
public class CodTabelaGov {
	
	@Id
	@GeneratedValue
	private Long idCodGov;
	
	private Integer natRec;
	
	private Integer codGov;
	
	@OneToMany(mappedBy = "codTabelaGov")
	private Collection<Vigencia> vigencia;
	
	public Collection<Vigencia> getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(Collection<Vigencia> vigencia) {
		this.vigencia = vigencia;
	}
	
	public Integer getNatRec() {
		return natRec;
	}
	
	public void setNatRec(Integer natRec) {
		this.natRec = natRec;
	}
	
	public Integer getCodGov() {
		return codGov;
	}
	
	public void setCodGov(Integer codGov) {
		this.codGov = codGov;
	}

	public Long getIdCodGov() {
		return idCodGov;
	}

	public void setIdCodGov(Long idCodGov) {
		this.idCodGov = idCodGov;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCodGov == null) ? 0 : idCodGov.hashCode());
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
		CodTabelaGov other = (CodTabelaGov) obj;
		if (idCodGov == null) {
			if (other.idCodGov != null)
				return false;
		} else if (!idCodGov.equals(other.idCodGov))
			return false;
		return true;
	}

}
