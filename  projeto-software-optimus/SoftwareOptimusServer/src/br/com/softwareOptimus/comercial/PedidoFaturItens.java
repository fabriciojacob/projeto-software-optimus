package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.softwareOptimus.com.produto.Produto;



@Entity
@Table(name= "tbPedFaturItens")
public class PedidoFaturItens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1648365313792096597L;

	@Id
	@GeneratedValue
	private Long idPedFatuItens;
	
	@ManyToOne
	private PedidoFatur PedidoFatur;
	
	@ManyToMany
	private Collection<Produto> produto;
	
	private Double custProd;
	
	private Double quant;
	
	private Double valorProd;
	
	private Double valortotal;

	public Long getIdPedFatuItens() {
		return idPedFatuItens;
	}

	public void setIdPedFatuItens(Long idPedFatuItens) {
		this.idPedFatuItens = idPedFatuItens;
	}

	public PedidoFatur getIdPedidoFatur() {
		return PedidoFatur;
	}

	public void setIdPedidoFatur(PedidoFatur idPedidoFatur) {
		this.PedidoFatur = idPedidoFatur;
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
		result = prime * result
				+ ((idPedFatuItens == null) ? 0 : idPedFatuItens.hashCode());
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
		PedidoFaturItens other = (PedidoFaturItens) obj;
		if (idPedFatuItens == null) {
			if (other.idPedFatuItens != null)
				return false;
		} else if (!idPedFatuItens.equals(other.idPedFatuItens))
			return false;
		return true;
	}
}
