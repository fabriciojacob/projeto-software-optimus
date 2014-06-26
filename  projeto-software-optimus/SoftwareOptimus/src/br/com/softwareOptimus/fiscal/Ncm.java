package br.com.softwareOptimus.fiscal;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbNCM")
public class Ncm {
	
	@Id
	private Long idNcm;
	
	@Column ( length = 10 , nullable = true , unique = false)
	private String ncm;
	
	@Column ( length = 85 , nullable = true , unique = false)
	private String descricao;
	
	@OneToOne
	private Aliquota aliquota;
	
	@ManyToMany
	private Collection<Vigencia> vigencia;
	
	public Collection<Vigencia> getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(Collection<Vigencia> vigencia) {
		this.vigencia = vigencia;
	}
	
	public Aliquota getAliquota() {
		return aliquota;
	}
	
	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
	}
	
	public Long getIdNcm() {
		return idNcm;
	}

	public void setIdNcm(Long idNcm) {
		this.idNcm = idNcm;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idNcm == null) ? 0 : idNcm.hashCode());
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
		Ncm other = (Ncm) obj;
		if (idNcm == null) {
			if (other.idNcm != null)
				return false;
		} else if (!idNcm.equals(other.idNcm))
			return false;
		return true;
	}
	

}
