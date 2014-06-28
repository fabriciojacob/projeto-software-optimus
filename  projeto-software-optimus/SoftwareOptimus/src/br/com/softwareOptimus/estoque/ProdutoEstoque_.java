package br.com.softwareOptimus.estoque;

import br.com.softwareOptimus.entidades.TipoMovEst;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:04:41.472-0300")
@StaticMetamodel(ProdutoEstoque.class)
public class ProdutoEstoque_ {
	public static volatile SingularAttribute<ProdutoEstoque, Long> idProdEst;
	public static volatile SingularAttribute<ProdutoEstoque, Double> quantidade;
	public static volatile SingularAttribute<ProdutoEstoque, Double> quantSaida;
	public static volatile SingularAttribute<ProdutoEstoque, Double> quantEntrada;
	public static volatile SingularAttribute<ProdutoEstoque, Double> saldo;
	public static volatile SingularAttribute<ProdutoEstoque, Calendar> data;
	public static volatile SingularAttribute<ProdutoEstoque, Double> custoMedio;
	public static volatile SingularAttribute<ProdutoEstoque, Double> totalCusto;
	public static volatile SingularAttribute<ProdutoEstoque, TipoMovEst> tipoMovEst;
	public static volatile SingularAttribute<ProdutoEstoque, Produto> produto;
	public static volatile SingularAttribute<ProdutoEstoque, String> justificativa;
}
