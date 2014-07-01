package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.softwareOptimus.produto.Produto;



@Entity
@Table(name = "tbPedidoComItens")
public class PedidoComItens implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9004747997832063290L;

	@Id
	@GeneratedValue
	private Long idPedidoComItens;
	
	@ManyToOne
	private PedidoCompra PedidoCom;
	
	@ManyToMany
	private Collection<Produto> produto;
	
	private Double custProd;
	
	private Double quant;
	
	private Double valorProd;
	
	private Double valortotal;

	public Long getIdPedidoComItens() {
		return idPedidoComItens;
	}

	public void setIdPedidoComItens(Long idPedidoComItens) {
		this.idPedidoComItens = idPedidoComItens;
	}

	public PedidoCompra getIdPedidoCom() {
		return PedidoCom;
	}

	public void setIdPedidoCom(PedidoCompra idPedidoCom) {
		this.PedidoCom = idPedidoCom;
	}

	public Collection<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Collection<Produto> produto) {
		this.produto = produto;
	}

	public Double getCustProd() {
		return custProd;
	}

	public void setCustProd(Double custProd) {
		this.custProd = custProd;
	}

	public Double getQuant() {
		return quant;
	}

	public void setQuant(Double quant) {
		this.quant = quant;
	}

	public Double getValorProd() {
		return valorProd;
	}

	public void setValorProd(Double valorProd) {
		this.valorProd = valorProd;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idPedidoComItens == null) ? 0 : idPedidoComItens.hashCode());
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
		PedidoComItens other = (PedidoComItens) obj;
		if (idPedidoComItens == null) {
			if (other.idPedidoComItens != null)
				return false;
		} else if (!idPedidoComItens.equals(other.idPedidoComItens))
			return false;
		return true;
	}
}
