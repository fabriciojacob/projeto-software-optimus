package br.com.softwareOptimus.contabilidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;

@Entity
@Table(name = "tbLancContabil")
public class LancContabil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4448061938693248231L;

	@Id
	@GeneratedValue
	private Long idLanc;
	
	@Temporal(TemporalType.DATE)
	private Calendar DatLanc;
	
	@ManyToOne
	private Pessoa Empresa;
	
	@OneToOne
	private PlanoDeContas credito;
	
	@OneToOne
	private PlanoDeContas debito;
	
	private Double valorPagamento;
	
	private String historico;

	public Long getIdLanc() {
		return idLanc;
	}

	public void setIdLanc(Long idLanc) {
		this.idLanc = idLanc;
	}

	public Calendar getDatLanc() {
		return DatLanc;
	}

	public void setDatLanc(Calendar datLanc) {
		DatLanc = datLanc;
	}

	public PlanoDeContas getCredito() {
		return credito;
	}

	public void setCredito(PlanoDeContas credito) {
		this.credito = credito;
	}

	public PlanoDeContas getDebito() {
		return debito;
	}

	public void setDebito(PlanoDeContas debito) {
		this.debito = debito;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLanc == null) ? 0 : idLanc.hashCode());
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
		LancContabil other = (LancContabil) obj;
		if (idLanc == null) {
			if (other.idLanc != null)
				return false;
		} else if (!idLanc.equals(other.idLanc))
			return false;
		return true;
	}	
}
