package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

public class GradeTributariaDAOHibernate implements GradeTributariaDAO {

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
	public void salvar(GradeTributaria grade) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.persist(grade);
		this.transaction.commit();
	}

	@Override
	public void altGrade(GradeTributaria grade) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.merge(grade);
		this.transaction.commit();
	}

	@Override
	public void remover(GradeTributaria grade) throws SQLException, IOException {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String deleteQuery = "delete from GradeTributariaVigencia g where g.grade = :grade";  
		Query query = session.createQuery(deleteQuery);  
		query.setParameter("grade", grade);  
		query.executeUpdate();  
		this.transaction.commit();  
		begin();
		this.session.remove(grade);
		this.transaction.commit();
	}

	@Override
	public List<GradeTributaria> listaConsultaId(long id) {
		String jpql = "Select g From GradeTributaria g Where g.idGradeTrib = :id ";
		TypedQuery<GradeTributaria> Grade = this.session.createQuery(jpql,
				GradeTributaria.class);
		Grade.setParameter("id", id);
		return Grade.getResultList();
	}

	@Override
	public List<GradeTributaria> listaConsultaDesc(String desc) {
		String jpql = "Select g From GradeTributaria g Where g.descricao LIKE :desc";
		TypedQuery<GradeTributaria> listaGrade = this.session.createQuery(jpql,
				GradeTributaria.class);
		listaGrade.setParameter("desc", "%" + desc + "%");
		return listaGrade.getResultList();
	}

	@Override
	public List<GradeTributaria> listar() {
		String jpql = "Select g From GradeTributaria g";
		TypedQuery<GradeTributaria> listaGrade = this.session.createQuery(jpql,
				GradeTributaria.class);
		return listaGrade.getResultList();
	}
	
	@Override
	public List<GradeTributaria> consGradVig() {
		String jpql = "Select g From GradeTributaria g where exists (select v from GradeTributariaVigencia v where v.grade = g)";
		TypedQuery<GradeTributaria> listaGrade = this.session.createQuery(jpql,
				GradeTributaria.class);
		return listaGrade.getResultList();
	}

	@Override
	public GradeTributaria consultaId(Long id) {
		String jpql = "Select g From GradeTributaria g Where g.idGradeTrib = :id ";
		TypedQuery<GradeTributaria> Grade = this.session.createQuery(jpql,
				GradeTributaria.class);
		Grade.setParameter("id", id);
		return Grade.getSingleResult();
	}

	@Override
	public List<FiguraFiscal> verificaRemocao(GradeTributaria grade) {
		String jpql = "Select Distinct f From FiguraFiscal f, IN(f.grades) AS g Where g.idGradeTrib = :grade";
		TypedQuery<FiguraFiscal> fig = this.session.createQuery(jpql,
				FiguraFiscal.class);
		fig.setParameter("grade", grade.getIdGradeTrib());
		return fig.getResultList();
	}

	@Override
	public int countGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, gradeTributaria, gradeTributariaVigencia);
		Query qryMaximo = this.session.createQuery(" select Count(g) from GradeTributaria g "
				 								 + " left join g.gradeTributariaVigenciaCollection gV "
				 								 + " left join gV.origem o "
				 								 + " left Join gV.destino d "
				 								 + " left join gv.pauta p ".concat(sql.toString()));
		this.defineParametros(qryMaximo, gradeTributaria, gradeTributariaVigencia);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeTributaria> buscaGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia, int first,int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, gradeTributaria, gradeTributariaVigencia);
		Query qry = this.session.createQuery(" select Count(g) from GradeTributaria g "
				                           + " left join g.gradeTributariaVigenciaCollection gV "
				                           + " left join gV.origem o "
				                           + " left Join gV.destino d "
				                           + " left join gv.pauta p ".concat(sql.toString()));
		this.defineParametros(qry, gradeTributaria, gradeTributariaVigencia);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<GradeTributaria> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql,GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia){
		
	}
	
	@Override
	public void defineParametros(Query qry, GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia){
		
	}
}
