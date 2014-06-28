package softwareOptimus.com.produto;

import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.producao.ProdutoFilho;
import br.com.softwareOptimus.producao.ProdutoPrincipal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-06-28T15:04:41.498-0300")
@StaticMetamodel(Produto.class)
public class Produto_ {
	public static volatile SingularAttribute<Produto, Long> idProduto;
	public static volatile SingularAttribute<Produto, String> descProd;
	public static volatile SingularAttribute<Produto, String> codBarra;
	public static volatile SingularAttribute<Produto, ProdutoEstoque> estoque;
	public static volatile SingularAttribute<Produto, ProdutoFilho> prodFilho;
	public static volatile SingularAttribute<Produto, ProdutoPrincipal> prodPrincipal;
	public static volatile SingularAttribute<Produto, FiguraFiscal> figura;
	public static volatile SingularAttribute<Produto, UnidMed> UnidMed;
	public static volatile SingularAttribute<Produto, String> tipoProd;
	public static volatile SingularAttribute<Produto, Ncm> ncm;
}
