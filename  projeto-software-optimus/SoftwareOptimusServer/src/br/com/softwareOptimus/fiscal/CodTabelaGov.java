package br.com.softwareOptimus.fiscal;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbCodTableGov")
public class CodTabelaGov {

	@Id
	@GeneratedValue
	private Long idCodGov;

	private Integer natRec;

	private Integer codGov;

	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	@OneToOne
	private Ncm ncm;
	
	@OneToOne
	private Aliquota entradaPis;
	
	@OneToOne
	private Aliquota entradaCofins;
	
	@OneToOne
	private Aliquota saidaPis;
	
	@OneToOne
	private Aliquota saidaCofins;
	
	@OneToOne
	private CodigoSituacaoTributaria cstPisEntrada;
	
	@OneToOne
	private CodigoSituacaoTributaria cstCofinsEntrada;
	
	@OneToOne
	private CodigoSituacaoTributaria cstPisSaida;
	
	@OneToOne
	private CodigoSituacaoTributaria cstCofinsSaida;
	
	public CodigoSituacaoTributaria getCstPisEntrada() {
		return cstPisEntrada;
	}

	public void setCstPisEntrada(CodigoSituacaoTributaria cstPisEntrada) {
		this.cstPisEntrada = cstPisEntrada;
	}

	public CodigoSituacaoTributaria getCstCofinsEntrada() {
		return cstCofinsEntrada;
	}

	public void setCstCofinsEntrada(CodigoSituacaoTributaria cstCofinsEntrada) {
		this.cstCofinsEntrada = cstCofinsEntrada;
	}

	public CodigoSituacaoTributaria getCstPisSaida() {
		return cstPisSaida;
	}

	public void setCstPisSaida(CodigoSituacaoTributaria cstPisSaida) {
		this.cstPisSaida = cstPisSaida;
	}

	public CodigoSituacaoTributaria getCstCofinsSaida() {
		return cstCofinsSaida;
	}

	public void setCstCofinsSaida(CodigoSituacaoTributaria cstCofinsSaida) {
		this.cstCofinsSaida = cstCofinsSaida;
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

	@ManyToOne
	private TipoProduto tipoProd;

	public TipoProduto getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(TipoProduto tipoProd) {
		this.tipoProd = tipoProd;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
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
