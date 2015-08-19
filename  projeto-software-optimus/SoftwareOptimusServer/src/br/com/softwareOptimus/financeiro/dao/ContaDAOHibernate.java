package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;
import br.com.softwareOptimus.util.JpaUtil;

public class ContaDAOHibernate extends JpaUtil implements ContaDAO {

	@Override
	public void salvar(Conta conta) throws Exception {
		beginTransaction();
		getEntityManager().persist(conta);
		commitTransaction();
	}

	@Override
	public void salvarContaFilha(ContaFilha contaFilha) throws Exception {
		beginTransaction();
		getEntityManager().persist(contaFilha);
		commitTransaction();
	}

	@Override
	public void excluirContaFilha(ContaFilha contaFilha) throws Exception {
		beginTransaction();
		getEntityManager().remove(contaFilha);
		commitTransaction();
	}

	@Override
	public List<Conta> pesquisaConta(String descricao) throws Exception {
		String jpql = "Select c From Conta c where c.descricao LIKE :parDesc";
		TypedQuery<Conta> consulta = getEntityManager()
				.createQuery(jpql, Conta.class);
		consulta.setParameter("parDesc", "%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaFilha> listaContaFilha(Conta conta) throws Exception {
		String jpql = "Select c from ContaFilha c where c.conta = :parConta ";
		TypedQuery<ContaFilha> consulta = getEntityManager().createQuery(jpql,
				ContaFilha.class);
		consulta.setParameter("parConta", conta);
		return consulta.getResultList();
	}

	@Override
	public void alterarConta(Conta conta) throws Exception {
		beginTransaction();
		getEntityManager().merge(conta);
		commitTransaction();
	}

	@Override
	public Conta pesquisaConta(Long id) throws Exception {
		return getEntityManager().find(Conta.class, id);
	}

	@Override
	public ContaFilha localizaContaFilha(Long id) throws Exception {
		return getEntityManager().find(ContaFilha.class, id);
	}
}
