package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.util.JpaUtil;

public class CaixaDAOHibernate extends JpaUtil implements CaixaDAO {

	@Override
	public void salvar(Caixa caixa) throws Exception {
		beginTransaction();
		getEntityManager().persist(caixa);
		commitTransaction();
	}

	@Override
	public void excluir(Caixa caixa) throws Exception {
		beginTransaction();
		getEntityManager().remove(caixa);
		commitTransaction();
	}

	@Override
	public List<Caixa> pesquisaCaixa(String descricao) throws Exception {
		String jpql = "Select c From Caixa c where c.descricao LIKE :parCaixa";
		TypedQuery<Caixa> consulta = getEntityManager()
				.createQuery(jpql, Caixa.class);
		consulta.setParameter("parCaixa", "%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public void editar(Caixa caixa) throws Exception {
		beginTransaction();
		getEntityManager().merge(caixa);
		commitTransaction();
	}

	@Override
	public Caixa pesquisaID(Long id) throws Exception {
		return getEntityManager().find(Caixa.class, id);
	}

	@Override
	public List<Caixa> listaCaixa() throws Exception {
		String jpql = "Select c from Caixa c";
		TypedQuery<Caixa> lista = getEntityManager().createQuery(jpql, Caixa.class);
		return lista.getResultList();

	}

}
