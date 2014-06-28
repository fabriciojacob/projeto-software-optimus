package br.com.softwareOptimus.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.829-0300")
@StaticMetamodel(Email.class)
public class Email_ {
	public static volatile SingularAttribute<Email, Long> idEmail;
	public static volatile SingularAttribute<Email, String> email;
	public static volatile SingularAttribute<Email, Integer> padraoNFe;
	public static volatile SingularAttribute<Email, Pessoa> pessoa;
}
