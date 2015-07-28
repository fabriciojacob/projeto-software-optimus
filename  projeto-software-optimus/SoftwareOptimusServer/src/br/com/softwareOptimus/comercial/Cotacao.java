package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@OneToMany
	private List<Requisicao> Requisicao;
	
	@ManyToMany
	@JoinTable(name = "tbVincForReq", joinColumns = @JoinColumn(name = "idRequisicao"), inverseJoinColumns = @JoinColumn(name = "idFornecedor"))
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
	

	public List<Requisicao> getRequisicao() {
		return Requisicao;
	}

	public void setRequisicao(List<Requisicao> requisicao) {
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
	
	public Collection<CotacaoItens> getCotItem() {
		return cotItem;
	}

	public void setCotItem(Collection<CotacaoItens> cotItem) {
		this.cotItem = cotItem;
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
