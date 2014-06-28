package br.com.softwareOptimus.contabilidade;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.808-0300")
@StaticMetamodel(SaldoContas.class)
public class SaldoContas_ {
	public static volatile SingularAttribute<SaldoContas, Long> idSaldoContas;
	public static volatile SingularAttribute<SaldoContas, Calendar> datSaldo;
	public static volatile CollectionAttribute<SaldoContas, Pessoa> empresa;
	public static volatile SingularAttribute<SaldoContas, Double> saldoInicial;
	public static volatile SingularAttribute<SaldoContas, Double> totDebito;
	public static volatile SingularAttribute<SaldoContas, Double> totCredito;
	public static volatile SingularAttribute<SaldoContas, Double> saldoFinas;
}
