package br.com.softwareOptimus.fiscal;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.490-0300")
@StaticMetamodel(CodTabelaGov.class)
public class CodTabelaGov_ {
	public static volatile SingularAttribute<CodTabelaGov, Long> idCodGov;
	public static volatile SingularAttribute<CodTabelaGov, Integer> natRec;
	public static volatile SingularAttribute<CodTabelaGov, Integer> codGov;
	public static volatile CollectionAttribute<CodTabelaGov, Vigencia> vigencia;
}
