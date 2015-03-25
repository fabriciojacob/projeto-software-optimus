package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbExtrato")
public class Extrato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5462788220273491142L;

	@Id
	@GeneratedValue
	private Long idExtrato;
	
	@ManyToOne
	private ContaBancaria contaBancaria;
	
	@ManyToOne
	private Caixa caixa;
	
	@ManyToOne
	private Titulo titulo;
	
	private String descricao;
	
	private Double debito;
	
	private Double credito;
	
	private Double saldo;
	
	private Rubrica rubrica;
	
	private Date data;
	
	public Titulo getTitulo() {
		return titulo;
	}
	
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Long getIdExtrato() {
		return idExtrato;
	}

	public void setIdExtratoC(Long idExtrato) {
		this.idExtrato = idExtrato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

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
	

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idExtrato == null) ? 0 : idExtrato.hashCode());
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
		Extrato other = (Extrato) obj;
		if (idExtrato == null) {
			if (other.idExtrato != null)
				return false;
		} else if (!idExtrato.equals(other.idExtrato))
			return false;
		return true;
	}
	
}
