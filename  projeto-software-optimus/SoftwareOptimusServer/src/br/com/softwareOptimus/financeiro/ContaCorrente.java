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
@Table(name="tbContaCorrente")
public class ContaCorrente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019705617083682594L;
	
	@Id
	@GeneratedValue
	private Long idContaCorrente;
	
	@ManyToOne
	private Banco banco;
	
	private Integer agencia;
	
	private Integer conta;
	
	@OneToMany(mappedBy = "contaCorrente")
	private Collection<ExtratoContaCorrente> extrato;
	
	public Collection<ExtratoContaCorrente> getExtrato() {
		return extrato;
	}
	
	public void setExtrato(Collection<ExtratoContaCorrente> extrato) {
		this.extrato = extrato;
	}

	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idContaCorrente == null) ? 0 : idContaCorrente.hashCode());
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
		ContaCorrente other = (ContaCorrente) obj;
		if (idContaCorrente == null) {
			if (other.idContaCorrente != null)
				return false;
		} else if (!idContaCorrente.equals(other.idContaCorrente))
			return false;
		return true;
	}
	
}
