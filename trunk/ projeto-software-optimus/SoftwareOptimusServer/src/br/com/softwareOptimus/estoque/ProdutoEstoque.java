package br.com.softwareOptimus.estoque;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.comercial.Comercial;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.produto.Produto;



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
	
	@ManyToOne
	private Pessoa Empresa;
	
	@ManyToOne
	private Produto produto;
	
	@Column(columnDefinition="double precision default '0'")
	private Double custoNota;
	
	@Column(columnDefinition="double precision default '0'")
	private Double totalNota;
	
	@OneToOne(optional = true)
	private Comercial origem;
	
	@Column(columnDefinition="double precision default '0'")
	private Double pisCofinsNota;
	
	@Column(columnDefinition="double precision default '0'")
	private Double freteNota;
	
	@Column(columnDefinition="double precision default '0'")
	private Double ipiNota;
	
	//este engloba icms e ST
	@Column(columnDefinition="double precision default '0'")
	private Double icmsNota;
	
	//Despesas acessorias da nota
	@Column(columnDefinition="double precision default '0'")
	private Double despesaNota;
	
	private String justificativa;
	
	private Double quantidade;
	
	private Double quantSaida;
	
	private Double quantEntrada;
	
	private Double saldo;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private Double custoMedio;
	
	private Double totalCusto;
	
	private TipoMovEst tipoMovEst;
	
	public Double getTotalNota() {
		return totalNota;
	}

	public void setTotalNota(Double totalNota) {
		this.totalNota = totalNota;
	}

	public Double getPisCofinsNota() {
		return pisCofinsNota;
	}

	public void setPisCofinsNota(Double pisCofinsNota) {
		this.pisCofinsNota = pisCofinsNota;
	}

	public Double getFreteNota() {
		return freteNota;
	}

	public void setFreteNota(Double freteNota) {
		this.freteNota = freteNota;
	}

	public Double getIpiNota() {
		return ipiNota;
	}

	public void setIpiNota(Double ipiNota) {
		this.ipiNota = ipiNota;
	}

	public Double getIcmsNota() {
		return icmsNota;
	}

	public void setIcmsNota(Double icmsNota) {
		this.icmsNota = icmsNota;
	}

	public Double getDespesaNota() {
		return despesaNota;
	}

	public void setDespesaNota(Double despesaNota) {
		this.despesaNota = despesaNota;
	}

	public Double getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

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

	public Pessoa getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		Empresa = empresa;
	}

	
	public Double getCustoNota() {
		return custoNota;
	}

	public void setCustoNota(Double custoNota) {
		this.custoNota = custoNota;
	}

	public Double getNotaTotal() {
		return totalNota;
	}

	public void setNotaTotal(Double notaTotal) {
		this.totalNota = notaTotal;
	}

	public Comercial getOrigem() {
		return origem;
	}

	public void setOrigem(Comercial origem) {
		this.origem = origem;
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
	
	@SuppressWarnings("static-access")
	public void setCustoMedio(TipoMovEst tipo) {
		if(tipoMovEst.COMPRA.equals(tipo.COMPRA) && this.saldo >= 0){
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
