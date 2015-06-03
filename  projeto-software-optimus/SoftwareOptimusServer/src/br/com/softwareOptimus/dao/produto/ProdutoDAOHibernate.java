package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Produto;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private EntityManager session;
	private EntityTransaction transaction;
	
	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public void salvar(Produto produto) {
		this.session.persist(produto);
		this.transaction.commit();
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction.begin();
		}
	}
	
	@Override
	public void close() throws Exception {
		this.session.close();
	}

	@Override
	public void alterar(Produto produto) {
		this.session.merge(produto);
		this.transaction.commit();
	}

	@Override
	public void remover(Produto produto) {
		this.session.remove(produto);
		this.transaction.commit();
	}

	@Override
	public List<Produto> consultaId(long id) {
		String jpql = "select p from Produto p where p.idProduto = :id";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("id", id);
		return prod.getResultList();
	}

	@Override
	public List<Produto> consultaDesc(String busca) {
		String jpql = "select p from Produto p where p.descProd LIKE :busca";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("busca","%" + busca + "%");
		return prod.getResultList();
	}

	@Override
	public List<Produto> listar() {
		String jpql = "select p from Produto p ";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		return prod.getResultList();
	}

	@Override
	public Produto editPro(Long id) {
		Produto pro = this.session.find(Produto.class, id);
		return pro;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscaProdutoPaginacao(Produto produto, int first, int pageSize){
		StringBuilder sql = new StringBuilder();
		
		this.definiCondicao(sql, produto);
		
		Query qry = this.session.createQuery("select p from Produto p".concat(sql.toString()));
		
		this.defineParametros(qry, produto);
		
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		
		List<Produto> listResult = qry.getResultList();
		return listResult;
	}
	
	@Override
	public int countProdutoPaginacao(Produto produto){
		StringBuilder sql = new StringBuilder();
		this.definiCondicao(sql, produto);
		Query qry = this.session.createQuery("select count(p) from Produto p".concat(sql.toString()));
		this.defineParametros(qry, produto);
		Number count = (Number) qry.getSingleResult();
		return count.intValue();
	}
	
	@Override
	public void definiCondicao(StringBuilder sql, Produto produto){
		if(produto.getIdProduto() != null){
			sql.append(sql.length() == 0 ? " Where p.idProduto = :idProduto" : " And p.idProduto = :idProduto");
		}
		if(produto.getDescProd() != null && !produto.getDescProd().equals("")){
			sql.append(sql.length() == 0 ? " Where p.descProd LIKE :descProd": " And p.descProd LIKE :descProd");
		}
		if(produto.getCodBarra() != null && !produto.getCodBarra().equals("")){
			sql.append(sql.length() == 0 ? " Where p.codBarra LIKE :codBarra": " And p.codBarra LIKE :codBarra");
		}
		if(produto.getFigura() != null && produto.getFigura().getIdFigura() != null){
			sql.append(sql.length() == 0 ? " Where p.figura = :figura": " And p.figura = :figura");
		}
		if(produto.getUnidMed() != null && produto.getUnidMed().getIdUnidMed() != null){
			sql.append(sql.length() == 0 ? " Where p.UnidMed = :unidMed": " And p.UnidMed = :unidMed");
		}
		if(produto.getTipoProd() != null && produto.getTipoProd().getIdTipoProd() != null){
			sql.append(sql.length() == 0 ? " Where p.tipoProd = :tipoProd": " And p.tipoProd = :tipoProd");
		}
		sql.append(sql.length() == 0 ? " Where p.status = :status": " And p.status = :status");
	}
	
	@Override
	public void defineParametros(Query qry, Produto produto){
		if(produto.getIdProduto() != null){
			qry.setParameter("idProduto", produto.getIdProduto());
		}
		if(produto.getDescProd() != null && !produto.getDescProd().equals("")){
			qry.setParameter("descProd", "%" + produto.getDescProd() + "%");
		}
		if(produto.getCodBarra() != null && !produto.getCodBarra().equals("")){
			qry.setParameter("codBarra", "%" + produto.getCodBarra() + "%");
		}
		if(produto.getFigura() != null && produto.getFigura().getIdFigura() != null){
			qry.setParameter("figura", produto.getFigura());
		}
		if(produto.getUnidMed() != null && produto.getUnidMed().getIdUnidMed() != null){
			qry.setParameter("unidMed", produto.getUnidMed());
		}
		if(produto.getTipoProd() != null && produto.getTipoProd().getIdTipoProd() != null){
			qry.setParameter("tipoProd", produto.getTipoProd());
		}
		qry.setParameter("status", produto.isStatus());
	}
}
