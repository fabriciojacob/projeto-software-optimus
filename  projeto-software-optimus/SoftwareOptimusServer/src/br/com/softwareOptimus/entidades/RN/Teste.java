package br.com.softwareOptimus.entidades.RN;

import javax.persistence.EntityManager;
import br.com.softwareOptimus.util.JpaUtil;

public class Teste {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		/*List<PessoaJuridica> retorno = new ArrayList<>();
		String consulta = "Select p from PessoaJuridica p";
		Query query = em.createQuery(consulta,
				PessoaJuridica.class);
		em.getTransaction().begin();
		retorno = query.getResultList();
		for(PessoaJuridica p: retorno){
			System.out.println(p.getRazaoSocial());
		}*/
		em.close();
	}
	

}
