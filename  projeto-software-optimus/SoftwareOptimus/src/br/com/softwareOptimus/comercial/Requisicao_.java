package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:12:48.049-0300")
@StaticMetamodel(Requisicao.class)
public class Requisicao_ {
	public static volatile SingularAttribute<Requisicao, Long> idRequisicao;
	public static volatile SingularAttribute<Requisicao, Double> numReq;
	public static volatile SingularAttribute<Requisicao, Usuario> UsuRequisita;
	public static volatile SingularAttribute<Requisicao, Pessoa> empresa;
	public static volatile CollectionAttribute<Requisicao, RequisicaoItens> requisicaoItens;
	public static volatile SingularAttribute<Requisicao, String> observacoes;
	public static volatile SingularAttribute<Requisicao, Calendar> dataReq;
	public static volatile CollectionAttribute<Requisicao, Cotacao> cotacao;
}
