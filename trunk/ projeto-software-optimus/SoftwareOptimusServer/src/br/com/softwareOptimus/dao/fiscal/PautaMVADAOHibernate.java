package br.com.softwareOptimus.dao.fiscal;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;
import br.com.softwareOptimus.util.JpaUtil;

public class PautaMVADAOHibernate extends JpaUtil implements PautaMVADAO {

	@Override
	public void salva(PautaMVA pauta) {
		beginTransaction();
		getEntityManager().persist(pauta);
		commitTransaction();
	}

	@Override
	public void alterar(PautaMVA pauta) {
		beginTransaction();
		getEntityManager().merge(pauta);
		commitTransaction();
	}

	@Override
	public void remover(Long idPautaMVA) {
		PautaMVA paut = getEntityManager().find(PautaMVA.class, idPautaMVA);
		beginTransaction();
		getEntityManager().remove(paut);
		commitTransaction();
	}

	@Override
	public List<PautaMVA> consultaDesc(String desc) {
		String jpql = "Select p From PautaMVA p Where p.descricao LIKE :desc";
		TypedQuery<PautaMVA> listaPauta = getEntityManager().createQuery(jpql,
				PautaMVA.class);
		listaPauta.setParameter("desc", "%" + desc + "%");
		return listaPauta.getResultList();
	}

	@Override
	public PautaMVA editPauta(Long id) {
		String jpql = "Select p From PautaMVA p Where p.idPautaMVA = :id ";
		TypedQuery<PautaMVA> Pauta = getEntityManager().createQuery(jpql,
				PautaMVA.class);
		Pauta.setParameter("id", id);
		return Pauta.getSingleResult();
	}

	@Override
	public List<PautaMVA> listar(Pauta pauta) throws Exception {
		String jpql = "Select p from PautaMVA p where p.pauta = :parPauta";
		TypedQuery<PautaMVA> consulta = getEntityManager().createQuery(jpql,
				PautaMVA.class);
		consulta.setParameter("parPauta", pauta);
		return consulta.getResultList();
	}
}
