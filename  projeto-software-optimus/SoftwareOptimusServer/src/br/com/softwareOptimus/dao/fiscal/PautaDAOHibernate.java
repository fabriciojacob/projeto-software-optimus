package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.util.JpaUtil;

public class PautaDAOHibernate extends JpaUtil implements PautaDAO {
	
	@Override
	public void salvar(Pauta pauta) {
		beginTransaction();
		getEntityManager().persist(pauta);
		commitTransaction();
	}
	
	@Override
	public List<Pauta> consultaDesc(String desc) {
		String jpql = "Select p From Pauta p Where p.descricao LIKE :desc";
		TypedQuery<Pauta> listaPauta = getEntityManager().createQuery(jpql,
				Pauta.class);
		listaPauta.setParameter("desc", "%" + desc + "%");
		return listaPauta.getResultList();
	}
	
	public List<Pauta> consulta() {
		String jpql = "Select p From Pauta p ";
		TypedQuery<Pauta> listaPauta = getEntityManager().createQuery(jpql,
				Pauta.class);
		return listaPauta.getResultList();
	}
	
	public List<Pauta> consPautVig() {
		String jpql = "Select p From Pauta p Where exists (select v from PautaMVA v where v.pauta = p)";
		TypedQuery<Pauta> listaPauta = getEntityManager().createQuery(jpql,
				Pauta.class);
		return listaPauta.getResultList();
	}

	@Override
	public Pauta consultaId(Long id) {
		String jpql = "Select p From Pauta p Where p.idPauta = :id ";
		TypedQuery<Pauta> Pauta = getEntityManager().createQuery(jpql,
				Pauta.class);
		Pauta.setParameter("id", id);
		return Pauta.getSingleResult();
	}
	
	@Override
	public List<Pauta> listaConsultaId(Long id) {
		String jpql = "Select p From Pauta p Where p.idPauta = :id ";
		TypedQuery<Pauta> listaPauta = getEntityManager().createQuery(jpql,
				Pauta.class);
		listaPauta.setParameter("id", id);
		return listaPauta.getResultList();
	}
	
	@Override
	public void alterar(Pauta pauta) {
		beginTransaction();
		getEntityManager().merge(pauta);
		commitTransaction();
	}
	@Override
	public void remover(Pauta pauta) throws IOException, SQLException {
		beginTransaction();
		String deleteQuery = "delete from PautaMVA p where p.pauta = :pauta";  
		Query query = getEntityManager().createQuery(deleteQuery);  
		query.setParameter("pauta", pauta);  
		query.executeUpdate();  
		beginTransaction();
		getEntityManager().remove(pauta);
		commitTransaction();
	}
	@Override
	public List<GradeTributariaVigencia> verificaRemocao(Pauta pauta) {
		String jpql = "Select g From GradeTributariaVigencia g Where g.pauta = :pauta ";
		TypedQuery<GradeTributariaVigencia> listaGrade = getEntityManager().createQuery(jpql,
				GradeTributariaVigencia.class);
		listaGrade.setParameter("pauta", pauta);
		return listaGrade.getResultList();
	}
	@Override
	public int countPautaPaginacao(Pauta pauta) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, pauta);
		Query qryMaximo = getEntityManager().createQuery("select Count(p) from Pauta p ".concat(sql.toString()));
		this.defineParametros(qryMaximo, pauta);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pauta> buscaPautaPaginacao(Pauta pauta, int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, pauta);
		Query qry = getEntityManager().createQuery("select p from Pauta p ".concat(sql.toString()));
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
