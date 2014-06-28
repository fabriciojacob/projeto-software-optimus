package br.com.softwareOptimus.fiscal;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.495-0300")
@StaticMetamodel(Vigencia.class)
public class Vigencia_ {
	public static volatile SingularAttribute<Vigencia, Long> idVigencia;
	public static volatile SingularAttribute<Vigencia, Date> vigencia;
	public static volatile SingularAttribute<Vigencia, Aliquota> aliquota;
	public static volatile SingularAttribute<Vigencia, CodTabelaGov> codTabelaGov;
}
