package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import br.com.softwareOptimus.dao.fiscal.AliquotaDAO;
import br.com.softwareOptimus.dao.fiscal.AliquotaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.CodigoSituacaoTributariaDAO;
import br.com.softwareOptimus.dao.fiscal.CodigoSituacaoTributariaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAOHibernate;
import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.dao.produto.ProdutoDAOHibernate;
import br.com.softwareOptimus.dao.produto.UnidMedDAO;
import br.com.softwareOptimus.dao.produto.UnidMedDAOHibernate;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAO;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.EmailDAO;
import br.com.softwareOptimus.entidades.dao.geral.EmailDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAO;
import br.com.softwareOptimus.entidades.dao.geral.EstadoDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.MunicipioDAO;
import br.com.softwareOptimus.entidades.dao.geral.MunicipioDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.RegimeDAO;
import br.com.softwareOptimus.entidades.dao.geral.RegimeDAOHibernate;
import br.com.softwareOptimus.entidades.dao.geral.TelefoneDAO;
import br.com.softwareOptimus.entidades.dao.geral.TelefoneDAOHibernate;
import br.com.softwareOptimus.entidades.dao.participantes.ParticipanteDAO;
import br.com.softwareOptimus.entidades.dao.participantes.ParticipanteDAOHibernate;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAO;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	private static EntityManager session = JpaUtil.getEntityManager();

	public static EmailDAO criaEmailDAO() {
		EmailDAOHibernate emailDAO = new EmailDAOHibernate();
		emailDAO.setSession(session);
		try {
			emailDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return emailDAO;
	}

	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		participanteDAO.setSession(session);
		try {
			participanteDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return participanteDAO;
	}

	public static TelefoneDAO criaTelefoneDAO() {
		TelefoneDAOHibernate telefoneDAO = new TelefoneDAOHibernate();
		telefoneDAO.setSession(session);
		try {
			telefoneDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return telefoneDAO;
	}

	public static UsuarioDAO criaUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(session);
		try {
			usuarioDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return usuarioDAO;
	}

	public static RegimeDAO criaVigenciaRegDAO() {
		RegimeDAOHibernate regimeDAO = new RegimeDAOHibernate();
		regimeDAO.setSession(session);
		try {
			regimeDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return regimeDAO;
	}

	public static EstadoDAO criaEstadoDAO() {
		EstadoDAOHibernate estadoDAO = new EstadoDAOHibernate();
		estadoDAO.setSession(session);
		try {
			estadoDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return estadoDAO;
	}

	public static MunicipioDAO criaMunicipioDAO() {
		MunicipioDAOHibernate municipioDAO = new MunicipioDAOHibernate();
		municipioDAO.setSession(session);
		try {
			municipioDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return municipioDAO;
	}

	public static EmpresaDAO criaEmpresaDAO() {
		EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
		empresaDAO.setSession(session);
		try {
			empresaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empresaDAO;
	}

	public static LogradouroDAO criaLogrDAO() {
		LogradouroDAOHibernate logrDAO = new LogradouroDAOHibernate();
		logrDAO.setSession(session);
		try {
			logrDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return logrDAO;
	}

	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOHibernate prodDAO = new ProdutoDAOHibernate();
		prodDAO.setSession(session);
		try {
			prodDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return prodDAO;
	}

	public static UnidMedDAO criaUnidMedDAO() {
		UnidMedDAOHibernate unidDAO = new UnidMedDAOHibernate();
		unidDAO.setSession(session);
		try {
			unidDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return unidDAO;
	}

	public static AliquotaDAO criaAliquotaDAO() {
		AliquotaDAOHibernate aliqDAO = new AliquotaDAOHibernate();
		aliqDAO.setSession(session);
		try {
			aliqDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return aliqDAO;
	}
	
	public static CodigoSituacaoTributariaDAO criaCodigoSituacaoTributariaDAO(){
		CodigoSituacaoTributariaDAOHibernate cstDAO = new CodigoSituacaoTributariaDAOHibernate();
		cstDAO.setSession(session);
		try {
			cstDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return cstDAO;
	}
	
	public static PautaMVADAO criaPautaMVADAO(){
		PautaMVADAOHibernate pautaDAO = new PautaMVADAOHibernate();
		pautaDAO.setSession(session);
		try {
			pautaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return pautaDAO;
	}
}
