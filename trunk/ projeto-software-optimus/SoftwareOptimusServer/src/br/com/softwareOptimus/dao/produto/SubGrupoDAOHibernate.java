package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.util.JpaUtil;

public class SubGrupoDAOHibernate extends JpaUtil implements SubGrupoDAO {

	@Override
	public void salvar(SubGrupo subGrupo) {
		beginTransaction();
		getEntityManager().persist(subGrupo);
		commitTransaction();
	}

	@Override
	public void altSub(SubGrupo subGrupo) {
		beginTransaction();
		getEntityManager().merge(subGrupo);
		commitTransaction();
	}

	@Override
	public List<Grupo> verificaRemocao(SubGrupo subGrupo) {
		String jpql = "Select Distinct g From Grupo g, IN(g.subGrupo) AS s Where s.idSubGrupo = :subGrupo";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("subGrupo", subGrupo.getIdSubGrupo());
		return gru.getResultList();
	}

	@Override
	public void remover(SubGrupo subGrupo) throws IOException, SQLException {
		beginTransaction();
		String deleteQuery = "delete from Categoria c where c.subGrupo = :subGrupo";
		Query query = getEntityManager().createQuery(deleteQuery);
		query.setParameter("subGrupo", subGrupo);
		query.executeUpdate();
		commitTransaction();
		beginTransaction();
		getEntityManager().remove(subGrupo);
		commitTransaction();
	}

	@Override
	public List<SubGrupo> listar() {
		String jpql = "Select s From SubGrupo s ";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql,
				SubGrupo.class);
		return subGru.getResultList();
	}

	@Override
	public List<SubGrupo> consultaId(long parseLong) {
		String jpql = "Select s From SubGrupo s Where s.idSubGrupo = :subGrupo";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql,
				SubGrupo.class);
		subGru.setParameter("subGrupo", parseLong);
		return subGru.getResultList();
	}

	@Override
	public List<SubGrupo> consultaDesc(String busca) {
		String jpql = "Select s From SubGrupo s Where s.descricao LIKE :subGrupo";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql,
				SubGrupo.class);
		subGru.setParameter("subGrupo", "%" + busca + "%");
		return subGru.getResultList();
	}

	@Override
	public SubGrupo editSub(Long id) {
		String jpql = "Select s From SubGrupo s Where s.idSubGrupo = :subGrupo";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql,
				SubGrupo.class);
		subGru.setParameter("subGrupo", id);
		return subGru.getSingleResult();
	}

	@Override
	public List<SubGrupo> listaSubGrupo() {
		String jpql = "select s from SubGrupo s where exists (select c from Categoria c where c.subGrupo = s)";
		TypedQuery<SubGrupo> listaSub = getEntityManager().createQuery(jpql,
				SubGrupo.class);
		return listaSub.getResultList();
	}

	@Override
	public List<SubGrupo> listaSubGru(Long id) {
		String jpql = "Select Distinct s From Grupo g, IN(g.subGrupo) AS s Where g.idGrupo = :Grupo";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql, SubGrupo.class);
		subGru.setParameter("Grupo", id);
		return subGru.getResultList();
	}

	@Override
	public List<Produto> verificaRemocaoSubProd(SubGrupo subGrupo) {
		String jpql = "select p from Produto p where p.subGrupo = :subGrupo";
		TypedQuery<Produto> prod = getEntityManager().createQuery(jpql, Produto.class);
		prod.setParameter("subGrupo", subGrupo);
		return prod.getResultList();
	}

	@Override
	public List<SubGrupo> listaSubGrupoVincGrupo(Grupo grupo) {
		String jpql = "Select Distinct s From Grupo g, IN(g.subGrupo) AS s Where g = :grupo";
		TypedQuery<SubGrupo> subGru = getEntityManager().createQuery(jpql, SubGrupo.class);
		subGru.setParameter("grupo", grupo);
		return subGru.getResultList();
	}

	@Override
	public int countSubGrupoPaginacao(SubGrupo subGrupo) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, subGrupo);
		Query qryMaximo = getEntityManager().createQuery("select Count(s) from SubGrupo s ".concat(sql.toString()));
		this.defineParametros(qryMaximo, subGrupo);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubGrupo> buscaSubGrupoPaginacao(SubGrupo subGrupo, int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, subGrupo);
		Query qry = getEntityManager().createQuery("select s from SubGrupo s ".concat(sql.toString()));
		this.defineParametros(qry, subGrupo);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<SubGrupo> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, SubGrupo subGrupo){
		if(subGrupo.getIdSubGrupo() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" s.idSubGrupo = :idSubGrupo");	
		}
		if(subGrupo.getDescricao() != null && !subGrupo.getDescricao().equals("")){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" s.descricao like :descricao");
		}
	}
	
	@Override
	public void defineParametros(Query qry, SubGrupo subGrupo){
		if(subGrupo.getIdSubGrupo() != null){
			qry.setParameter("idSubGrupo", subGrupo.getIdSubGrupo());
		}
		if(subGrupo.getDescricao() != null && !subGrupo.getDescricao().equals("")){
			qry.setParameter("descricao","%" + subGrupo.getDescricao() + "%");
		}
	}
}
