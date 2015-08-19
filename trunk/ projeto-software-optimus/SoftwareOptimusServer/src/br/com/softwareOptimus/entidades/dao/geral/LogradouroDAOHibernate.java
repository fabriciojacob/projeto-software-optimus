package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.util.JpaUtil;

public class LogradouroDAOHibernate extends JpaUtil implements LogradouroDAO {

	@Override
	public void salvar(Logradouro logradouro) {
		beginTransaction();
		getEntityManager().persist(logradouro);
		commitTransaction();
	}

	public void refresh() {

	}

	@Override
	public void atualizar(Logradouro logradouro) {
		beginTransaction();
		getEntityManager().merge(logradouro);
		commitTransaction();

	}

	@Override
	public void excluir(Long idLogr) {
		beginTransaction();
		getEntityManager().remove(getEntityManager().getReference(Logradouro.class, idLogr));
		commitTransaction();
	}

	@Override
	public void consultar() throws Exception {

	}

	@Override
	public Logradouro carregar(Long codigo) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Logradouro> listar(Pessoa pessoa) {
		String jpql = "Select l From Logradouro l inner join l.municipio c " +
				"inner join c.uf "
				+ " where l.pessoa = :parPessoa";
		Query consulta = getEntityManager().createQuery(jpql);
		consulta.setParameter("parPessoa", pessoa);
		return consulta.getResultList();
	}

}
