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

import br.com.softwareOptimus.entidades.PessoaJuridica;

@Entity
@Table(name="tbVigReg")
public class VigenciaRegime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 366956717504428997L;
	
	@GeneratedValue
	@Id
	private Long idVigReg;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	private Regime regime;
	
	@ManyToOne
	private PessoaJuridica pessaoJuridica;
	
	public PessoaJuridica getPessaoJuridica() {
		return pessaoJuridica;
	}
	
	public void setPessaoJuridica(PessoaJuridica pessaoJuridica) {
		this.pessaoJuridica = pessaoJuridica;
	}

	public Long getIdVigReg() {
		return idVigReg;
	}

	public void setIdVigReg(Long idVigReg) {
		this.idVigReg = idVigReg;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idVigReg == null) ? 0 : idVigReg.hashCode());
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
		VigenciaRegime other = (VigenciaRegime) obj;
		if (idVigReg == null) {
			if (other.idVigReg != null)
				return false;
		} else if (!idVigReg.equals(other.idVigReg))
			return false;
		return true;
	}
}
