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
@Table(name = "tbPedidoFatur")
public class PedidoFatur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3986301071640974869L;

	@Id
	@GeneratedValue
	private Long idPedidoFatur;
	
	@ManyToMany
	@JoinTable(name="tbVincCliEmp", 
		joinColumns=@JoinColumn(name = "cliente"), 
		inverseJoinColumns = @JoinColumn(name = "idPessoa"))
	private Collection<Pessoa> pessoas;
	
	@Temporal(TemporalType.DATE)
	private Calendar datPedido;
	
	@OneToMany(mappedBy ="PedidoFatur")
	private Collection<PedidoFaturItens> pedidoFaturItens;

	public Long getIdPedidoFatur() {
		return idPedidoFatur;
	}

	public void setIdPedidoFatur(Long idPedidoFatur) {
		this.idPedidoFatur = idPedidoFatur;
	}

	public Collection<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Calendar getDatPedido() {
		return datPedido;
	}

	public void setDatPedido(Calendar datPedido) {
		this.datPedido = datPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPedidoFatur == null) ? 0 : idPedidoFatur.hashCode());
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
		PedidoFatur other = (PedidoFatur) obj;
		if (idPedidoFatur == null) {
			if (other.idPedidoFatur != null)
				return false;
		} else if (!idPedidoFatur.equals(other.idPedidoFatur))
			return false;
		return true;
	}
}
