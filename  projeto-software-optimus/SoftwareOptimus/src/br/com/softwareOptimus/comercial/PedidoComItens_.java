package br.com.softwareOptimus.comercial;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:12:48.044-0300")
@StaticMetamodel(PedidoComItens.class)
public class PedidoComItens_ {
	public static volatile SingularAttribute<PedidoComItens, Long> idPedidoComItens;
	public static volatile SingularAttribute<PedidoComItens, PedidoCompra> PedidoCom;
	public static volatile CollectionAttribute<PedidoComItens, Produto> produto;
	public static volatile SingularAttribute<PedidoComItens, Double> custProd;
	public static volatile SingularAttribute<PedidoComItens, Double> quant;
	public static volatile SingularAttribute<PedidoComItens, Double> valorProd;
	public static volatile SingularAttribute<PedidoComItens, Double> valortotal;
}
