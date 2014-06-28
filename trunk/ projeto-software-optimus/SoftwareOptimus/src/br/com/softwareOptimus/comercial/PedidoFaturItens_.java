package br.com.softwareOptimus.comercial;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:12:48.048-0300")
@StaticMetamodel(PedidoFaturItens.class)
public class PedidoFaturItens_ {
	public static volatile SingularAttribute<PedidoFaturItens, Long> idPedFatuItens;
	public static volatile SingularAttribute<PedidoFaturItens, PedidoFatur> PedidoFatur;
	public static volatile CollectionAttribute<PedidoFaturItens, Produto> produto;
	public static volatile SingularAttribute<PedidoFaturItens, Double> custProd;
	public static volatile SingularAttribute<PedidoFaturItens, Double> quant;
	public static volatile SingularAttribute<PedidoFaturItens, Double> valorProd;
	public static volatile SingularAttribute<PedidoFaturItens, Double> valortotal;
}
