package br.com.softwareOptimus.estoque;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.TipoMovEst;

import softwareOptimus.com.produto.Produto;


@Entity
@Table(name="tbProdutoEstoque")
public class ProdutoEstoque implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8068048083550391041L;

	@Id
	@GeneratedValue
	private Long idProdEst;
	
	private Double quantidade;
	
	private Double quantSaida;
	
	private Double quantEntrada;
	
	private Double saldo;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private Double custoMedio;
	
	private Double totalCusto;
	
	private TipoMovEst tipoMovEst;
	
	@OneToOne
	private Produto produto;
	
	private String justificativa;
	
	public TipoMovEst getTipoMovEst() {
		return tipoMovEst;
	}
	
	public void setTipoMovEst(TipoMovEst tipoMovEst) {
		this.tipoMovEst = tipoMovEst;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getJustificativa() {
		return justificativa;
	}
	
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Long getIdProdEst() {
		return idProdEst;
	}

	public void setIdProdEst(Long idProdEst) {
		this.idProdEst = idProdEst;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQuantSaida() {
		return quantSaida;
	}

	public void setQuantSaida(Double quantSaida) {
		this.quantSaida = quantSaida;
	}

	public Double getQuantEntrada() {
		return quantEntrada;
	}

	public void setQuantEntrada(Double quantEntrada) {
		this.quantEntrada = quantEntrada;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo() {
		this.saldo = this.quantidade +  this.quantEntrada - this.quantSaida;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProdEst == null) ? 0 : idProdEst.hashCode());
		return result;
	}
	
	public Double getTotalCusto() {
		return totalCusto;
	}
	
	public void setTotalCusto(Double totalCusto) {
		this.totalCusto = totalCusto;
	}
	
	public void setCustoMedio(TipoMovEst tipo) {
		if(tipoMovEst.COMPRA.equals(tipo.COMPRA) && this.saldo <= 0){
			this.custoMedio = this.totalCusto / (this.quantEntrada + this.saldo);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEstoque other = (ProdutoEstoque) obj;
		if (idProdEst == null) {
			if (other.idProdEst != null)
				return false;
		} else if (!idProdEst.equals(other.idProdEst))
			return false;
		return true;
	}
	
}
