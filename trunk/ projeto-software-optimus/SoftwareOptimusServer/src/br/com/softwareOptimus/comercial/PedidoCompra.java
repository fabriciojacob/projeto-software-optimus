package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
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
@Table(name = "tbPedidoCompra")
public class PedidoCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3482194267932270426L;

	@Id
	@GeneratedValue
	private Long idPedidoCom;

	@ManyToMany
	@JoinTable(name="tbVincForEmp", 
		joinColumns=@JoinColumn(name = "fornecedor"), 
		inverseJoinColumns = @JoinColumn(name = "idPessoa"))
	private Collection<Pessoa> entidades;

	@Temporal(TemporalType.DATE)
	private Calendar DataPedCom;

	@Temporal(TemporalType.DATE)
	private Calendar DatLimEntrega;

	@ManyToMany
	@JoinTable(name="tbVincCotPed", 
		joinColumns=@JoinColumn(name = "idPedido"), 
		inverseJoinColumns = @JoinColumn(name = "idCotacao"))
	private Collection<Cotacao> cotacoes;
	
	@OneToMany(mappedBy ="PedidoCom")
	private Collection<PedidoComItens> pedidoComItens;
	
	public Collection<Cotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(Collection<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public Collection<Pessoa> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Pessoa> entidades) {
		this.entidades = entidades;
	}

	public Calendar getDataPedCom() {
		return DataPedCom;
	}

	public void setDataPedCom(Calendar dataPedCom) {
		DataPedCom = dataPedCom;
	}

	public Calendar getDatLimEntrega() {
		return DatLimEntrega;
	}

	public void setDatLimEntrega(Calendar datLimEntrega) {
		DatLimEntrega = datLimEntrega;
	}

	public Long getIdPedidoCom() {
		return idPedidoCom;
	}

	public void setIdPedidoCom(Long idPedidoCom) {
		this.idPedidoCom = idPedidoCom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPedidoCom == null) ? 0 : idPedidoCom.hashCode());
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
		PedidoCompra other = (PedidoCompra) obj;
		if (idPedidoCom == null) {
			if (other.idPedidoCom != null)
				return false;
		} else if (!idPedidoCom.equals(other.idPedidoCom))
			return false;
		return true;
	}
}
