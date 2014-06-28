package softwareOptimus.com.produto;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.500-0300")
@StaticMetamodel(UnidMed.class)
public class UnidMed_ {
	public static volatile SingularAttribute<UnidMed, Long> idUnidMed;
	public static volatile SingularAttribute<UnidMed, String> unid;
	public static volatile SingularAttribute<UnidMed, String> descUnid;
	public static volatile CollectionAttribute<UnidMed, Produto> produtos;
}
