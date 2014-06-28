package br.com.softwareOptimus.producao;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:04:37.867-0300")
@StaticMetamodel(ProdutoPrincipal.class)
public class ProdutoPrincipal_ {
	public static volatile SingularAttribute<ProdutoPrincipal, Long> idProdP;
	public static volatile SingularAttribute<ProdutoPrincipal, Produto> produto;
	public static volatile CollectionAttribute<ProdutoPrincipal, ProdutoFilho> prodFilho;
	public static volatile SingularAttribute<ProdutoPrincipal, Double> qtaTotal;
	public static volatile SingularAttribute<ProdutoPrincipal, Double> custoTotal;
	public static volatile SingularAttribute<ProdutoPrincipal, String> observacao;
}
