package br.com.softwareOptimus.comercial;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;
import softwareOptimus.com.produto.UnidMed;

@Generated(value="Dali", date="2014-06-28T15:12:48.043-0300")
@StaticMetamodel(CotacaoItens.class)
public class CotacaoItens_ {
	public static volatile SingularAttribute<CotacaoItens, Long> idCotacaoItens;
	public static volatile SingularAttribute<CotacaoItens, Cotacao> cotacao;
	public static volatile CollectionAttribute<CotacaoItens, Produto> produto;
	public static volatile SingularAttribute<CotacaoItens, Double> custProd;
	public static volatile SingularAttribute<CotacaoItens, Double> quantCot;
	public static volatile SingularAttribute<CotacaoItens, Double> valTotProd;
	public static volatile SingularAttribute<CotacaoItens, Integer> itemComprado;
	public static volatile CollectionAttribute<CotacaoItens, UnidMed> unidade;
	public static volatile SingularAttribute<CotacaoItens, Double> salFinal;
}
