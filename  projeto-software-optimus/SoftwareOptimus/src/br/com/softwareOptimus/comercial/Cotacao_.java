package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.entidades.Pessoa;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:12:48.041-0300")
@StaticMetamodel(Cotacao.class)
public class Cotacao_ {
	public static volatile SingularAttribute<Cotacao, Long> idCotacao;
	public static volatile SingularAttribute<Cotacao, Requisicao> Requisicao;
	public static volatile CollectionAttribute<Cotacao, Pessoa> fornecedor;
	public static volatile SingularAttribute<Cotacao, Calendar> DataCot;
	public static volatile SingularAttribute<Cotacao, Double> SalCotado;
	public static volatile CollectionAttribute<Cotacao, CotacaoItens> cotItem;
}
