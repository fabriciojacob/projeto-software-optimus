package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:12:48.045-0300")
@StaticMetamodel(PedidoCompra.class)
public class PedidoCompra_ {
	public static volatile SingularAttribute<PedidoCompra, Long> idPedidoCom;
	public static volatile CollectionAttribute<PedidoCompra, Pessoa> entidades;
	public static volatile SingularAttribute<PedidoCompra, Calendar> DataPedCom;
	public static volatile SingularAttribute<PedidoCompra, Calendar> DatLimEntrega;
	public static volatile CollectionAttribute<PedidoCompra, Cotacao> cotacoes;
	public static volatile CollectionAttribute<PedidoCompra, PedidoComItens> pedidoComItens;
}
