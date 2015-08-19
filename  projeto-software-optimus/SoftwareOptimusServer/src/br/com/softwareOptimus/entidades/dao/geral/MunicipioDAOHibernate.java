package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.util.JpaUtil;

public class MunicipioDAOHibernate extends JpaUtil implements MunicipioDAO {

	@Override
	public List<Municipio> lista(Estado uf) {
		String jpql = "Select m from Municipio m where m.uf = :uf";
		TypedQuery<Municipio> listaMunicipios = getEntityManager().createQuery(jpql,
				Municipio.class);
		listaMunicipios.setParameter("uf", uf);
		return listaMunicipios.getResultList();
	}
}
