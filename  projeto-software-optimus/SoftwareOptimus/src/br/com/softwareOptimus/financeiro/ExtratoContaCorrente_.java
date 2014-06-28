package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.480-0300")
@StaticMetamodel(ExtratoContaCorrente.class)
public class ExtratoContaCorrente_ {
	public static volatile SingularAttribute<ExtratoContaCorrente, Long> idExtratoC;
	public static volatile SingularAttribute<ExtratoContaCorrente, ContaCorrente> contaCorrente;
	public static volatile CollectionAttribute<ExtratoContaCorrente, Titulo> titulo;
	public static volatile SingularAttribute<ExtratoContaCorrente, String> descricao;
	public static volatile SingularAttribute<ExtratoContaCorrente, Double> debito;
	public static volatile SingularAttribute<ExtratoContaCorrente, Double> credito;
	public static volatile SingularAttribute<ExtratoContaCorrente, Double> saldo;
}
