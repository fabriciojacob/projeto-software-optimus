package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbContaBancaria")
public class ContaBancaria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019705617083682594L;
	
	@Id
	@GeneratedValue
	private Long idContaBancaria;
	
	@ManyToOne
	private Banco banco;
	
	private Integer agencia;
	
	private Integer conta;
	
	@OneToMany(mappedBy = "contaBancaria")
	private Collection<ExtratoContaBancaria> extrato;
	
	public Collection<ExtratoContaBancaria> getExtrato() {
		return extrato;
	}
	
	public void setExtrato(Collection<ExtratoContaBancaria> extrato) {
		this.extrato = extrato;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Long getIdContaBancaria() {
		return idContaBancaria;
	}

	public void setIdContaBancaria(Long idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idContaBancaria == null) ? 0 : idContaBancaria.hashCode());
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
		ContaBancaria other = (ContaBancaria) obj;
		if (idContaBancaria == null) {
			if (other.idContaBancaria != null)
				return false;
		} else if (!idContaBancaria.equals(other.idContaBancaria))
			return false;
		return true;
	}
	
}
