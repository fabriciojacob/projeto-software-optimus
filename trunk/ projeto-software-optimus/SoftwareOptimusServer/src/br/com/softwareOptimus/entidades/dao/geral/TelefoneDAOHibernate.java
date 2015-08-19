package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.util.JpaUtil;

public class TelefoneDAOHibernate extends JpaUtil implements TelefoneDAO {

	@Override
	public void salvar(Telefone telefone) throws Exception {
		beginTransaction();
		getEntityManager().persist(telefone);
		commitTransaction();

	}

	@Override
	public void excluir(Long idTel) throws Exception {
		beginTransaction();
		getEntityManager().remove(getEntityManager().getReference(Telefone.class, idTel));
		commitTransaction();

	}

	@Override
	public List<Telefone> listaTelefone(Pessoa pessoa) throws Exception {
		String jpql = "Select e From Telefone e where e.pessoa = :parPessoa";
		TypedQuery<Telefone> consulta = getEntityManager().createQuery(jpql,
				Telefone.class);
		consulta.setParameter("parPessoa", pessoa);
		List<Telefone> result = consulta.getResultList();
		return result;
	}

}
