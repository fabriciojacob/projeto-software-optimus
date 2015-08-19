package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.util.JpaUtil;

public class EmailDAOHibernate extends JpaUtil implements EmailDAO {

	@Override
	public void salvar(Email email) throws Exception {
		beginTransaction();
		getEntityManager().persist(email);
		commitTransaction();

	}

	@Override
	public void excluir(Long idEmail) throws Exception {
		beginTransaction();
		getEntityManager().remove(getEntityManager().getReference(Email.class, idEmail));
		commitTransaction();
	}

	@Override
	public List<Email> listaEmail(Pessoa pessoa) throws Exception {
		String jpql = "Select e from Email e where e.pessoa = :parPessoa";
		TypedQuery<Email> consulta = getEntityManager()
				.createQuery(jpql, Email.class);
		consulta.setParameter("parPessoa", pessoa);
		return consulta.getResultList();
	}

	@Override
	public List<Email> emailNFE(Pessoa pessoa) throws Exception {
		Integer nfe = 1;
		String jpql = "Select e From Email e where e.pessoa = :parPessoa" +
				" and e.padraoNFe = :parNFe";
		TypedQuery<Email> consulta = getEntityManager()
				.createQuery(jpql, Email.class);
		consulta.setParameter("parPessoa", pessoa);
		consulta.setParameter("parNFe", nfe);
		return consulta.getResultList();
	}
}
