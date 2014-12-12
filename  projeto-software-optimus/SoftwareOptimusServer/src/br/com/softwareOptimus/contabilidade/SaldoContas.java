package br.com.softwareOptimus.contabilidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false, foreignKey = @ForeignKey(name = "fk_tbPessoa5"))
	private Pessoa empresa;
	
	@ManyToOne
	@JoinColumn(name = "redutor", nullable = false, foreignKey = @ForeignKey(name = "fk_tbPlanoDeContas"))
	private PlanoDeContas redutor;
	
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


	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public PlanoDeContas getRedutor() {
		return redutor;
	}

	public void setRedutor(PlanoDeContas redutor) {
		this.redutor = redutor;
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
