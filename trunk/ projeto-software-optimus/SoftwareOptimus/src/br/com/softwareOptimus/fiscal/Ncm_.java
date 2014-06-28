package br.com.softwareOptimus.fiscal;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.494-0300")
@StaticMetamodel(Ncm.class)
public class Ncm_ {
	public static volatile SingularAttribute<Ncm, Long> idNcm;
	public static volatile SingularAttribute<Ncm, String> ncm;
	public static volatile SingularAttribute<Ncm, String> descricao;
	public static volatile SingularAttribute<Ncm, Aliquota> aliquota;
	public static volatile CollectionAttribute<Ncm, Vigencia> vigencia;
}
