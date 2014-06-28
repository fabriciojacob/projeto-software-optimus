package br.com.softwareOptimus.entidades;

import br.com.softwareOptimus.fiscal.GradeTributaria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.381-0300")
@StaticMetamodel(Estado.class)
public class Estado_ {
	public static volatile SingularAttribute<Estado, Long> idUf;
	public static volatile SingularAttribute<Estado, String> descricao;
	public static volatile SingularAttribute<Estado, Integer> codIbge;
	public static volatile SingularAttribute<Estado, Pais> pais;
	public static volatile CollectionAttribute<Estado, GradeTributaria> grades;
	public static volatile CollectionAttribute<Estado, Municipio> municipio;
}
