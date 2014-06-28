package br.com.softwareOptimus.producao;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:35.961-0300")
@StaticMetamodel(Fases.class)
public class Fases_ {
	public static volatile SingularAttribute<Fases, Long> idFases;
	public static volatile SingularAttribute<Fases, String> descricao;
	public static volatile SingularAttribute<Fases, TipoFase> tipoFase;
	public static volatile SingularAttribute<Fases, TipoPeso> tipoPeso;
	public static volatile SingularAttribute<Fases, Boolean> geraEstoque;
	public static volatile CollectionAttribute<Fases, Fases> fases;
	public static volatile SingularAttribute<Fases, Double> custoMO;
	public static volatile SingularAttribute<Fases, Double> custoMQ;
	public static volatile SingularAttribute<Fases, Double> custoGR;
}
