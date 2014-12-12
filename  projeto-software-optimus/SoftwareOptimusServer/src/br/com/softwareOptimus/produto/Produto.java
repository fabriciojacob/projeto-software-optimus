package br.com.softwareOptimus.produto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

	@OneToOne(mappedBy = "produto")
	private ProdutoFilho prodFilho;
	
	@OneToOne(mappedBy = "produto")
	private ProdutoPrincipal prodPrincipal;

	@ManyToOne
	@JoinColumn(name = "idFigura", nullable = false, foreignKey = @ForeignKey(name = "fk_tbFigura"))
	private FiguraFiscal figura;
	
	@ManyToOne
	@JoinColumn(name = "idUnidMed", nullable = false, foreignKey = @ForeignKey(name = "fk_tbUnidMed"))
	private UnidMed UnidMed;
	
	@ManyToOne
	@JoinColumn(name = "idTipoProduto", nullable = false, foreignKey = @ForeignKey(name = "fk_tbTipoProd"))
	private TipoProduto tipoProd;
	
	@ManyToOne
	@JoinColumn(name = "idSetor", nullable = false, foreignKey = @ForeignKey(name = "fk_tbSetor2"))
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "idGrupo", nullable = false, foreignKey = @ForeignKey(name = "fk_tbGrupo2"))
	private Grupo grupo;
	
	@ManyToOne
	@JoinColumn(name = "idSubGrupo", nullable = false, foreignKey = @ForeignKey(name = "fk_tbSubGrupo2"))
	private SubGrupo subGrupo;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false, foreignKey = @ForeignKey(name = "fk_tbCategoria"))
	private Categoria categoria;
	
	private boolean status;
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

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

	public TipoProduto getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(TipoProduto tipoProd) {
		this.tipoProd = tipoProd;
	}
	
	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		this.setor = setor;
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
