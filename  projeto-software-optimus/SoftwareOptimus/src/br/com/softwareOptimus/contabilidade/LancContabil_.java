package br.com.softwareOptimus.contabilidade;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.793-0300")
@StaticMetamodel(LancContabil.class)
public class LancContabil_ {
	public static volatile SingularAttribute<LancContabil, Long> idLanc;
	public static volatile SingularAttribute<LancContabil, Calendar> DatLanc;
	public static volatile SingularAttribute<LancContabil, Pessoa> Empresa;
	public static volatile SingularAttribute<LancContabil, PlanoDeContas> credito;
	public static volatile SingularAttribute<LancContabil, PlanoDeContas> debito;
	public static volatile SingularAttribute<LancContabil, Double> valorPagamento;
	public static volatile SingularAttribute<LancContabil, String> historico;
}
