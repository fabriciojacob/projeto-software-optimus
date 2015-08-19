package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.util.JpaUtil;

public class GradeTributariaDAOHibernate extends JpaUtil implements GradeTributariaDAO {

	@Override
	public void salvar(GradeTributaria grade) {
		beginTransaction();
		getEntityManager().persist(grade);
		commitTransaction();
	}

	@Override
	public void altGrade(GradeTributaria grade) {
		beginTransaction();
		getEntityManager().merge(grade);
		commitTransaction();
	}

	@Override
	public void remover(GradeTributaria grade) throws SQLException, IOException {
		beginTransaction();
		String deleteQuery = "delete from GradeTributariaVigencia g where g.grade = :grade";  
		Query query = getEntityManager().createQuery(deleteQuery);  
		query.setParameter("grade", grade);  
		query.executeUpdate();  
		beginTransaction();
		getEntityManager().remove(grade);
		commitTransaction();
	}

	@Override
	public List<GradeTributaria> listaConsultaId(long id) {
		String jpql = "Select g From GradeTributaria g Where g.idGradeTrib = :id ";
		TypedQuery<GradeTributaria> Grade = getEntityManager().createQuery(jpql,GradeTributaria.class);
		Grade.setParameter("id", id);
		return Grade.getResultList();
	}

	@Override
	public List<GradeTributaria> listaConsultaDesc(String desc) {
		String jpql = "Select g From GradeTributaria g Where g.descricao LIKE :desc";
		TypedQuery<GradeTributaria> listaGrade = getEntityManager().createQuery(jpql,GradeTributaria.class);
		listaGrade.setParameter("desc", "%" + desc + "%");
		return listaGrade.getResultList();
	}

	@Override
	public List<GradeTributaria> listar() {
		String jpql = "Select g From GradeTributaria g";
		TypedQuery<GradeTributaria> listaGrade = getEntityManager().createQuery(jpql,
				GradeTributaria.class);
		return listaGrade.getResultList();
	}
	
	@Override
	public List<GradeTributaria> consGradVig() {
		String jpql = "Select g From GradeTributaria g where exists (select v from GradeTributariaVigencia v where v.grade = g)";
		TypedQuery<GradeTributaria> listaGrade = getEntityManager().createQuery(jpql,
				GradeTributaria.class);
		return listaGrade.getResultList();
	}

	@Override
	public GradeTributaria consultaId(Long id) {
		String jpql = "Select g From GradeTributaria g Where g.idGradeTrib = :id ";
		TypedQuery<GradeTributaria> Grade = getEntityManager().createQuery(jpql,
				GradeTributaria.class);
		Grade.setParameter("id", id);
		return Grade.getSingleResult();
	}

	@Override
	public List<FiguraFiscal> verificaRemocao(GradeTributaria grade) {
		String jpql = "Select Distinct f From FiguraFiscal f, IN(f.grades) AS g Where g.idGradeTrib = :grade";
		TypedQuery<FiguraFiscal> fig = getEntityManager().createQuery(jpql,
				FiguraFiscal.class);
		fig.setParameter("grade", grade.getIdGradeTrib());
		return fig.getResultList();
	}

	@Override
	public int countGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, gradeTributaria, gradeTributariaVigencia);
		Query qryMaximo = getEntityManager().createQuery(" select Count(g) from GradeTributaria g "
				 								 + " left join g.gradeTributariaVigenciaCollection gV "
				 								 + " left join gV.origem o "
				 								 + " left Join gV.destino d "
				 								 + " left join gV.pauta p ".concat(sql.toString()));
		this.defineParametros(qryMaximo, gradeTributaria, gradeTributariaVigencia);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeTributaria> buscaGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia, int first,int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, gradeTributaria, gradeTributariaVigencia);
		Query qry = getEntityManager().createQuery(" select g from GradeTributaria g "
				                           + " left join g.gradeTributariaVigenciaCollection gV "
				                           + " left join gV.origem o "
				                           + " left Join gV.destino d "
				                           + " left join gV.pauta p ".concat(sql.toString()));
		this.defineParametros(qry, gradeTributaria, gradeTributariaVigencia);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<GradeTributaria> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql,GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia){
		if(gradeTributaria.getIdGradeTrib() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.idGradeTrib = :idGradeTrib");
		}
		if(gradeTributaria.getDescricao() != null && gradeTributaria.getDescricao() != "" && !gradeTributaria.getDescricao().equals("")){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.descricao like :descricao");
		}
		if(gradeTributariaVigencia.getPauta() != null && gradeTributariaVigencia.getPauta().getIdPauta() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" p.idPauta = :idPauta");
		}
		if(gradeTributariaVigencia.getOrigem() != null && gradeTributariaVigencia.getOrigem().getIdUf() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" o.idUf = :idUfOr");
		}
		if(gradeTributariaVigencia.getDestino() != null && gradeTributariaVigencia.getDestino().getIdUf() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" d.idUf = :idUfDe");
		}
	}
	
	@Override
	public void defineParametros(Query qry, GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia){
		if(gradeTributaria.getIdGradeTrib() != null){
			qry.setParameter("idGradeTrib", gradeTributaria.getIdGradeTrib());
		}
		if(gradeTributaria.getDescricao() != null && gradeTributaria.getDescricao() != "" && !gradeTributaria.getDescricao().equals("")){
			qry.setParameter("descricao", "%" + gradeTributaria.getDescricao() + "%");
		}
		if(gradeTributariaVigencia.getPauta() != null && gradeTributariaVigencia.getPauta().getIdPauta() != null){
			qry.setParameter("idPauta", gradeTributariaVigencia.getPauta().getIdPauta());
		}
		if(gradeTributariaVigencia.getOrigem() != null && gradeTributariaVigencia.getOrigem().getIdUf() != null){
			qry.setParameter("idUfOr", gradeTributariaVigencia.getOrigem().getIdUf());
		}
		if(gradeTributariaVigencia.getDestino() != null && gradeTributariaVigencia.getDestino().getIdUf() != null){
			qry.setParameter("idUfDe", gradeTributariaVigencia.getDestino().getIdUf());
		}
	}
}
