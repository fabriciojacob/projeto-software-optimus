package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbCaixa")
public class Caixa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1874928219925019439L;

	@Id
	@GeneratedValue
	private Long idCaixa;
	
	private Double valor;
	
	private String descricao;
	
	private Double saldo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataMovimentacao;
	
	private TipoMov tipoMov;
	
	@OneToMany(mappedBy = "caixa")
	private Collection<Titulo> contas;
	
	public Collection<Titulo> getContas() {
		return contas;
	}
	
	public void setContas(Collection<Titulo> contas) {
		this.contas = contas;
	}

	public Long getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCaixa == null) ? 0 : idCaixa.hashCode());
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
		Caixa other = (Caixa) obj;
		if (idCaixa == null) {
			if (other.idCaixa != null)
				return false;
		} else if (!idCaixa.equals(other.idCaixa))
			return false;
		return true;
	}
	
}
