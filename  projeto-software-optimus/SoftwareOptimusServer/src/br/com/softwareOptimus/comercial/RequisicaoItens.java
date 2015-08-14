package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.UnidMed;



@Entity
@Table(name = "tbRequisItem")
public class RequisicaoItens implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -231109860454722900L;

	@Id
	@GeneratedValue
	private Long idReqItem;
	
	@ManyToOne
	private Requisicao requisicao;
	
	@ManyToOne
	private Produto produto;
	
	private Double quant;
	
	@ManyToOne
	private UnidMed unidade;
	
	private Double salIni;
	
	private String Obs;
	
	public UnidMed getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidMed unidade) {
		this.unidade = unidade;
	}

	public String getObs() {
		return Obs;
	}

	public void setObs(String obs) {
		Obs = obs;
	}

	public Long getIdReqItem() {
		return idReqItem;
	}

	public void setIdReqItem(Long idReqItem) {
		this.idReqItem = idReqItem;
	}

	public Requisicao getIdRequisicao() {
		return requisicao;
	}

	public void setIdRequisicao(Requisicao idRequisicao) {
		this.requisicao = idRequisicao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQuant() {
		return quant;
	}

	public void setQuant(Double quant) {
		this.quant = quant;
	}

	public Double getSalIni() {
		return salIni;
	}

	public void setSalIni(Double salIni) {
		this.salIni = salIni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idReqItem == null) ? 0 : idReqItem.hashCode());
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
		RequisicaoItens other = (RequisicaoItens) obj;
		if (idReqItem == null) {
			if (other.idReqItem != null)
				return false;
		} else if (!idReqItem.equals(other.idReqItem))
			return false;
		return true;
	}
}
