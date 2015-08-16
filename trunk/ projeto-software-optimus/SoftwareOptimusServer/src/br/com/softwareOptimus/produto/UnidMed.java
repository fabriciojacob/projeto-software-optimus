package br.com.softwareOptimus.produto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbUnidMed")
public class UnidMed implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2430645560981273774L;

	@Id
	@GeneratedValue
	private Long idUnidMed;
	
	private String unid;
	
	private String descUnid;
	
	@OneToMany(mappedBy = "unidMed")
	private Collection<Produto> produtos;
	
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getIdUnidMed() {
		return idUnidMed;
	}

	public void setIdUnidMed(Long idUnidMed) {
		this.idUnidMed = idUnidMed;
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getDescUnid() {
		return descUnid;
	}

	public void setDescUnid(String descUnid) {
		this.descUnid = descUnid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUnidMed == null) ? 0 : idUnidMed.hashCode());
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
		UnidMed other = (UnidMed) obj;
		if (idUnidMed == null) {
			if (other.idUnidMed != null)
				return false;
		} else if (!idUnidMed.equals(other.idUnidMed))
			return false;
		return true;
	}

}
