package br.com.softwareOptimus.fiscal;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbCST")
@Cacheable(true)
public class CodigoSituacaoTributaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5231539704225409903L;

	@Id
	@GeneratedValue
	private Long idCst;
	
	@Column (length = 350, nullable = true , unique = false)
	private String descricao;
	
	private IO io;
	
	private String cst;
	
	private TipoCst tipoCst;
	
	public Long getIdCst() {
		return idCst;
	}

	public void setIdCst(Long idCst) {
		this.idCst = idCst;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}

	public TipoCst getTipoCst() {
		return tipoCst;
	}
	
	public void setTipoCst(TipoCst tipoCst) {
		this.tipoCst = tipoCst;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCst == null) ? 0 : idCst.hashCode());
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
		CodigoSituacaoTributaria other = (CodigoSituacaoTributaria) obj;
		if (idCst == null) {
			if (other.idCst != null)
				return false;
		} else if (!idCst.equals(other.idCst))
			return false;
		return true;
	}
}
