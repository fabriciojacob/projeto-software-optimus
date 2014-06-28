package br.com.softwareOptimus.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.382-0300")
@StaticMetamodel(Logradouro.class)
public class Logradouro_ {
	public static volatile SingularAttribute<Logradouro, Long> idEndereco;
	public static volatile SingularAttribute<Logradouro, String> Endereco;
	public static volatile SingularAttribute<Logradouro, Integer> numero;
	public static volatile SingularAttribute<Logradouro, String> bairro;
	public static volatile SingularAttribute<Logradouro, TipoLogradouro> tipoLogr;
	public static volatile SingularAttribute<Logradouro, String> complemento;
	public static volatile SingularAttribute<Logradouro, String> cep;
	public static volatile SingularAttribute<Logradouro, Municipio> municipio;
	public static volatile SingularAttribute<Logradouro, Pessoa> pessoa;
}
