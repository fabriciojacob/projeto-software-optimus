package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

public class GradeTributariaVigenciaDAOHibernate implements
		GradeTributariaVigenciaDAO {

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
	public List<GradeTributariaVigencia> listaVig(GradeTributaria grade) {
		String jpql = "Select g from GradeTributaria g where g.grade = :parGrade";
		TypedQuery<GradeTributariaVigencia> consulta = this.session.createQuery(jpql,
				GradeTributariaVigencia.class);
		consulta.setParameter("parPauta", grade);
		return consulta.getResultList();
	}

	@Override
	public void remover(Long idGradeVig) {
		GradeTributariaVigencia gradeVig = this.session.find(GradeTributariaVigencia.class, idGradeVig);
		this.session.remove(gradeVig);
		this.transaction.commit();
	}

	@Override
	public void salvaVig(GradeTributariaVigencia gradeVig) {
		this.session.persist(gradeVig);
		this.transaction.commit();
	}
}
