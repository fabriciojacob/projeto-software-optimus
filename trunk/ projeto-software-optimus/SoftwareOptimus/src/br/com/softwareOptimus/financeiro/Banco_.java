package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.474-0300")
@StaticMetamodel(Banco.class)
public class Banco_ {
	public static volatile SingularAttribute<Banco, String> idBanco;
	public static volatile SingularAttribute<Banco, String> nome;
	public static volatile CollectionAttribute<Banco, ContaCorrente> contaCorrente;
}
