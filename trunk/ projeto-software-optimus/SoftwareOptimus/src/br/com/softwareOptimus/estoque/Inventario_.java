package br.com.softwareOptimus.estoque;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:04:41.471-0300")
@StaticMetamodel(Inventario.class)
public class Inventario_ {
	public static volatile SingularAttribute<Inventario, Long> idInventario;
	public static volatile SingularAttribute<Inventario, String> descricao;
	public static volatile CollectionAttribute<Inventario, Produto> produtos;
	public static volatile SingularAttribute<Inventario, Calendar> data;
	public static volatile SingularAttribute<Inventario, Double> quantidadeContata;
	public static volatile SingularAttribute<Inventario, Double> quantidadeAtual;
	public static volatile SingularAttribute<Inventario, PessoaJuridica> empresa;
}
