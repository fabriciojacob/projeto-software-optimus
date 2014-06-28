package br.com.softwareOptimus.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.385-0300")
@StaticMetamodel(Pais.class)
public class Pais_ {
	public static volatile SingularAttribute<Pais, Long> idPais;
	public static volatile SingularAttribute<Pais, String> descricao;
	public static volatile SingularAttribute<Pais, Integer> codIbge;
	public static volatile CollectionAttribute<Pais, Estado> estados;
}
