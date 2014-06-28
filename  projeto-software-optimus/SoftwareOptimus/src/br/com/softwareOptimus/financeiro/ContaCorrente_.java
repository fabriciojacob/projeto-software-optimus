package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.479-0300")
@StaticMetamodel(ContaCorrente.class)
public class ContaCorrente_ {
	public static volatile SingularAttribute<ContaCorrente, Long> idContaCorrente;
	public static volatile SingularAttribute<ContaCorrente, Banco> banco;
	public static volatile SingularAttribute<ContaCorrente, Integer> agencia;
	public static volatile SingularAttribute<ContaCorrente, Integer> conta;
	public static volatile CollectionAttribute<ContaCorrente, ExtratoContaCorrente> extrato;
}
