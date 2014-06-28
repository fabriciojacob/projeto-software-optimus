package br.com.softwareOptimus.fiscal;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:04:41.491-0300")
@StaticMetamodel(FiguraFiscal.class)
public class FiguraFiscal_ {
	public static volatile SingularAttribute<FiguraFiscal, Long> idFigura;
	public static volatile SingularAttribute<FiguraFiscal, String> descricao;
	public static volatile CollectionAttribute<FiguraFiscal, GradeTributaria> grades;
	public static volatile CollectionAttribute<FiguraFiscal, Produto> produtos;
}
