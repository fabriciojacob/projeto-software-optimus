package br.com.softwareOptimus.contabilidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;


@Entity
@Table(name = "tbSaldoContas")
public class SaldoContas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8557402594564268757L;
	
	@Id
	@GeneratedValue
	private Long idSaldoContas;
	
	@Temporal(TemporalType.DATE)
	private Calendar datSaldo;
	
	@ManyToMany
	private Collection<Pessoa> empresa;
	
	private Double saldoInicial;
	
	private Double totDebito;
	
	private Double totCredito;
	
	private Double saldoFinas;

	public Long getIdSaldoContas() {
		return idSaldoContas;
	}

	public void setIdSaldoContas(Long idSaldoContas) {
		this.idSaldoContas = idSaldoContas;
	}

	public Calendar getDatSaldo() {
		return datSaldo;
	}

	public void setDatSaldo(Calendar datSaldo) {
		this.datSaldo = datSaldo;
	}

	public Collection<Pessoa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Collection<Pessoa> empresa) {
		this.empresa = empresa;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Double getTotDebito() {
		return totDebito;
	}

	public void setTotDebito(Double totDebito) {
		this.totDebito = totDebito;
	}

	public Double getTotCredito() {
		return totCredito;
	}

	public void setTotCredito(Double totCredito) {
		this.totCredito = totCredito;
	}

	public Double getSaldoFinas() {
		return saldoFinas;
	}

	public void setSaldoFinas(Double saldoFinas) {
		this.saldoFinas = saldoFinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSaldoContas == null) ? 0 : idSaldoContas.hashCode());
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
		SaldoContas other = (SaldoContas) obj;
		if (idSaldoContas == null) {
			if (other.idSaldoContas != null)
				return false;
		} else if (!idSaldoContas.equals(other.idSaldoContas))
			return false;
		return true;
	}
}
