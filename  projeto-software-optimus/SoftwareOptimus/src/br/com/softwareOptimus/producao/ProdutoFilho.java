package br.com.softwareOptimus.producao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import softwareOptimus.com.produto.Produto;


@Entity
@Table(name="tbProdFilho")
public class ProdutoFilho implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8760652249314940621L;
	
	@Id
	@GeneratedValue
	private Long idProdFilho;
	
	@ManyToOne
	private ProdutoPrincipal prodPrinc;
	
	@OneToOne
	private Produto produto;
	
	private Double quantidade;
	
	private Double custo;
	
	private Double custoTotal;

	public Long getIdProdFilho() {
		return idProdFilho;
	}

	public void setIdProdFilho(Long idProdFilho) {
		this.idProdFilho = idProdFilho;
	}

	public ProdutoPrincipal getProdPrinc() {
		return prodPrinc;
	}

	public void setProdPrinc(ProdutoPrincipal prodPrinc) {
		this.prodPrinc = prodPrinc;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProdFilho == null) ? 0 : idProdFilho.hashCode());
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
		ProdutoFilho other = (ProdutoFilho) obj;
		if (idProdFilho == null) {
			if (other.idProdFilho != null)
				return false;
		} else if (!idProdFilho.equals(other.idProdFilho))
			return false;
		return true;
	}
	
}
