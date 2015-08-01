package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;

public class SetorDAOHibernate implements SetorDAO {
	
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
	public void salvar(Setor setor) {
		this.session.persist(setor);
		this.transaction.commit();
	}

	@Override
	public void altSet(Setor setor) {
		this.session.merge(setor);
		this.transaction.commit();
	}

	@Override
	public List<Produto> verProdSet(Setor setor) {
		String jpql = "select p from Produto p where p.setor = :setor";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("setor", setor);
		return prod.getResultList();
	}

	@Override
	public void remove(Setor setor) {
		this.session.remove(setor);
		this.transaction.commit();
	}

	@Override
	public List<Setor> listar() {
		String jpql = "select s from Setor s";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaId(long setor) {
		String jpql = "Select s from Setor s where s.idSetor = :setor";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("setor", setor);
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaDesc(String setor) {
		String jpql = "Select s from Setor s where s.descricao LIKE :setor";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("setor","%" +  setor + "%");
		return set.getResultList();
	}

	@Override
	public List<Produto> verRemRelGrup(Setor setor, Long idGrup) {
		Grupo grupo = this.session.find(Grupo.class, idGrup);		
		String jpql = "select p from Produto p where p.setor = :setor and p.grupo = :grupo";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("setor", setor);
		prod.setParameter("grupo", grupo);
		return prod.getResultList();
	}

	@Override
	public Setor editSet(Long id) {
		Setor set = this.session.find(Setor.class, id);
		return set;
	}

	@Override
	public List<Setor> consultaDescGrup(String busca) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.descricao LIKE :busca";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("busca", "%" + busca + "%");
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaIdGrup(long idGrup) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.idGrupo = :idGrup";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("idGrup", idGrup);
		return set.getResultList();
	}

	@Override
	public int countSetorPaginacao(Setor setor, Grupo grupo) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, setor, grupo);
		Query qryMaximo = this.session.createQuery(" select Count(s) from Setor s "
				 								 + " left join s.grupo g ".concat(sql.toString()));
		this.defineParametros(qryMaximo, setor, grupo);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setor> buscaSetorPaginacao(Setor setor, Grupo grupo, int first,int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, setor, grupo);
		Query qry = this.session.createQuery("select s from Setor s "
										   + " left join s.grupo g ".concat(sql.toString()));
		this.defineParametros(qry, setor, grupo);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<Setor> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql,Setor setor, Grupo grupo){
 		if(grupo.getIdGrupo() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.idGrupo = :idGrupo");
		}
 		if(setor.getIdSetor() != null){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" s.idSetor = :idSetor");
 		}
 		if(setor.getDescricao() != null && setor.getDescricao() != "" && !setor.getDescricao().equals("")){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" s.descricao like :descricao");
 		}
	}
	
	@Override
	public void defineParametros(Query qry, Setor setor, Grupo grupo){
		if(grupo.getIdGrupo() != null){
			qry.setParameter("idGrupo", grupo.getIdGrupo());
		}
 		if(setor.getIdSetor() != null){
 			qry.setParameter("idSetor", setor.getIdSetor());
 		}
 		if(setor.getDescricao() != null && setor.getDescricao() != "" && !setor.getDescricao().equals("")){
 			qry.setParameter("descricao", "%" + setor.getDescricao() + "%");
 		}
	}
}
