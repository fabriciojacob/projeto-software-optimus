package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.PisCofins;
import br.com.softwareOptimus.fiscal.TipoCst;

public class AliquotaDAOHibernate implements AliquotaDAO {

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
	public void altAliq(Aliquota aliquota) throws Exception {
		this.session.merge(aliquota);
		this.transaction.commit();
	}

	@Override
	public Aliquota editBusc(Long id) {
		String jpql = "Select a From Aliquota a Where a.idAliq = :id ";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("id", id);
		return listaAliquota.getSingleResult();
	}

	@Override
	public void remover(Long id) throws Exception {
		Aliquota aliq = this.session.find(Aliquota.class, id);
		this.session.remove(aliq);
		this.transaction.commit();
	}

	@Override
	public List<Aliquota> lista() {
		String jpql = "Select a From Aliquota a";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		return listaAliquota.getResultList();
	}

	public List<Aliquota> listaAliqIcms() {
		String jpql = "Select a From Aliquota a Where a.tipo Is Not Null";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		return listaAliquota.getResultList();
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
	public void salva(Aliquota aliquota) throws Exception {
		this.session.persist(aliquota);
		this.transaction.commit();
	}

	@Override
	public List<Aliquota> consultaId(long id) {
		String jpql = "Select a From Aliquota a Where a.idAliq = :id ";
		TypedQuery<Aliquota> listaUnidade = this.session.createQuery(jpql,
				Aliquota.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getResultList();
	}

	@Override
	public List<Aliquota> consultaAliq(Double aliquota) {
		Double minimo, maximo;
		minimo = aliquota - 2;
		maximo = aliquota + 2;
		String jpql = "Select a From Aliquota a Where a.aliquota BETWEEN :minimo And :maximo";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("minimo", minimo);
		listaAliquota.setParameter("maximo", maximo);
		return listaAliquota.getResultList();
	}

	@Override
	public List<Aliquota> consultaRed(Double reducao) {
		Double minimo, maximo;
		minimo = reducao - 10;
		maximo = reducao + 10;
		String jpql = "Select a From Aliquota a Where a.reducao BETWEEN :minimo And :maximo";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("minimo", minimo);
		listaAliquota.setParameter("maximo", maximo);
		return listaAliquota.getResultList();
	}

	@Override
	public List<Aliquota> listaAliq(TipoCst tipo) {
		String jpql = "Select Distinct a From Aliquota a, IN(a.cst) AS b Where b.tipoCst = :tipo";
		TypedQuery<Aliquota> aliqIpi = this.session.createQuery(jpql,
				Aliquota.class);
		aliqIpi.setParameter("tipo", tipo);
		return aliqIpi.getResultList();
	}

	@Override
	public List<Aliquota> listaAliqPisCofins(TipoCst pisCofins,
			PisCofins tipoAliq) {
		String jpql = "Select Distinct a From Aliquota a, IN(a.cst) AS b Where b.tipoCst = :tipo and a.pisCofins = :tipoAliq";
		TypedQuery<Aliquota> aliqPisCofins = this.session.createQuery(jpql,
				Aliquota.class);
		aliqPisCofins.setParameter("tipo", pisCofins);
		aliqPisCofins.setParameter("tipoAliq", tipoAliq);
		return aliqPisCofins.getResultList();
	}

	@Override
	public List<CodTabelaGov> verificaRemocao1(Aliquota aliquota) {
		String jpql = "Select c from CodTabelaGov c "
				+ "where c.entradaPis = :aliquota1 "
				+ "or c.entradaCofins = :aliquota2 "
				+ "or c.saidaPis = :aliquota3 "
				+ "or c.saidaCofins = :aliquota4";
		TypedQuery<CodTabelaGov> codTb = this.session.createQuery(jpql,
				CodTabelaGov.class);
		codTb.setParameter("aliquota1", aliquota);
		codTb.setParameter("aliquota2", aliquota);
		codTb.setParameter("aliquota3", aliquota);
		codTb.setParameter("aliquota4", aliquota);
		return codTb.getResultList();
	}

	@Override
	public List<GradeTributariaVigencia> verificaRemocao2(Aliquota aliquota) {
		String jpql = "select g from GradeTributariaVigencia g where g.aliquota = :aliquota";
		TypedQuery<GradeTributariaVigencia> grade = this.session.createQuery(
				jpql, GradeTributariaVigencia.class);
		grade.setParameter("aliquota", aliquota);
		return grade.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aliquota> buscaAliquotaPaginacao(Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc, int first, int pageSize) {
		
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, maxAliquota, minAliquota, maxReduc, minReduc);
		Query qry = this.session.createQuery("select a from Aliquota a ".concat(sql.toString()));
		this.defineParametros(qry,  maxAliquota, minAliquota, maxReduc, minReduc);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<Aliquota> result = qry.getResultList();
		return result;
	}

	@Override
	public int countAliquotaPaginacao(Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, maxAliquota, minAliquota, maxReduc, minReduc);
		Query qryMaximo = this.session.createQuery("select Count(a) from Aliquota a ".concat(sql.toString()));
		this.defineParametros(qryMaximo, maxAliquota, minAliquota, maxReduc, minReduc);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc){
		if(maxAliquota != null){
			sql.append(sql.length() == 0 ? " where ": " and ");
		}
		if(minAliquota != null){
			sql.append(sql.length() == 0 ? " where ": " and ");
		}
		if(maxReduc != null){
			sql.append(sql.length() == 0 ? " where ": " and ");
		}
		if(minReduc != null){
			sql.append(sql.length() == 0 ? " where ": " and ");
		}
	}
	
	@Override
	public void defineParametros(Query qry, Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc){
		if(maxAliquota != null){

		}
		if(minAliquota != null){

		}
		if(maxReduc != null){

		}
		if(minReduc != null){

		}
	}

}
