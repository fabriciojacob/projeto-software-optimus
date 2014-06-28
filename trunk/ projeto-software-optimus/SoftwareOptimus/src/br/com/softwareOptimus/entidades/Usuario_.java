package br.com.softwareOptimus.entidades;

import br.com.softwareOptimus.comercial.Requisicao;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:39.394-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Long> idUsuario;
	public static volatile SingularAttribute<Usuario, String> Nome;
	public static volatile SingularAttribute<Usuario, String> Senha;
	public static volatile SingularAttribute<Usuario, String> Email;
	public static volatile CollectionAttribute<Usuario, Requisicao> requisicao;
}
