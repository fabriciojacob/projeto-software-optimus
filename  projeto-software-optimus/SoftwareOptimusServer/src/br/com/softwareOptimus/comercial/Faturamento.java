package br.com.softwareOptimus.comercial;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
public class Faturamento extends Comercial{

	@ManyToMany
	@JoinTable(name="tbVincPedFaturamento", 
		joinColumns=@JoinColumn(name = "numPedido"), 
		inverseJoinColumns = @JoinColumn(name = "notaSai"))
	private PedidoFatur numPedidoFatur;

	public PedidoFatur getNumPedidoFatur() {
		return numPedidoFatur;
	}

	public void setNumPedidoFatur(PedidoFatur numPedidoFatur) {
		this.numPedidoFatur = numPedidoFatur;
	}	
}
