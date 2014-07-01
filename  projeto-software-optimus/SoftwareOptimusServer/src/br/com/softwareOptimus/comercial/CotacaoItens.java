
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
import br.com.softwareOptimus.produto.UnidMed;



@Entity
@Table(name = "TbCotacaoItens")
public class CotacaoItens implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8320510453689458822L;

	@Id
	@GeneratedValue
	private Long idCotacaoItens;
	
	@ManyToOne
	private Cotacao cotacao;
	
	@ManyToMany
	private Collection<Produto> produto;
	
	private Double custProd;
	
	private Double quantCot;
	
	private Double valTotProd;
	//0-não comprado, 1-comprado
	private int itemComprado;
	
	@ManyToMany
	private Collection<UnidMed> unidade;
	
	private Double salFinal;

	public Long getIdCotacaoItens() {
		return idCotacaoItens;
	}

	public void setIdCotacaoItens(Long idCotacaoItens) {
		this.idCotacaoItens = idCotacaoItens;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao Cotacao) {
		this.cotacao = Cotacao;
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
	
	public Double getQuantCot() {
		return quantCot;
	}

	public void setQuantCot(Double quantCot) {
		this.quantCot = quantCot;
	}

	public int getItemComprado() {
		return itemComprado;
	}

	public void setItemComprado(int itemComprado) {
		this.itemComprado = itemComprado;
	}

	public void setCustProd(Double custProd) {
		this.custProd = custProd;
	}

	public Double getQuant() {
		return quantCot;
	}

	public void setQuant(Double quant) {
		this.quantCot = quant;
	}

	public Double getValTotProd() {
		return valTotProd;
	}

	public void setValTotProd(Double valTotProd) {
		this.valTotProd = valTotProd;
	}

	public Collection<UnidMed> getUnidade() {
		return unidade;
	}

	public void setUnidade(Collection<UnidMed> unidade) {
		this.unidade = unidade;
	}

	public Double getSalFinal() {
		return salFinal;
	}

	public void setSalFinal(Double salFinal) {
		this.salFinal = salFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCotacaoItens == null) ? 0 : idCotacaoItens.hashCode());
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
		CotacaoItens other = (CotacaoItens) obj;
		if (idCotacaoItens == null) {
			if (other.idCotacaoItens != null)
				return false;
		} else if (!idCotacaoItens.equals(other.idCotacaoItens))
			return false;
		return true;
	}
}
