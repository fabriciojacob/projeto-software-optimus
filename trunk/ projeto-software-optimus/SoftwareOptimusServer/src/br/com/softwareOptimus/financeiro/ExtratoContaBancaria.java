package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbExtratoConta")
public class ExtratoContaBancaria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5462788220273491142L;

	@Id
	@GeneratedValue
	private Long idExtratoC;
	
	@ManyToOne
	private ContaBancaria contaBancaria;
	
	@ManyToMany
	private Collection<Titulo> titulo;
	
	private String descricao;
	
	private Double debito;
	
	private Double credito;
	
	private Double saldo;
	
	private Rubrica rubrica;
	
	public Collection<Titulo> getTitulo() {
		return titulo;
	}
	
	public void setTitulo(Collection<Titulo> titulo) {
		this.titulo = titulo;
	}

	public Long getIdExtratoC() {
		return idExtratoC;
	}

	public void setIdExtratoC(Long idExtratoC) {
		this.idExtratoC = idExtratoC;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idExtratoC == null) ? 0 : idExtratoC.hashCode());
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
		ExtratoContaBancaria other = (ExtratoContaBancaria) obj;
		if (idExtratoC == null) {
			if (other.idExtratoC != null)
				return false;
		} else if (!idExtratoC.equals(other.idExtratoC))
			return false;
		return true;
	}
	
}
