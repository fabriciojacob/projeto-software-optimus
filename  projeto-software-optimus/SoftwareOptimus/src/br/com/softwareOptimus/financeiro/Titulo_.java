package br.com.softwareOptimus.financeiro;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.483-0300")
@StaticMetamodel(Titulo.class)
public class Titulo_ {
	public static volatile SingularAttribute<Titulo, Long> idTitulo;
	public static volatile SingularAttribute<Titulo, String> descricao;
	public static volatile CollectionAttribute<Titulo, FormaPgto> formaPgto;
	public static volatile SingularAttribute<Titulo, CondPgto> condPgto;
	public static volatile SingularAttribute<Titulo, Double> valor;
	public static volatile SingularAttribute<Titulo, Double> saldo;
	public static volatile SingularAttribute<Titulo, Boolean> previsao;
	public static volatile SingularAttribute<Titulo, Calendar> dataLancamento;
	public static volatile SingularAttribute<Titulo, Calendar> vencimento;
	public static volatile SingularAttribute<Titulo, Calendar> dataPagamento;
	public static volatile SingularAttribute<Titulo, StatusConta> status;
	public static volatile SingularAttribute<Titulo, TipoBaixa> tipoBaixa;
	public static volatile SingularAttribute<Titulo, Caixa> caixa;
	public static volatile SingularAttribute<Titulo, Conta> conta;
}
