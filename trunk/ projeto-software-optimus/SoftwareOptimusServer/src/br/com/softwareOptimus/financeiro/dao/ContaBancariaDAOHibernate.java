package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.util.JpaUtil;

public class ContaBancariaDAOHibernate extends JpaUtil implements ContaBancariaDAO {

	@Override
	public void excluirConta(ContaBancaria conta) throws Exception {
		beginTransaction();
		getEntityManager().remove(conta);
		commitTransaction();
	}

	@Override
	public void salvarConta(ContaBancaria conta) throws Exception {
		beginTransaction();
		getEntityManager().persist(conta);
		commitTransaction();
	}

	@Override
	public void alterar(ContaBancaria conta) throws Exception {
		beginTransaction();
		getEntityManager().merge(conta);
		commitTransaction();
	}

	@Override
	public List<ContaBancaria> pesquisaTitular(String titular) throws Exception {
		String jpql = "Select c from ContaBancaria c where c.titular LIKE :parTitular";
		TypedQuery<ContaBancaria> consulta = getEntityManager().createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parTitular", "%" + titular + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaBancaria> pesquisaAgencia(Integer agencia)
			throws Exception {
		String jpql = "Select c from ContaBancaria c where c.agencia LIKE :parAgencia";
		TypedQuery<ContaBancaria> consulta = getEntityManager().createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parAgencia", "%" + agencia + "%");
		return consulta.getResultList();

	}

	@Override
	public List<ContaBancaria> pesquisaConta(Integer conta) throws Exception {
		String jpql = "Select c From ContaBancaria c where c.conta LIKE :parConta";
		TypedQuery<ContaBancaria> consulta = getEntityManager().createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parConta", "%" + conta + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaBancaria> pesquisaTodos(String titular, Integer conta,
			Integer agencia) throws Exception {
		String jpql = "Select c From ContaBancaria c where c.conta LIKE :parConta "
				+ " and c.titular LIKE :parTitular"
				+ " and c.agencia LIKE :parAgencia";
		TypedQuery<ContaBancaria> consulta = getEntityManager().createQuery(jpql,
				ContaBancaria.class);
		consulta.setParameter("parConta", "%" + conta + "%");
		consulta.setParameter("parTitular", "%" + titular + "%");
		consulta.setParameter("parAgencia", "%" + agencia + "%");
		return consulta.getResultList();
	}

	@Override
	public ContaBancaria pesquisaID(Long id) throws Exception {
		return getEntityManager().find(ContaBancaria.class, id);
	}

	@Override
	public List<ContaBancaria> listaGeral() throws Exception {
		String jpql = "Select conta from ContaBancaria conta";
		TypedQuery<ContaBancaria> lista = getEntityManager().createQuery(jpql,
				ContaBancaria.class);
		return lista.getResultList();
	}
}
