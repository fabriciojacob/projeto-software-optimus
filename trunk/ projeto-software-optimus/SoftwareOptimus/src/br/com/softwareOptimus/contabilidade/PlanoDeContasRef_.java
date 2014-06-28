package br.com.softwareOptimus.contabilidade;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:37.803-0300")
@StaticMetamodel(PlanoDeContasRef.class)
public class PlanoDeContasRef_ {
	public static volatile SingularAttribute<PlanoDeContasRef, Long> idPlanContRef;
	public static volatile SingularAttribute<PlanoDeContasRef, String> codCtaRef;
	public static volatile SingularAttribute<PlanoDeContasRef, String> descricao;
	public static volatile SingularAttribute<PlanoDeContasRef, String> orientacao;
	public static volatile SingularAttribute<PlanoDeContasRef, Calendar> datValInicio;
	public static volatile SingularAttribute<PlanoDeContasRef, Calendar> dataValFim;
	public static volatile SingularAttribute<PlanoDeContasRef, TipoElemBas> ElemBas;
}
