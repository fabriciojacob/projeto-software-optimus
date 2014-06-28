package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.fiscal.CodigoFiscalOperacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:12:48.038-0300")
@StaticMetamodel(ComercialFiscais.class)
public class ComercialFiscais_ {
	public static volatile SingularAttribute<ComercialFiscais, Long> idComFiscais;
	public static volatile SingularAttribute<ComercialFiscais, Comercial> Comercial;
	public static volatile SingularAttribute<ComercialFiscais, Double> valOper;
	public static volatile CollectionAttribute<ComercialFiscais, CodigoFiscalOperacao> cfop;
	public static volatile SingularAttribute<ComercialFiscais, Double> valBcIcms;
	public static volatile SingularAttribute<ComercialFiscais, Double> valIcms;
	public static volatile SingularAttribute<ComercialFiscais, Double> valBcIcmsSt;
	public static volatile SingularAttribute<ComercialFiscais, Double> valIcmsSt;
	public static volatile SingularAttribute<ComercialFiscais, Double> valRedBc;
}
