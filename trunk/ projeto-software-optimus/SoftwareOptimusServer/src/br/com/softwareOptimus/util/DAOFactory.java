package br.com.softwareOptimus.util;

import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAO;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAOHibernate;


public class DAOFactory {
	
	public static UsuarioDAO criaUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(JpaUtil.getEntityManager());
		return usuarioDAO;
	}

}
