package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.476-0300")
@StaticMetamodel(CondPgto.class)
public class CondPgto_ {
	public static volatile SingularAttribute<CondPgto, Long> idCondPgto;
	public static volatile SingularAttribute<CondPgto, Integer> parcela;
	public static volatile CollectionAttribute<CondPgto, Vencimento> vencimento;
}
