package br.com.softwareOptimus.fiscal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbNCM")
public class Ncm {
	
	@Id
	private Long idNcm;
	
	@Column ( length = 10 , nullable = true , unique = false)
	private String ncm;
	
	@Column (length = 85 , nullable = true , unique = false)
	private String descricaoNcm;
	
	@Column ( length = 3 , nullable = true , unique = false)
	private String natRec;
	
	@Column (length = 85 , nullable = true , unique = false)
	private String descNatRec;
	
	//Com Isenção, Com Suspencao etc
	@Column (length = 85 , nullable = true , unique = false)
	private String descTabela;
	
	public String getNatRec() {
		return natRec;
	}

	public void setNatRec(String natRec) {
		this.natRec = natRec;
	}

	public String getDescNatRec() {
		return descNatRec;
	}

	public void setDescNatRec(String descNatRec) {
		this.descNatRec = descNatRec;
	}

	public String getDescTabela() {
		return descTabela;
	}

	public void setDescTabela(String descTabela) {
		this.descTabela = descTabela;
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

	public String getDescricaoNcm() {
		return descricaoNcm;
	}

	public void setDescricaoNcm(String descricaoNcm) {
		this.descricaoNcm = descricaoNcm;
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
