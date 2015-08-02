package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;

public class PautaDAOHibernate implements PautaDAO {
	
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
	public void salvar(Pauta pauta) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.persist(pauta);
		this.transaction.commit();
	}
	
	@Override
	public List<Pauta> consultaDesc(String desc) {
		String jpql = "Select p From Pauta p Where p.descricao LIKE :desc";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		listaPauta.setParameter("desc", "%" + desc + "%");
		return listaPauta.getResultList();
	}
	
	public List<Pauta> consulta() {
		String jpql = "Select p From Pauta p ";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		return listaPauta.getResultList();
	}
	
	public List<Pauta> consPautVig() {
		String jpql = "Select p From Pauta p Where exists (select v from PautaMVA v where v.pauta = p)";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		return listaPauta.getResultList();
	}

	@Override
	public Pauta consultaId(Long id) {
		String jpql = "Select p From Pauta p Where p.idPauta = :id ";
		TypedQuery<Pauta> Pauta = this.session.createQuery(jpql,
				Pauta.class);
		Pauta.setParameter("id", id);
		return Pauta.getSingleResult();
	}
	
	@Override
	public List<Pauta> listaConsultaId(Long id) {
		String jpql = "Select p From Pauta p Where p.idPauta = :id ";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		listaPauta.setParameter("id", id);
		return listaPauta.getResultList();
	}
	
	@Override
	public void alterar(Pauta pauta) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.merge(pauta);
		this.transaction.commit();
	}
	@Override
	public void remover(Pauta pauta) throws IOException, SQLException {
		if (!transaction.isActive()) {
			transaction.begin();
		}		
		String deleteQuery = "delete from PautaMVA p where p.pauta = :pauta";  
		Query query = session.createQuery(deleteQuery);  
		query.setParameter("pauta", pauta);  
		query.executeUpdate();  
		this.transaction.commit();  
		begin();		
		this.session.remove(pauta);
		this.transaction.commit();
	}
	@Override
	public List<GradeTributariaVigencia> verificaRemocao(Pauta pauta) {
		String jpql = "Select g From GradeTributariaVigencia g Where g.pauta = :pauta ";
		TypedQuery<GradeTributariaVigencia> listaGrade = this.session.createQuery(jpql,
				GradeTributariaVigencia.class);
		listaGrade.setParameter("pauta", pauta);
		return listaGrade.getResultList();
	}
	@Override
	public int countPautaPaginacao(Pauta pauta) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, pauta);
		Query qryMaximo = this.session.createQuery("select Count(p) from Pauta p ".concat(sql.toString()));
		this.defineParametros(qryMaximo, pauta);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pauta> buscaPautaPaginacao(Pauta pauta, int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, pauta);
		Query qry = this.session.createQuery("select p from Pauta p ".concat(sql.toString()));
		this.defineParametros(qry, pauta);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<Pauta> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, Pauta pauta){
		if(pauta.getIdPauta() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" p.idPauta = :idPauta");
		}
		if(pauta.getDescricao() != null && pauta.getDescricao() != "" && !pauta.getDescricao().equals("")){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" p.descricao like :descricao");
		}
	}
	
	@Override
	public void defineParametros(Query qry, Pauta pauta){
		if(pauta.getIdPauta() != null){
			qry.setParameter("idPauta", pauta.getIdPauta());
		}
		if(pauta.getDescricao() != null && pauta.getDescricao() != "" && !pauta.getDescricao().equals("")){
			qry.setParameter("descricao", "%" + pauta.getDescricao() + "%");
		}
	}
}
