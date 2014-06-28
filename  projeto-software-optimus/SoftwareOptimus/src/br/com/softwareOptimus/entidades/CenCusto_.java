package br.com.softwareOptimus.entidades;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.826-0300")
@StaticMetamodel(CenCusto.class)
public class CenCusto_ {
	public static volatile SingularAttribute<CenCusto, Long> idCenCusto;
	public static volatile SingularAttribute<CenCusto, String> nomeCenCusto;
	public static volatile SingularAttribute<CenCusto, Calendar> datInclusao;
	public static volatile SingularAttribute<CenCusto, Pessoa> empresa;
}
