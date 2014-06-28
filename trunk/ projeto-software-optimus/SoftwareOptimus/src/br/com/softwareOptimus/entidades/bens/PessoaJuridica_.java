package br.com.softwareOptimus.entidades.bens;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.821-0300")
@StaticMetamodel(PessoaJuridica.class)
public class PessoaJuridica_ {
	public static volatile SingularAttribute<PessoaJuridica, String> cnpj;
	public static volatile SingularAttribute<PessoaJuridica, String> ie;
	public static volatile SingularAttribute<PessoaJuridica, String> cnae;
	public static volatile SingularAttribute<PessoaJuridica, TipoPessoaJuridica> tipoPessoaJuridica;
	public static volatile SingularAttribute<PessoaJuridica, Integer> regime;
}
