package br.com.softwareOptimus.entidades.RN;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = fac.createEntityManager();
		List<PessoaJuridica> retorno = new ArrayList<>();
		String consulta = "Select p from PessoaJuridica p";
		Query query = em.createQuery(consulta,
				PessoaJuridica.class);
		em.getTransaction().begin();
		retorno = query.getResultList();
		for(PessoaJuridica p: retorno){
			System.out.println(p.getRazaoSocial());
		}
		em.close();
	}
	

}
