package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.UnidMed;

public class UnidMedDAOHibernate implements UnidMedDAO {

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
	public void salvar(UnidMed unid) {
		try {
			this.begin();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.session.persist(unid);
		this.transaction.commit();
	}
	
	public void remover(Long unid) throws Exception{
		this.begin();
		UnidMed unidMed = this.session.find(UnidMed.class, unid);
		this.session.remove(unidMed);
		this.transaction.commit();
	}

	public List<UnidMed> consultarId(Long id) {
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarUnid(String unid) {
		String jpql = "Select u From UnidMed u Where u.unid LIKE :unid";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("unid", "%" + unid + "%");
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarDesc(String desc) {
		String jpql = "Select u From UnidMed u Where u.descUnid LIKE :desc";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("desc", "%" + desc + "%");
		return listaUnidade.getResultList();
	}
	
	public List<UnidMed> lista() {
		String jpql = "Select u From UnidMed u";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		return listaUnidade.getResultList();
	}
	
	public UnidMed editBusc(Long id){
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getSingleResult();
	}
	
	public void altUnid(UnidMed unidMed) throws Exception{
		this.begin();
		this.session.merge(unidMed);
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
	public int countUnidadeMedidaPaginacao(UnidMed unidMed) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, unidMed);
		Query qryMaximo = this.session.createQuery("select Count(u) from UnidMed u ".concat(sql.toString()));
		this.defineParametros(qryMaximo, unidMed);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidMed> buscaUnidadeMedidaPaginacao(UnidMed unidMed,int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, unidMed);
		Query qry = this.session.createQuery("select u from UnidMed u ".concat(sql.toString()));
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
