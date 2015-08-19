package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.util.JpaUtil;

public class CategoridoDAOHibernate extends JpaUtil implements CategoriaDAO {

	@Override
	public void remover(Long idCateg) {
		beginTransaction();
		Categoria cat = getEntityManager().find(Categoria.class, idCateg);
		getEntityManager().remove(cat);
		commitTransaction();
	}

	@Override
	public List<Categoria> listarCatg(SubGrupo subGrupo) {
		String jpql = "select c from Categoria c where c.subGrupo = :subGrupo";
		TypedQuery<Categoria> cat = getEntityManager().createQuery(jpql, Categoria.class);
		cat.setParameter("subGrupo", subGrupo);
		return cat.getResultList();
	}

	@Override
	public void salvarCategoria(Categoria categoria) {
		beginTransaction();
		getEntityManager().persist(categoria);
		commitTransaction();
	}

	@Override
	public List<Produto> verificaRemCat(SubGrupo subGrupo, Long idCateg) {
		Categoria categ = getEntityManager().find(Categoria.class, idCateg);		
		String jpql = "select p from Produto p where p.subGrupo = :subGrupo and p.categoria = :categ";
		TypedQuery<Produto> prod = getEntityManager().createQuery(jpql, Produto.class);
		prod.setParameter("subGrupo", subGrupo);
		prod.setParameter("categ", categ);
		return prod.getResultList();
	}
}
