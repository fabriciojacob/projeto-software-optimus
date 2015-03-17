package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbMovCaixa")
public class MovCaixa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1874928219925019439L;

	@Id
	@GeneratedValue
	private Long idMovCaixa;
	
	private Double debito;
	
	private Double credito;
	
	private Double saldo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataMovimentacao;
	
	private TipoMov tipoMov;
	
	@ManyToOne
	private Caixa caixa;

	public Double getDebito() {
		return debito;
	}

	public void setDebito(Double debito) {
		this.debito = debito;
	}

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public TipoMov getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(TipoMov tipoMov) {
		this.tipoMov = tipoMov;
	}

	public Long getIdMovCaixa() {
		return idMovCaixa;
	}

	public void setIdMovCaixa(Long idMovCaixa) {
		this.idMovCaixa = idMovCaixa;
	}
	
	public Caixa getCaixa() {
		return caixa;
	}
	
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMovCaixa == null) ? 0 : idMovCaixa.hashCode());
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
		MovCaixa other = (MovCaixa) obj;
		if (idMovCaixa == null) {
			if (other.idMovCaixa != null)
				return false;
		} else if (!idMovCaixa.equals(other.idMovCaixa))
			return false;
		return true;
	}

}
