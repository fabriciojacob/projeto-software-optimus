package br.com.softwareOptimus.financeiro;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.484-0300")
@StaticMetamodel(Vencimento.class)
public class Vencimento_ {
	public static volatile SingularAttribute<Vencimento, Long> idVenc;
	public static volatile SingularAttribute<Vencimento, Calendar> dataVencimento;
	public static volatile SingularAttribute<Vencimento, CondPgto> condPgto;
}
