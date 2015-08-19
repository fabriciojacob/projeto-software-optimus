package br.com.softwareOptimus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "SoftwareOptimusServer";

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();
	
	private static EntityManagerFactory entityManagerFactory;
	
	private static EntityManager entityManager;
	
	private static EntityTransaction transaction;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}

		//entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			//JpaUtil.threadEntityManager.set(entityManager);
		}
		if(transaction == null){
			transaction = entityManager.getTransaction();
		}
		return entityManager;
	}
	
	public static void beginTransaction() {
		try {
			if(!transaction.isActive()){
				transaction.begin();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void commitTransaction() {
		try {
			if(transaction.isActive()){
				transaction.commit();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void rollbackTransaction() {
		try {
			if(transaction.isActive()){
				transaction.rollback();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
    /**public Connection getConnection() {
        InitialContext initialContext = null;
        DataSource dataSource = null;
        Connection connection = null;        
        try {
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("/DataSourceSoftwareOptimusServer");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            System.out.println("Erro ao capturar conexão: " + e.getMessage());
        } catch (SQLException e1) {
            System.out.println("Erro ao capturar conexão: " + e1.getMessage());
        }
        return connection;
    }*/

	@SuppressWarnings("null")
	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();

		if (em == null) {

			if (em.getTransaction().isActive()) {
				em.getTransaction().commit();
			}
			em.close();

			threadEntityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}
}
