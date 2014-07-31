package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbPautaMVA")
public class PautaMVA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2344969112674156548L;
	
	@Id
	@GeneratedValue
	private Long idPautaMVA;
	
	private String descricao;
	
	private Double valorPauta;
	
	private Double valorMVa;
	
	private Date vigencia;
	
	private boolean nincideDesconto;
	
	private boolean incideIPI;
	
	private boolean mvaAjustada;

	public Long getIdPautaMVA() {
		return idPautaMVA;
	}

	public void setIdPautaMVA(Long idPautaMVA) {
		this.idPautaMVA = idPautaMVA;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorPauta() {
		return valorPauta;
	}

	public void setValorPauta(Double valorPauta) {
		this.valorPauta = valorPauta;
	}

	public Double getValorMVa() {
		return valorMVa;
	}

	public void setValorMVa(Double valorMVa) {
		this.valorMVa = valorMVa;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public boolean isNincideDesconto() {
		return nincideDesconto;
	}

	public void setNincideDesconto(boolean nincideDesconto) {
		this.nincideDesconto = nincideDesconto;
	}

	public boolean isIncideIPI() {
		return incideIPI;
	}

	public void setIncideIPI(boolean incideIPI) {
		this.incideIPI = incideIPI;
	}

	public boolean isMvaAjustada() {
		return mvaAjustada;
	}

	public void setMvaAjustada(boolean mvaAjustada) {
		this.mvaAjustada = mvaAjustada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPautaMVA == null) ? 0 : idPautaMVA.hashCode());
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
		PautaMVA other = (PautaMVA) obj;
		if (idPautaMVA == null) {
			if (other.idPautaMVA != null)
				return false;
		} else if (!idPautaMVA.equals(other.idPautaMVA))
			return false;
		return true;
	}

}
