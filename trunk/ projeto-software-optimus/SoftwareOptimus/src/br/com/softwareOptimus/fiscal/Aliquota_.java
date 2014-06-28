package br.com.softwareOptimus.fiscal;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.485-0300")
@StaticMetamodel(Aliquota.class)
public class Aliquota_ {
	public static volatile SingularAttribute<Aliquota, Long> idAliq;
	public static volatile SingularAttribute<Aliquota, Double> aliquota;
	public static volatile SingularAttribute<Aliquota, Double> reducao;
	public static volatile CollectionAttribute<Aliquota, CodigoSituacaoTributaria> cst;
	public static volatile SingularAttribute<Aliquota, TipoTrib> tipo;
	public static volatile CollectionAttribute<Aliquota, Vigencia> vigencias;
	public static volatile SingularAttribute<Aliquota, GradeTributaria> grade;
}
