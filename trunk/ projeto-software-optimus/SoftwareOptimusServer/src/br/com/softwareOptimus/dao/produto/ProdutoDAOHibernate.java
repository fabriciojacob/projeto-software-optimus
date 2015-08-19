package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.JpaUtil;

public class ProdutoDAOHibernate extends JpaUtil implements ProdutoDAO {

	@Override
	public void alterar(Produto produto) {
		beginTransaction();
		getEntityManager().merge(produto);
		commitTransaction();
	}
	
	@Override
	public void salvar(Produto produto) {
		beginTransaction();
		getEntityManager().persist(produto);
		commitTransaction();
	}

	@Override
	public void remover(Produto produto) {
		beginTransaction();
		getEntityManager().remove(produto);
		commitTransaction();
	}

	@Override
	public List<Produto> consultaId(long id) {
		String jpql = "select p from Produto p where p.idProduto = :id";
		TypedQuery<Produto> prod = getEntityManager()
				.createQuery(jpql, Produto.class);
		prod.setParameter("id", id);
		return prod.getResultList();
	}

	@Override
	public List<Produto> consultaDesc(String busca) {
		String jpql = "select p from Produto p where p.descProd LIKE :busca";
		TypedQuery<Produto> prod = getEntityManager()
				.createQuery(jpql, Produto.class);
		prod.setParameter("busca", "%" + busca + "%");
		return prod.getResultList();
	}

	@Override
	public List<Produto> listar() {
		String jpql = "select p from Produto p ";
		TypedQuery<Produto> prod = getEntityManager()
				.createQuery(jpql, Produto.class);
		return prod.getResultList();
	}

	@Override
	public Produto editPro(Long id) {
		Produto pro = getEntityManager().find(Produto.class, id);
		return pro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscaProdutoPaginacao(Produto produto, int first,
			int pageSize) {
		StringBuilder sql = new StringBuilder();

		this.definiCondicao(sql, produto);

		Query qry = getEntityManager().createQuery("select p from Produto p"
				.concat(sql.toString()));

		this.defineParametros(qry, produto);

		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);

		List<Produto> listResult = qry.getResultList();
		return listResult;
	}

	@Override
	public int countProdutoPaginacao(Produto produto) {
		StringBuilder sql = new StringBuilder();
		this.definiCondicao(sql, produto);
		Query qry = getEntityManager().createQuery("select count(p) from Produto p"
				.concat(sql.toString()));
		this.defineParametros(qry, produto);
		Number count = (Number) qry.getSingleResult();
		return count.intValue();
	}

	@Override
	public void definiCondicao(StringBuilder sql, Produto produto) {
		if (produto.getIdProduto() != null) {
			sql.append(sql.length() == 0 ? " Where p.idProduto = :idProduto"
					: " And p.idProduto = :idProduto");
		}
		if (produto.getDescProd() != null && !produto.getDescProd().equals("")) {
			sql.append(sql.length() == 0 ? " Where p.descProd LIKE :descProd"
					: " And p.descProd LIKE :descProd");
		}
		if (produto.getCodBarra() != null && !produto.getCodBarra().equals("")) {
			sql.append(sql.length() == 0 ? " Where p.codBarra LIKE :codBarra"
					: " And p.codBarra LIKE :codBarra");
		}
		if (produto.getFigura() != null
				&& produto.getFigura().getIdFigura() != null) {
			sql.append(sql.length() == 0 ? " Where p.figura = :figura"
					: " And p.figura = :figura");
		}
		if (produto.getUnidMed() != null
				&& produto.getUnidMed().getIdUnidMed() != null) {
			sql.append(sql.length() == 0 ? " Where p.UnidMed = :unidMed"
					: " And p.UnidMed = :unidMed");
		}
		if (produto.getTipoProd() != null
				&& produto.getTipoProd().getIdTipoProd() != null) {
			sql.append(sql.length() == 0 ? " Where p.tipoProd = :tipoProd"
					: " And p.tipoProd = :tipoProd");
		}
		sql.append(sql.length() == 0 ? " Where p.status = :status"
				: " And p.status = :status");
	}

	@Override
	public void defineParametros(Query qry, Produto produto) {
		if (produto.getIdProduto() != null) {
			qry.setParameter("idProduto", produto.getIdProduto());
		}
		if (produto.getDescProd() != null && !produto.getDescProd().equals("")) {
			qry.setParameter("descProd", "%" + produto.getDescProd() + "%");
		}
		if (produto.getCodBarra() != null && !produto.getCodBarra().equals("")) {
			qry.setParameter("codBarra", "%" + produto.getCodBarra() + "%");
		}
		if (produto.getFigura() != null
				&& produto.getFigura().getIdFigura() != null) {
			qry.setParameter("figura", produto.getFigura());
		}
		if (produto.getUnidMed() != null
				&& produto.getUnidMed().getIdUnidMed() != null) {
			qry.setParameter("unidMed", produto.getUnidMed());
		}
		if (produto.getTipoProd() != null
				&& produto.getTipoProd().getIdTipoProd() != null) {
			qry.setParameter("tipoProd", produto.getTipoProd());
		}
		qry.setParameter("status", produto.isStatus());
	}

	@Override
	public List<Produto> consultDescPag(String desc, int first, int pageSize)
			throws Exception {
		TypedQuery<Produto> qry = getEntityManager()
				.createQuery("Select p From Produto p where p.descProd like '%"
						+ desc + "%'", Produto.class);
		return qry.getResultList();
	}

	@Override
	public int countProdutoDesc(String desc) throws Exception {
		Query qry = getEntityManager()
				.createQuery("Select count(p) From Produto p where p.descProd like '%"
						+ desc + "%'");
		Number count = (Number) qry.getSingleResult();
		return count.intValue();
	}

}
