package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;
import br.com.softwareOptimus.util.JpaUtil;

public class RegimeDAOHibernate extends JpaUtil implements RegimeDAO{
	
	@Override
	public List<VigenciaRegime> listaRegime(PessoaJuridica pessoaJuridica)
			throws Exception {
		String jpql = "Select r from VigenciaRegime r where r.pessoaJuridica = :parPes";
		TypedQuery<VigenciaRegime> consulta = getEntityManager().createQuery(jpql, VigenciaRegime.class);
		consulta.setParameter("parPes", pessoaJuridica);
		return consulta.getResultList();
	}

	@Override
	public void excluirRegime(Long idRegime) throws Exception {
		beginTransaction();
		VigenciaRegime vig = getEntityManager().find(VigenciaRegime.class, idRegime);
		getEntityManager().remove(vig);
		commitTransaction();
	}

}
