package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.CondPgto;
import br.com.softwareOptimus.util.JpaUtil;

public class CondPgtoDAOHibernate extends JpaUtil implements CondPgtoDAO {

	@Override
	public void salvar(CondPgto condPgto) throws Exception {
		beginTransaction();
		getEntityManager().persist(condPgto);
		commitTransaction();
	}

	@Override
	public void editar(CondPgto condPgto) throws Exception {
		beginTransaction();
		getEntityManager().merge(condPgto);
		commitTransaction();
	}

	@Override
	public void excluir(CondPgto condPgto) throws Exception {
		beginTransaction();
		getEntityManager().remove(condPgto);
		commitTransaction();
	}

	@Override
	public List<CondPgto> listar() throws Exception {
		String jpql = "Select e from CondPgto e";
		TypedQuery<CondPgto> consulta = getEntityManager().createQuery(jpql,
				CondPgto.class);
		return consulta.getResultList();
	}

	@Override
	public CondPgto find(Long id) throws Exception {
		return getEntityManager().find(CondPgto.class, id);
	}
}
