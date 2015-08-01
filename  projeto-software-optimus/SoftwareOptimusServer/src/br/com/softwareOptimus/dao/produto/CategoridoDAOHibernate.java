package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;

public class CategoridoDAOHibernate implements CategoriaDAO {

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
	public void remover(Long idCateg) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Categoria cat = this.session.find(Categoria.class, idCateg);
		this.session.remove(cat);
		this.transaction.commit();
	}

	@Override
	public List<Categoria> listarCatg(SubGrupo subGrupo) {
		String jpql = "select c from Categoria c where c.subGrupo = :subGrupo";
		TypedQuery<Categoria> cat = this.session.createQuery(jpql, Categoria.class);
		cat.setParameter("subGrupo", subGrupo);
		return cat.getResultList();
	}

	@Override
	public void salvarCategoria(Categoria categoria) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.persist(categoria);
		this.transaction.commit();
	}

	@Override
	public List<Produto> verificaRemCat(SubGrupo subGrupo, Long idCateg) {
		Categoria categ = this.session.find(Categoria.class, idCateg);		
		String jpql = "select p from Produto p where p.subGrupo = :subGrupo and p.categoria = :categ";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("subGrupo", subGrupo);
		prod.setParameter("categ", categ);
		return prod.getResultList();
	}
}
