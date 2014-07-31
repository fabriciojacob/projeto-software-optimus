package br.com.softwareOptimus.comercial;

import java.util.Collection;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
public class Entradas extends Comercial{

	@ManyToMany
	@JoinTable(name="tbVincPedEntrada", 
		joinColumns=@JoinColumn(name = "numPedido"), 
		inverseJoinColumns = @JoinColumn(name = "notaEnt"))
	private Collection<PedidoCompra> numPedidoComp;

	public Collection<PedidoCompra> getNumPedidoComp() {
		return numPedidoComp;
	}

	public void setNumPedidoComp(Collection<PedidoCompra> numPedidoComp) {
		this.numPedidoComp = numPedidoComp;
	}
}
