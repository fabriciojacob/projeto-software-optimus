package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.softwareOptimus.fiscal.CodigoFiscalOperacao;


@Entity
@Table(name = "tbComFiscais")
public class ComercialFiscais implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 120415955901075873L;

	@Id
	@GeneratedValue
	private Long idComFiscais;
	
	@ManyToOne
	private Comercial Comercial;

	private Double valOper;
	
	@ManyToMany
	private Collection<CodigoFiscalOperacao> cfop;
	
	private Double valBcIcms;
	
	private Double valIcms;
	
	private Double valBcIcmsSt;
	
	private Double valIcmsSt;
	
	private Double valRedBc;

	public Long getIdComFiscais() {
		return idComFiscais;
	}

	public void setIdComFiscais(Long idComFiscais) {
		this.idComFiscais = idComFiscais;
	}

	public Comercial getComercial() {
		return Comercial;
	}

	public void setComercial(Comercial comercial) {
		Comercial = comercial;
	}

	public Double getValOper() {
		return valOper;
	}

	public void setValOper(Double valOper) {
		this.valOper = valOper;
	}

	public Collection<CodigoFiscalOperacao> getCfop() {
		return cfop;
	}

	public void setCfop(Collection<CodigoFiscalOperacao> cfop) {
		this.cfop = cfop;
	}

	public Double getValBcIcms() {
		return valBcIcms;
	}

	public void setValBcIcms(Double valBcIcms) {
		this.valBcIcms = valBcIcms;
	}

	public Double getValIcms() {
		return valIcms;
	}

	public void setValIcms(Double valIcms) {
		this.valIcms = valIcms;
	}

	public Double getValBcIcmsSt() {
		return valBcIcmsSt;
	}

	public void setValBcIcmsSt(Double valBcIcmsSt) {
		this.valBcIcmsSt = valBcIcmsSt;
	}

	public Double getValIcmsSt() {
		return valIcmsSt;
	}

	public void setValIcmsSt(Double valIcmsSt) {
		this.valIcmsSt = valIcmsSt;
	}

	public Double getValRedBc() {
		return valRedBc;
	}

	public void setValRedBc(Double valRedBc) {
		this.valRedBc = valRedBc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComFiscais == null) ? 0 : idComFiscais.hashCode());
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
		ComercialFiscais other = (ComercialFiscais) obj;
		if (idComFiscais == null) {
			if (other.idComFiscais != null)
				return false;
		} else if (!idComFiscais.equals(other.idComFiscais))
			return false;
		return true;
	}
}
