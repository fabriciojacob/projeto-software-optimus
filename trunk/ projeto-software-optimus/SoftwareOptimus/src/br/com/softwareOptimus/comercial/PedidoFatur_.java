package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:12:48.046-0300")
@StaticMetamodel(PedidoFatur.class)
public class PedidoFatur_ {
	public static volatile SingularAttribute<PedidoFatur, Long> idPedidoFatur;
	public static volatile CollectionAttribute<PedidoFatur, Pessoa> pessoas;
	public static volatile SingularAttribute<PedidoFatur, Calendar> datPedido;
	public static volatile CollectionAttribute<PedidoFatur, PedidoFaturItens> pedidoFaturItens;
}
