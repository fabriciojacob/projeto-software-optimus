package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.util.JpaUtil;

public class EstadoDAOHibernate extends JpaUtil implements EstadoDAO {

	@Override
	public List<Estado> listar() {
		String jpql = "Select uf From Estado uf";
		TypedQuery<Estado> listaEstado = getEntityManager().createQuery(jpql,
				Estado.class);
		return listaEstado.getResultList();
	}
}
