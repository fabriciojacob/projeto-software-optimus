package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.util.JpaUtil;

public class GrupoDAOHibernate extends JpaUtil implements GrupoDAO {

	public void salvar(Grupo grupo) {
		beginTransaction();
		getEntityManager().persist(grupo);
		commitTransaction();
	}

	public void alterar(Grupo grupo) {
		beginTransaction();
		getEntityManager().merge(grupo);
		commitTransaction();
	}

	@Override
	public List<Setor> verificaRemocao(Grupo grupo) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.idGrupo = :grupo";
		TypedQuery<Setor> set = getEntityManager().createQuery(jpql, Setor.class);
		set.setParameter("grupo", grupo.getIdGrupo());
		return set.getResultList();
	}

	@Override
	public void remover(Grupo grupo) {
		beginTransaction();
		getEntityManager().remove(grupo);
		commitTransaction();
	}

	@Override
	public List<Grupo> consultaId(long parseLong) {
		String jpql = "Select g From Grupo g Where g.idGrupo = :grupo";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("grupo", parseLong);
		return gru.getResultList();
	}

	@Override
	public List<Grupo> consultaDesc(String busca) {
		String jpql = "Select g From Grupo g Where g.descricao LIKE :grupo";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("grupo", "%" + busca + "%");
		return gru.getResultList();
	}

	@Override
	public List<Grupo> lista() {
		String jpql = "Select g From Grupo g ";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		return gru.getResultList();
	}

	@Override
	public Grupo editGrupo(Long id) {
		Grupo gru = getEntityManager().find(Grupo.class, id);
		return gru;
	}

	@Override
	public List<Grupo> listaGrupo() {
		String jpql = "Select g From Grupo g ";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql,
				Grupo.class);
		return gru.getResultList();
	}

	@Override
	public List<Produto> VerificaRemGrupoProd(Grupo grupo) {
		String jpql = "select p from Produto p where p.grupo = :grupo";
		TypedQuery<Produto> prod = getEntityManager().createQuery(jpql, Produto.class);
		prod.setParameter("grupo", grupo);
		return prod.getResultList();
	}

	@Override
	public List<Produto> verificaRemSubGrupo(Grupo grupo, Long idSub) {
		SubGrupo subGru = getEntityManager().find(SubGrupo.class, idSub);		
		String jpql = "select p from Produto p where p.grupo = :grupo and p.subGrupo = :subGru";
		TypedQuery<Produto> prod = getEntityManager().createQuery(jpql, Produto.class);
		prod.setParameter("grupo", grupo);
		prod.setParameter("subGru", subGru);
		return prod.getResultList();
	}

	@Override
	public List<Grupo> listaGrupoVincSet(Setor setor) {
		String jpql = "Select Distinct g From Setor s, IN(s.grupo) AS g Where s = :setor";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("setor", setor);
		return gru.getResultList();
	}

	@Override
	public List<Grupo> listaGrupoIdSub(long idSub) {
		String jpql = "Select Distinct g From Grupo g, IN(s.subGrupo) AS s Where s.idSubGrupo = :idSub";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("idSub", idSub);
		return gru.getResultList();
	}

	@Override
	public List<Grupo> listaGrupoDescSub(String busca) {
		String jpql = "Select Distinct g From Grupo g, IN(s.subGrupo) AS s Where s.descricao LIKE :busca";
		TypedQuery<Grupo> gru = getEntityManager().createQuery(jpql, Grupo.class);
		gru.setParameter("busca", "%" + busca + "%");
		return gru.getResultList();
	}

	@Override
	public int countGrupoPaginacao(Grupo grupo, SubGrupo subGrupo) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, grupo, subGrupo);
		Query qryMaximo = getEntityManager().createQuery(" select Count(g) from Grupo g "
				 								 + " left join g.subGrupo s ".concat(sql.toString()));
		this.defineParametros(qryMaximo, grupo, subGrupo);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> buscaGrupoPaginacao(Grupo grupo, SubGrupo subGrupo,int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, grupo, subGrupo);
		Query qry = getEntityManager().createQuery("select g from Grupo g "
										   + " left join g.subGrupo s ".concat(sql.toString()));
		this.defineParametros(qry, grupo, subGrupo);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<Grupo> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, Grupo grupo, SubGrupo subGrupo){
 		if(subGrupo.getIdSubGrupo() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" s.idSubGrupo = :idSubGrupo");
		}
 		if(grupo.getIdGrupo() != null){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.idGrupo = :idGrupo");
 		}
 		if(grupo.getDescricao() != null && grupo.getDescricao() != "" && !grupo.getDescricao().equals("")){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.descricao like :descricao");
 		}
	}
	
	@Override
	public void defineParametros(Query qry, Grupo grupo, SubGrupo subGrupo){
		if(subGrupo.getIdSubGrupo() != null){
			qry.setParameter("idSubGrupo", subGrupo.getIdSubGrupo());
		}
 		if(grupo.getIdGrupo() != null){
 			qry.setParameter("idGrupo", grupo.getIdGrupo());
 		}
 		if(grupo.getDescricao() != null && grupo.getDescricao() != "" && !grupo.getDescricao().equals("")){
 			qry.setParameter("descricao", "%" + grupo.getDescricao() + "%");
 		}
	}
}
