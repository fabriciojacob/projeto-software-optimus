package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.478-0300")
@StaticMetamodel(Conta.class)
public class Conta_ {
	public static volatile SingularAttribute<Conta, Long> idConta;
	public static volatile SingularAttribute<Conta, TipoMov> tipo;
	public static volatile SingularAttribute<Conta, String> descricao;
	public static volatile CollectionAttribute<Conta, Titulo> titulos;
}
