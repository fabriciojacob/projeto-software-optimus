package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAO;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAOHibernate;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAO;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criaUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(JpaUtil.getEntityManager());
		try {
			usuarioDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return usuarioDAO;
	}

	public static EstadoDAO criaEstadoDAO() {
		EstadoDAOHibernate estadoDAO = new EstadoDAOHibernate();
		estadoDAO.setSession(JpaUtil.getEntityManager());
		try {
			estadoDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return estadoDAO;
	}

}
