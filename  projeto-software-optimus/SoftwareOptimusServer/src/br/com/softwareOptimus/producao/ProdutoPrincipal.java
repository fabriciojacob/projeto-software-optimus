package br.com.softwareOptimus.producao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.softwareOptimus.com.produto.Produto;



@Entity
@Table(name="tbProdutoPrin")
public class ProdutoPrincipal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -152762177003514362L;
	
	@Id
	@GeneratedValue
	private Long idProdP;
	
	@OneToOne
	private Produto produto;
	
	@OneToMany(mappedBy = "prodPrinc")
	private Collection<ProdutoFilho> prodFilho;

	private Double qtaTotal;

	private Double custoTotal;
	
	private String observacao;
	
	public Collection<ProdutoFilho> getProdFilho() {
		return prodFilho;
	}
	
	public void setProdFilho(Collection<ProdutoFilho> prodFilho) {
		this.prodFilho = prodFilho;
	}

	public Long getIdProdP() {
		return idProdP;
	}

	public void setIdProdP(Long idProdP) {
		this.idProdP = idProdP;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQtaTotal() {
		return qtaTotal;
	}

	public void setQtaTotal(Double qtaTotal) {
		this.qtaTotal = qtaTotal;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProdP == null) ? 0 : idProdP.hashCode());
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
		ProdutoPrincipal other = (ProdutoPrincipal) obj;
		if (idProdP == null) {
			if (other.idProdP != null)
				return false;
		} else if (!idProdP.equals(other.idProdP))
			return false;
		return true;
	}

}
