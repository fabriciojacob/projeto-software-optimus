package br.com.softwareOptimus.dao.fiscal;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.util.JpaUtil;

public class GradeTributariaVigenciaDAOHibernate extends JpaUtil implements GradeTributariaVigenciaDAO {

	@Override
	public List<GradeTributariaVigencia> listaVig(GradeTributaria grade) {
		String jpql = "Select g from GradeTributariaVigencia g where g.grade = :grade";
		TypedQuery<GradeTributariaVigencia> consulta = getEntityManager()
				.createQuery(jpql, GradeTributariaVigencia.class);
		consulta.setParameter("grade", grade);
		return consulta.getResultList();
	}

	@Override
	public void remover(Long idGradeVig) {
		GradeTributariaVigencia gradeVig = getEntityManager().find(GradeTributariaVigencia.class, idGradeVig);
		beginTransaction();
		getEntityManager().remove(gradeVig);
		commitTransaction();
	}

	@Override
	public void salvaVig(GradeTributariaVigencia gradeVig) {
		beginTransaction();
		getEntityManager().persist(gradeVig);
		commitTransaction();
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
		TypedQuery<GradeTributariaVigencia> consulta = getEntityManager()
				.createQuery(jpql, GradeTributariaVigencia.class);
		consulta.setParameter("origem", origem);
		consulta.setParameter("destino", destino);
		consulta.setParameter("aliquota", aliquota);
		consulta.setParameter("io", io.ordinal());
		consulta.setParameter("tipoGrade", tipoGrade.ordinal());
		consulta.setParameter("vigencia", vigencia);
		consulta.setParameter("pauta", pauta);
		return consulta.getResultList();
	}
}
