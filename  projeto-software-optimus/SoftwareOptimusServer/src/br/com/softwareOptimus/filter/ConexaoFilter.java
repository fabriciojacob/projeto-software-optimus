package br.com.softwareOptimus.filter;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.softwareOptimus.util.JpaUtil;

@WebFilter(urlPatterns = "/*")
public class ConexaoFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// inicia a transação antes de processar o request
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// processa a requisição
			chain.doFilter(request, response);
			// faz commit
			tx.commit();
		} catch (Exception e) { // ou em caso de erro faz o rollback
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		JpaUtil.closeEntityManagerFactory();
	}
}
