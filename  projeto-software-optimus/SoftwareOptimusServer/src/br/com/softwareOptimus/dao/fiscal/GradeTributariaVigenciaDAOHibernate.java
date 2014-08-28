package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;

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
		String jpql = "Select g from GradeTributariaVigencia g where g.grade = :grade";
		TypedQuery<GradeTributariaVigencia> consulta = this.session
				.createQuery(jpql, GradeTributariaVigencia.class);
		consulta.setParameter("grade", grade);
		return consulta.getResultList();
	}

	@Override
	public void remover(Long idGradeVig) {
		GradeTributariaVigencia gradeVig = this.session.find(
				GradeTributariaVigencia.class, idGradeVig);
		this.session.remove(gradeVig);
		this.transaction.commit();
	}

	@Override
	public void salvaVig(GradeTributariaVigencia gradeVig) {
		this.session.persist(gradeVig);
		this.transaction.commit();
	}

	@Override
	public List<GradeTributariaVigencia> validaInclusao(Estado origem, Estado destino,
			Aliquota aliquota, IO io, TipoPessoaJuridica tipoGrade,
			Date vigencia, Pauta pauta) {
		String jpql = "Select g from GradeTributariaVigencia g " +
					  " Where g.origem = :origem " +
					  "   And g.destino = :destino " +
					  "   And g.aliquota = :aliquota " +
					  "   And g.io = :io " +
					  "   And g.tipoGrade = :tipoGrade " +
					  "   And g.vigencia = :vigencia " +
					  "   And g.pauta = :pauta ";
		TypedQuery<GradeTributariaVigencia> consulta = this.session
				.createQuery(jpql, GradeTributariaVigencia.class);
		consulta.setParameter("origem", origem);
		consulta.setParameter("destino", destino);
		consulta.setParameter("aliquota", aliquota);
		consulta.setParameter("io", io);
		consulta.setParameter("tipoGrade", tipoGrade);
		consulta.setParameter("vigencia", vigencia);
		consulta.setParameter("pauta", pauta);
		return consulta.getResultList();
	}
}
