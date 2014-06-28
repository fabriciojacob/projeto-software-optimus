package br.com.softwareOptimus.financeiro;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.481-0300")
@StaticMetamodel(FormaPgto.class)
public class FormaPgto_ {
	public static volatile SingularAttribute<FormaPgto, Long> idFormaPg;
	public static volatile SingularAttribute<FormaPgto, String> descricao;
	public static volatile SingularAttribute<FormaPgto, TipoFormaPgto> tipoFormaPgto;
}
