package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.util.JpaUtil;

public class UnidMedDAOHibernate extends JpaUtil implements UnidMedDAO {

	@Override
	public void salvar(UnidMed unid) {
		beginTransaction();
		getEntityManager().persist(unid);
		commitTransaction();
	}
	
	public void remover(Long unid) throws Exception{
		beginTransaction();
		UnidMed unidMed = getEntityManager().find(UnidMed.class, unid);
		getEntityManager().remove(unidMed);
		commitTransaction();
	}

	public List<UnidMed> consultarId(Long id) {
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = getEntityManager().createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarUnid(String unid) {
		String jpql = "Select u From UnidMed u Where u.unid LIKE :unid";
		TypedQuery<UnidMed> listaUnidade = getEntityManager().createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("unid", "%" + unid + "%");
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarDesc(String desc) {
		String jpql = "Select u From UnidMed u Where u.descUnid LIKE :desc";
		TypedQuery<UnidMed> listaUnidade = getEntityManager().createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("desc", "%" + desc + "%");
		return listaUnidade.getResultList();
	}
	
	public List<UnidMed> lista() {
		String jpql = "Select u From UnidMed u";
		TypedQuery<UnidMed> listaUnidade = getEntityManager().createQuery(jpql,
				UnidMed.class);
		return listaUnidade.getResultList();
	}
	
	public UnidMed editBusc(Long id){
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = getEntityManager().createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getSingleResult();
	}
	
	public void altUnid(UnidMed unidMed) throws Exception{
		beginTransaction();
		getEntityManager().merge(unidMed);
		commitTransaction();
	}

	@Override
	public int countUnidadeMedidaPaginacao(UnidMed unidMed) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, unidMed);
		Query qryMaximo = getEntityManager().createQuery("select Count(u) from UnidMed u ".concat(sql.toString()));
		this.defineParametros(qryMaximo, unidMed);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidMed> buscaUnidadeMedidaPaginacao(UnidMed unidMed,int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, unidMed);
		Query qry = getEntityManager().createQuery("select u from UnidMed u ".concat(sql.toString()));
		this.defineParametros(qry,  unidMed);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<UnidMed> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, UnidMed unidMed){
		if(unidMed.getIdUnidMed() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" u.idUnidMed = :idUnidMed");
		}
		if(unidMed.getUnid() != null && unidMed.getUnid() != ""){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" u.unid like :unid");
		}
		if(unidMed.getDescUnid() != null && unidMed.getDescUnid() != ""){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" u.descUnid like :descUnid");
		}
	}
	
	@Override
	public void defineParametros(Query qry,UnidMed unidMed){
		if(unidMed.getIdUnidMed() != null){
			qry.setParameter("idUnidMed", unidMed.getIdUnidMed());
		}
		if(unidMed.getUnid() != null && unidMed.getUnid() != ""){
			qry.setParameter("unid", "%" + unidMed.getUnid() + "%");
		}
		if(unidMed.getDescUnid() != null && unidMed.getDescUnid() != ""){
			qry.setParameter("descUnid", "%" + unidMed.getDescUnid() + "%");
		}
	}
}
