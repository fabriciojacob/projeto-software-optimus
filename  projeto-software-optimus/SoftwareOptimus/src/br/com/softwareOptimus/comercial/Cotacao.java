package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;


@Entity
@Table(name="TbCotacao")
public class Cotacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7922327620548891565L;

	@Id
	@GeneratedValue
	private Long idCotacao;
	
	@ManyToOne
	private Requisicao Requisicao;
	
	@ManyToMany
	private Collection<Pessoa> fornecedor;
	
	@Temporal(TemporalType.DATE)
	private Calendar DataCot;
	
	private Double SalCotado;

	@OneToMany(mappedBy ="cotacao")
	private Collection<CotacaoItens> cotItem;
	
	public Long getIdCotacao() {
		return idCotacao;
	}

	public void setIdCotacao(Long idCotacao) {
		this.idCotacao = idCotacao;
	}

	public Requisicao getRequisicao() {
		return Requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		Requisicao = requisicao;
	}

	public Collection<Pessoa> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Collection<Pessoa> fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Calendar getDataCot() {
		return DataCot;
	}

	public void setDataCot(Calendar dataCot) {
		DataCot = dataCot;
	}

	public Double getSalCotado() {
		return SalCotado;
	}

	public void setSalCotado(Double salCotado) {
		SalCotado = salCotado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCotacao == null) ? 0 : idCotacao.hashCode());
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
		Cotacao other = (Cotacao) obj;
		if (idCotacao == null) {
			if (other.idCotacao != null)
				return false;
		} else if (!idCotacao.equals(other.idCotacao))
			return false;
		return true;
	}
}
