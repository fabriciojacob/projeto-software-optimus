package br.com.softwareOptimus.entidades.RN;

import javax.persistence.EntityManager;
import br.com.softwareOptimus.util.JpaUtil;

public class UsuarioRN {
	
	public static void main(String[] args) {
		EntityManager em  = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.close();
	}

}
