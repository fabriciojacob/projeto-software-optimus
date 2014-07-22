package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;

import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.dao.produto.ProdutoDAOHibernate;
import br.com.softwareOptimus.dao.produto.UnidMedDAO;
import br.com.softwareOptimus.dao.produto.UnidMedDAOHibernate;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAO;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAO;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.MunicipioDAO;
import br.com.softwareOptimus.entidades.dao.geral.MunicipioDAOHibernate;
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

	public static MunicipioDAO criaMunicipioDAO() {
		MunicipioDAOHibernate municipioDAO = new MunicipioDAOHibernate();
		municipioDAO.setSession(JpaUtil.getEntityManager());
		try {
			municipioDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return municipioDAO;
	}

	public static EmpresaDAO criaEmpresaDAO() {
		EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
		empresaDAO.setSession(JpaUtil.getEntityManager());
		try {
			empresaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empresaDAO;
	}

	public static LogradouroDAO criaLogrDAO() {
		LogradouroDAOHibernate logrDAO = new LogradouroDAOHibernate();
		logrDAO.setSession(JpaUtil.getEntityManager());
		try {
			logrDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return logrDAO;
	}

	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOHibernate prodDAO = new ProdutoDAOHibernate();
		prodDAO.setSession(JpaUtil.getEntityManager());
		try {
			prodDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return prodDAO;
	}
	
	public static UnidMedDAO criaUnidMedDAO(){
		UnidMedDAOHibernate unidDAO = new UnidMedDAOHibernate();
		unidDAO.setSession(JpaUtil.getEntityManager());
		try {
			unidDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return unidDAO;
	}
}
