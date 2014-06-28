package br.com.softwareOptimus.entidades;

import br.com.softwareOptimus.comercial.Requisicao;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.387-0300")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ {
	public static volatile SingularAttribute<Pessoa, Long> idPessoa;
	public static volatile SingularAttribute<Pessoa, String> fantasia;
	public static volatile SingularAttribute<Pessoa, String> razaoSocial;
	public static volatile CollectionAttribute<Pessoa, Requisicao> requisicao;
	public static volatile SingularAttribute<Pessoa, NaturezaPessoa> naturezaPessoa;
	public static volatile SingularAttribute<Pessoa, Boolean> status;
	public static volatile SingularAttribute<Pessoa, String> Crc;
	public static volatile CollectionAttribute<Pessoa, Logradouro> logradouro;
	public static volatile CollectionAttribute<Pessoa, Telefone> telefones;
}
