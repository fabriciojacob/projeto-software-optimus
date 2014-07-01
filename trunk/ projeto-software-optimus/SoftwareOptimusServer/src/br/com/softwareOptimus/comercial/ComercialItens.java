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
import br.com.softwareOptimus.produto.Produto;



@Entity
@Table(name = "tbComItens")
public class ComercialItens implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9214226807254727909L;

	@Id
	@GeneratedValue
	private Long idComItens;
	
	@ManyToOne
	private Comercial Comercial;
	
	@ManyToMany
	private Collection<Produto> produto;
	
	private Double quant;
	
	private Double valItem;
	
	private Double valDesc;
	
	@ManyToMany
	private Collection<CodigoFiscalOperacao> cfop;
	
	private Double valBcIcms;
	
	private Double valIcms;
	
	private Double valBcIcmsSt;
	
	private Double valIcmsSt;
	
	private Double valBcIpi;
	
	private Double valIpi;
	
	private Double valBcPis;
	
	private Double valPis;
	
	private Double valBcCofins;
	
	private Double valCofins;

	public Long getIdComItens() {
		return idComItens;
	}

	public void setIdComItens(Long idComItens) {
		this.idComItens = idComItens;
	}

	public Comercial getComercial() {
		return Comercial;
	}

	public void setComercial(Comercial Comercial) {
		this.Comercial = Comercial;
	}

	public Collection<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Collection<Produto> produto) {
		this.produto = produto;
	}

	public Double getQuant() {
		return quant;
	}

	public void setQuant(Double quant) {
		this.quant = quant;
	}

	public Double getValItem() {
		return valItem;
	}

	public void setValItem(Double valItem) {
		this.valItem = valItem;
	}

	public Double getValDesc() {
		return valDesc;
	}

	public void setValDesc(Double valDesc) {
		this.valDesc = valDesc;
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

	public Double getValBcIpi() {
		return valBcIpi;
	}

	public void setValBcIpi(Double valBcIpi) {
		this.valBcIpi = valBcIpi;
	}

	public Double getValIpi() {
		return valIpi;
	}

	public void setValIpi(Double valIpi) {
		this.valIpi = valIpi;
	}

	public Double getValBcPis() {
		return valBcPis;
	}

	public void setValBcPis(Double valBcPis) {
		this.valBcPis = valBcPis;
	}

	public Double getValPis() {
		return valPis;
	}

	public void setValPis(Double valPis) {
		this.valPis = valPis;
	}

	public Double getValBcCofins() {
		return valBcCofins;
	}

	public void setValBcCofins(Double valBcCofins) {
		this.valBcCofins = valBcCofins;
	}

	public Double getValCofins() {
		return valCofins;
	}

	public void setValCofins(Double valCofins) {
		this.valCofins = valCofins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComItens == null) ? 0 : idComItens.hashCode());
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
		ComercialItens other = (ComercialItens) obj;
		if (idComItens == null) {
			if (other.idComItens != null)
				return false;
		} else if (!idComItens.equals(other.idComItens))
			return false;
		return true;
	}

	
}
