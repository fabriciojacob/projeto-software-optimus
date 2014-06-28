package br.com.softwareOptimus.producao;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:04:37.865-0300")
@StaticMetamodel(ProdutoFilho.class)
public class ProdutoFilho_ {
	public static volatile SingularAttribute<ProdutoFilho, Long> idProdFilho;
	public static volatile SingularAttribute<ProdutoFilho, ProdutoPrincipal> prodPrinc;
	public static volatile SingularAttribute<ProdutoFilho, Produto> produto;
	public static volatile SingularAttribute<ProdutoFilho, Double> quantidade;
	public static volatile SingularAttribute<ProdutoFilho, Double> custo;
	public static volatile SingularAttribute<ProdutoFilho, Double> custoTotal;
}
