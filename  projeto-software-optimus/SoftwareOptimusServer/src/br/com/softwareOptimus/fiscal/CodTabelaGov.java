package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbCodTableGov")
public class CodTabelaGov implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6034220377137298602L;

	@Id
	@GeneratedValue
	private Long idCodGov;

	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	@ManyToOne
	private TipoProduto tipoProduto;
	
	@ManyToOne
	private Ncm ncm;
	
	@ManyToOne
	private Aliquota entradaPis;
	
	@ManyToOne
	private Aliquota entradaCofins;
	
	@ManyToOne
	private Aliquota saidaPis;
	
	@ManyToOne
	private Aliquota saidaCofins;
	
	//Campo 7 - 0200 valores fixos
	private String tipoItem;
	
	@ManyToOne
	private Aliquota aliquotaIpi;
		
	public Aliquota getAliquotaIpi() {
		return aliquotaIpi;
	}

	public void setAliquotaIpi(Aliquota aliquotaIpi) {
		this.aliquotaIpi = aliquotaIpi;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Ncm getNcm() {
		return ncm;
	}

	public void setNcm(Ncm ncm) {
		this.ncm = ncm;
	}

	public Aliquota getEntradaPis() {
		return entradaPis;
	}

	public void setEntradaPis(Aliquota entradaPis) {
		this.entradaPis = entradaPis;
	}

	public Aliquota getEntradaCofins() {
		return entradaCofins;
	}

	public void setEntradaCofins(Aliquota entradaCofins) {
		this.entradaCofins = entradaCofins;
	}

	public Aliquota getSaidaPis() {
		return saidaPis;
	}

	public void setSaidaPis(Aliquota saidaPis) {
		this.saidaPis = saidaPis;
	}

	public Aliquota getSaidaCofins() {
		return saidaCofins;
	}

	public void setSaidaCofins(Aliquota saidaCofins) {
		this.saidaCofins = saidaCofins;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Long getIdCodGov() {
		return idCodGov;
	}

	public void setIdCodGov(Long idCodGov) {
		this.idCodGov = idCodGov;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoProd) {
		this.tipoItem = tipoProd;
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
