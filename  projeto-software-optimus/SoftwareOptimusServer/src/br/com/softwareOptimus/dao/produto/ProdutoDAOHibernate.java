package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

}
