package br.com.softwareOptimus.comercial;

import br.com.softwareOptimus.fiscal.CodigoFiscalOperacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import softwareOptimus.com.produto.Produto;

@Generated(value="Dali", date="2014-06-28T15:12:48.040-0300")
@StaticMetamodel(ComercialItens.class)
public class ComercialItens_ {
	public static volatile SingularAttribute<ComercialItens, Long> idComItens;
	public static volatile SingularAttribute<ComercialItens, Comercial> Comercial;
	public static volatile CollectionAttribute<ComercialItens, Produto> produto;
	public static volatile SingularAttribute<ComercialItens, Double> quant;
	public static volatile SingularAttribute<ComercialItens, Double> valItem;
	public static volatile SingularAttribute<ComercialItens, Double> valDesc;
	public static volatile CollectionAttribute<ComercialItens, CodigoFiscalOperacao> cfop;
	public static volatile SingularAttribute<ComercialItens, Double> valBcIcms;
	public static volatile SingularAttribute<ComercialItens, Double> valIcms;
	public static volatile SingularAttribute<ComercialItens, Double> valBcIcmsSt;
	public static volatile SingularAttribute<ComercialItens, Double> valIcmsSt;
	public static volatile SingularAttribute<ComercialItens, Double> valBcIpi;
	public static volatile SingularAttribute<ComercialItens, Double> valIpi;
	public static volatile SingularAttribute<ComercialItens, Double> valBcPis;
	public static volatile SingularAttribute<ComercialItens, Double> valPis;
	public static volatile SingularAttribute<ComercialItens, Double> valBcCofins;
	public static volatile SingularAttribute<ComercialItens, Double> valCofins;
}
