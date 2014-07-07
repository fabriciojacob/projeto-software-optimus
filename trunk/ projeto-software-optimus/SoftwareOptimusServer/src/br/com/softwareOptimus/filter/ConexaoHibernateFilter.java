package br.com.softwareOptimus.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.softwareOptimus.util.JpaUtil;

public class ConexaoHibernateFilter implements Filter {
	//private EntityManager session ;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		/*try{
			this.session.getTransaction().begin();
			chain.doFilter(servletRequest, servletResponse);
			this.session.getTransaction().commit();
			//this.session.close();
		}catch (Throwable ex){
			try{
				if(this.session.getTransaction().isActive()){
					this.session.getTransaction().rollback();
				}
			}catch (Throwable t){
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
		
		destroy();*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//this.session = JpaUtil.getEntityManager();
		
	}

}
