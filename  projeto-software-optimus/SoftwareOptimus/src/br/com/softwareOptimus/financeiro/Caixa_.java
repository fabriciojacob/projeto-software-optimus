package br.com.softwareOptimus.financeiro;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.475-0300")
@StaticMetamodel(Caixa.class)
public class Caixa_ {
	public static volatile SingularAttribute<Caixa, Long> idCaixa;
	public static volatile SingularAttribute<Caixa, Double> valor;
	public static volatile SingularAttribute<Caixa, String> descricao;
	public static volatile SingularAttribute<Caixa, Double> saldo;
	public static volatile SingularAttribute<Caixa, Calendar> dataMovimentacao;
	public static volatile SingularAttribute<Caixa, TipoMov> tipoMov;
	public static volatile CollectionAttribute<Caixa, Titulo> contas;
}
