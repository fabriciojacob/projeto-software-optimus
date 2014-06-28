package br.com.softwareOptimus.fiscal;

import br.com.softwareOptimus.entidades.Estado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.493-0300")
@StaticMetamodel(GradeTributaria.class)
public class GradeTributaria_ {
	public static volatile SingularAttribute<GradeTributaria, Long> id;
	public static volatile SingularAttribute<GradeTributaria, Estado> estado;
	public static volatile SingularAttribute<GradeTributaria, Aliquota> aliquota;
	public static volatile SingularAttribute<GradeTributaria, IO> io;
	public static volatile SingularAttribute<GradeTributaria, String> descricao;
}
