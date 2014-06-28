package br.com.softwareOptimus.contabilidade;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.801-0300")
@StaticMetamodel(PlanoDeContas.class)
public class PlanoDeContas_ {
	public static volatile SingularAttribute<PlanoDeContas, Long> idPlaContas;
	public static volatile SingularAttribute<PlanoDeContas, String> redutor;
	public static volatile SingularAttribute<PlanoDeContas, String> descricao;
	public static volatile SingularAttribute<PlanoDeContas, String> grupo;
	public static volatile SingularAttribute<PlanoDeContas, String> classificacao;
	public static volatile CollectionAttribute<PlanoDeContas, Pessoa> empresa;
	public static volatile SingularAttribute<PlanoDeContas, TipoElemBas> EleBas;
	public static volatile CollectionAttribute<PlanoDeContas, PlanoDeContasRef> planoRef;
	public static volatile SingularAttribute<PlanoDeContas, TipoConta> tipoConta;
	public static volatile SingularAttribute<PlanoDeContas, Calendar> datInclusao;
}
