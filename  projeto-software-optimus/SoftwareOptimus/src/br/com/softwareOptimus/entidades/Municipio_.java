package br.com.softwareOptimus.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.384-0300")
@StaticMetamodel(Municipio.class)
public class Municipio_ {
	public static volatile SingularAttribute<Municipio, Long> idMunicipio;
	public static volatile SingularAttribute<Municipio, String> descricao;
	public static volatile SingularAttribute<Municipio, Integer> codIbge;
	public static volatile SingularAttribute<Municipio, Estado> uf;
}
