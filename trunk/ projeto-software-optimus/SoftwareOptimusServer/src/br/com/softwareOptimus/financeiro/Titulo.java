package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbTitulo")
public class Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6269276424422686896L;
	
	@Id
	@GeneratedValue
	private Long idTitulo;
	
	private String descricao;
	
	@ManyToMany
	private Collection<FormaPgto> formaPgto;
	
	@ManyToOne
	private CondPgto condPgto;
	
	private Double valor;
	
	private Double saldo;
	
	private boolean previsao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;
	
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	private StatusConta status;
	
	private TipoBaixa tipoBaixa;
	
	@ManyToOne
	private MovCaixa caixa;
	
	@ManyToOne
	private Conta conta;
	
	public MovCaixa getCaixa() {
		return caixa;
	}
	
	public void setCaixa(MovCaixa caixa) {
		this.caixa = caixa;
	}
	
	public TipoBaixa getTipoBaixa() {
		return tipoBaixa;
	}
	
	public void setTipoBaixa(TipoBaixa tipoBaixa) {
		this.tipoBaixa = tipoBaixa;
	}
	
	public Calendar getVencimento() {
		return vencimento;
	}
	
	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public StatusConta getStatus() {
		return status;
	}
	
	public void setStatus(StatusConta status) {
		this.status = status;
	}

	public Long getIdTitulo() {
		return idTitulo;
	}

	public void setIdConta(Long idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<FormaPgto> getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(Collection<FormaPgto> formaPgto) {
		this.formaPgto = formaPgto;
	}

	public CondPgto getCondPgto() {
		return condPgto;
	}

	public void setCondPgto(CondPgto condPgto) {
		this.condPgto = condPgto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public boolean isPrevisao() {
		return previsao;
	}

	public void setPrevisao(boolean previsao) {
		this.previsao = previsao;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTitulo == null) ? 0 : idTitulo.hashCode());
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
		Titulo other = (Titulo) obj;
		if (idTitulo == null) {
			if (other.idTitulo != null)
				return false;
		} else if (!idTitulo.equals(other.idTitulo))
			return false;
		return true;
	}

}
