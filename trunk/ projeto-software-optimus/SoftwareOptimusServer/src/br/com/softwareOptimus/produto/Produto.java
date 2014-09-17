package br.com.softwareOptimus.produto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.producao.ProdutoFilho;
import br.com.softwareOptimus.producao.ProdutoPrincipal;



@Entity
@Table(name="tbProduto")
public class Produto implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5769840610473370567L;

	@Id
	@GeneratedValue
	private Long idProduto;
	
	@Column ( length = 85 , nullable = true , unique = false)
	private String descProd;
	
	private String codBarra;
	
	@OneToOne(mappedBy="produto")
	private ProdutoEstoque estoque;
	
	@OneToOne(mappedBy = "produto")
	private ProdutoFilho prodFilho;
	
	@OneToOne(mappedBy = "produto")
	private ProdutoPrincipal prodPrincipal;

	@ManyToOne
	private FiguraFiscal figura;
	
	@ManyToOne
	private UnidMed UnidMed;
	
	@ManyToOne
	private TipoProduto tipoProd;
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ProdutoPrincipal getProdPrincipal() {
		return prodPrincipal;
	}
	
	public void setProdPrincipal(ProdutoPrincipal prodPrincipal) {
		this.prodPrincipal = prodPrincipal;
	}
	
	public ProdutoFilho getProdFilho() {
		return prodFilho;
	}
	
	public void setProdFilho(ProdutoFilho prodFilho) {
		this.prodFilho = prodFilho;
	}

	public FiguraFiscal getFigura() {
		return figura;
	}
	
	public void setFigura(FiguraFiscal figura) {
		this.figura = figura;
	}
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public UnidMed getUnidMed() {
		return UnidMed;
	}

	public void setUnidMed(UnidMed unidMed) {
		UnidMed = unidMed;
	}

	public ProdutoEstoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(ProdutoEstoque estoque) {
		this.estoque = estoque;
	}


	public TipoProduto getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(TipoProduto tipoProd) {
		this.tipoProd = tipoProd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduto == null) ? 0 : idProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
	
}
