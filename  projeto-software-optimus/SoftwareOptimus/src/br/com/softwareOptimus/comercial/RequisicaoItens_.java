package br.com.softwareOptimus.comercial;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;
import softwareOptimus.com.produto.UnidMed;

@Generated(value="Dali", date="2014-06-28T15:12:48.050-0300")
@StaticMetamodel(RequisicaoItens.class)
public class RequisicaoItens_ {
	public static volatile SingularAttribute<RequisicaoItens, Long> idReqItem;
	public static volatile SingularAttribute<RequisicaoItens, Requisicao> Requisicao;
	public static volatile CollectionAttribute<RequisicaoItens, Produto> produto;
	public static volatile SingularAttribute<RequisicaoItens, Double> quant;
	public static volatile CollectionAttribute<RequisicaoItens, UnidMed> unidade;
	public static volatile SingularAttribute<RequisicaoItens, Double> salIni;
	public static volatile SingularAttribute<RequisicaoItens, String> Obs;
}
