package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import br.com.softwareOptimus.com.financeiro.dao.BancoDAO;
import br.com.softwareOptimus.com.financeiro.dao.BancoDAOHibernate;
import br.com.softwareOptimus.com.financeiro.dao.CaixaDAO;
import br.com.softwareOptimus.com.financeiro.dao.CaixaDAOHibernate;
import br.com.softwareOptimus.com.financeiro.dao.CondPgtoDAO;
import br.com.softwareOptimus.com.financeiro.dao.CondPgtoDAOHibernate;
import br.com.softwareOptimus.com.financeiro.dao.ContaBancariaDAO;
import br.com.softwareOptimus.com.financeiro.dao.ContaBancariaDAOHibernate;
import br.com.softwareOptimus.com.financeiro.dao.ContaDAO;
import br.com.softwareOptimus.com.financeiro.dao.ContaDAOHibernate;
import br.com.softwareOptimus.com.financeiro.dao.FormaPgtoDAO;
import br.com.softwareOptimus.com.financeiro.dao.FormaPgtoHibernate;
import br.com.softwareOptimus.com.financeiro.dao.TituloDAO;
import br.com.softwareOptimus.com.financeiro.dao.TituloDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.AliquotaDAO;
import br.com.softwareOptimus.dao.fiscal.AliquotaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.CodTabelaGovDAO;
import br.com.softwareOptimus.dao.fiscal.CodTabelaGovDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.CodigoSituacaoTributariaDAO;
import br.com.softwareOptimus.dao.fiscal.CodigoSituacaoTributariaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.FiguraFiscalDAO;
import br.com.softwareOptimus.dao.fiscal.FiguralFiscalDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaVigenciaDAO;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaVigenciaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.PautaDAO;
import br.com.softwareOptimus.dao.fiscal.PautaDAOHibernate;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAO;
import br.com.softwareOptimus.dao.fiscal.PautaMVADAOHibernate;
import br.com.softwareOptimus.dao.fiscal.TipoProdutoDAO;
import br.com.softwareOptimus.dao.fiscal.TipoProdutoDAOHibernate;
import br.com.softwareOptimus.dao.produto.CategoriaDAO;
import br.com.softwareOptimus.dao.produto.CategoridoDAOHibernate;
import br.com.softwareOptimus.dao.produto.GrupoDAO;
import br.com.softwareOptimus.dao.produto.GrupoDAOHibernate;
import br.com.softwareOptimus.dao.produto.ProdutoDAO;
import br.com.softwareOptimus.dao.produto.ProdutoDAOHibernate;
import br.com.softwareOptimus.dao.produto.SubGrupoDAO;
import br.com.softwareOptimus.dao.produto.SubGrupoDAOHibernate;
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
	
	public static TituloDAO criaTitulo(){
		TituloDAOHibernate tituloDAO = new TituloDAOHibernate();
		tituloDAO.setSession(session);
		try{
			tituloDAO.begin();
		}catch (IOException | SQLException e){
			e.printStackTrace();
		}
		
		return tituloDAO;
	}
	
	public static CondPgtoDAO criaCondPgto(){
		CondPgtoDAOHibernate condPgto = new CondPgtoDAOHibernate();
		condPgto.setSession(session);
		try{
			condPgto.begin();
		}catch (IOException | SQLException e){
			e.printStackTrace();
		}
		
		return condPgto;
	}
	
	public static FormaPgtoDAO formaPgtoDAO(){
		FormaPgtoHibernate formaPgto = new FormaPgtoHibernate();
		formaPgto.setSession(session);
		try{
			formaPgto.begin();
		} catch (IOException | SQLException e){
			e.printStackTrace();
		}
		
		return formaPgto;
	}


	public static CaixaDAO criaCaixa() {
		CaixaDAOHibernate caixaDAO = new CaixaDAOHibernate();
		caixaDAO.setSession(session);
		try {
			caixaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return caixaDAO;
	}

	public static BancoDAO criaBanco() {
		BancoDAOHibernate bancoDAO = new BancoDAOHibernate();
		bancoDAO.setSession(session);
		try {
			bancoDAO.being();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return bancoDAO;
	}

	public static ContaBancariaDAO criaContaBancDAO() {
		ContaBancariaDAOHibernate contaDAO = new ContaBancariaDAOHibernate();
		contaDAO.setSession(session);
		try {
			contaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return contaDAO;
	}

	public static ContaDAO criaContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		contaDAO.setSession(session);
		try {
			contaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return contaDAO;
	}

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

	public static CodigoSituacaoTributariaDAO criaCodigoSituacaoTributariaDAO() {
		CodigoSituacaoTributariaDAOHibernate cstDAO = new CodigoSituacaoTributariaDAOHibernate();
		cstDAO.setSession(session);
		try {
			cstDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return cstDAO;
	}

	public static PautaMVADAO criaPautaMVADAO() {
		PautaMVADAOHibernate pautaDAO = new PautaMVADAOHibernate();
		pautaDAO.setSession(session);
		try {
			pautaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return pautaDAO;
	}

	public static PautaDAO criaPautaDAO() {
		PautaDAOHibernate pautaDAO = new PautaDAOHibernate();
		pautaDAO.setSession(session);
		try {
			pautaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return pautaDAO;
	}

	public static GradeTributariaDAO criaGradeTribDAO() {
		GradeTributariaDAOHibernate gradeDAO = new GradeTributariaDAOHibernate();
		gradeDAO.setSession(session);
		try {
			gradeDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return gradeDAO;
	}

	public static GradeTributariaVigenciaDAO criaGradeTribVigDAO() {
		GradeTributariaVigenciaDAOHibernate gradeVigDAO = new GradeTributariaVigenciaDAOHibernate();
		gradeVigDAO.setSession(session);
		try {
			gradeVigDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return gradeVigDAO;
	}

	public static FiguraFiscalDAO criaFiguraDAO() {
		FiguralFiscalDAOHibernate figuraDAO = new FiguralFiscalDAOHibernate();
		figuraDAO.setSession(session);
		try {
			figuraDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return figuraDAO;
	}
	
	public static TipoProdutoDAO criaTipoProdutoDAO(){
		TipoProdutoDAOHibernate tipoProdutoDAO = new TipoProdutoDAOHibernate();
		tipoProdutoDAO.setSession(session);
		try {
			tipoProdutoDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return tipoProdutoDAO;
	}
	
	public static CodTabelaGovDAO criaCodTabelaGovDAO(){
		CodTabelaGovDAOHibernate codTabelaGovDAO = new CodTabelaGovDAOHibernate();
		codTabelaGovDAO.setSession(session);
		try {
			codTabelaGovDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return codTabelaGovDAO;
	}
	
	public static SubGrupoDAO criaSubGrupoDAO(){
		SubGrupoDAOHibernate subGrupoDAO = new SubGrupoDAOHibernate();
		subGrupoDAO.setSession(session);
		try {
			subGrupoDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return subGrupoDAO;
	}
	
	public static CategoriaDAO criaCategoriaDAO(){
		CategoridoDAOHibernate categoriaDAO = new CategoridoDAOHibernate();
		categoriaDAO.setSession(session);
		try {
			categoriaDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return categoriaDAO;
	}
	
	public static GrupoDAO criaGrupoDAO(){
		GrupoDAOHibernate grupoDAO = new GrupoDAOHibernate();
		grupoDAO.setSession(session);
		try {
			grupoDAO.begin();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return grupoDAO;
	}
}
