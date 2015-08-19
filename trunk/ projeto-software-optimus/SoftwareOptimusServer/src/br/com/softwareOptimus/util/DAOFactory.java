package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import br.com.softwareOptimus.comercial.dao.CotacaoDAO;
import br.com.softwareOptimus.comercial.dao.CotacaoHibernate;
import br.com.softwareOptimus.comercial.dao.RequisicaoDAO;
import br.com.softwareOptimus.comercial.dao.RequisicaoHibernate;
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
import br.com.softwareOptimus.dao.produto.SetorDAO;
import br.com.softwareOptimus.dao.produto.SetorDAOHibernate;
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
import br.com.softwareOptimus.estoque.dao.InventarioDAO;
import br.com.softwareOptimus.estoque.dao.InventarioDAOHibernate;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAO;
import br.com.softwareOptimus.estoque.dao.ProdutoEstoqueDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.BancoDAO;
import br.com.softwareOptimus.financeiro.dao.BancoDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.CaixaDAO;
import br.com.softwareOptimus.financeiro.dao.CaixaDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.CondPgtoDAO;
import br.com.softwareOptimus.financeiro.dao.CondPgtoDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.ContaBancariaDAO;
import br.com.softwareOptimus.financeiro.dao.ContaBancariaDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.ContaDAO;
import br.com.softwareOptimus.financeiro.dao.ContaDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.ExtratoDAO;
import br.com.softwareOptimus.financeiro.dao.ExtratoDAOHibernate;
import br.com.softwareOptimus.financeiro.dao.FormaPgtoDAO;
import br.com.softwareOptimus.financeiro.dao.FormaPgtoHibernate;
import br.com.softwareOptimus.financeiro.dao.TituloDAO;
import br.com.softwareOptimus.financeiro.dao.TituloDAOHibernate;

public class DAOFactory {

	private static EntityManager session = JpaUtil.getEntityManager();
	
	public static RequisicaoDAO criaRequisicao(){
		RequisicaoHibernate requisicaoDAO = new RequisicaoHibernate();
		requisicaoDAO.setSession(session);
		try{
			requisicaoDAO.begin();
		}catch (IOException | SQLException e){
			e.printStackTrace();
		}
		
		return requisicaoDAO;
	}
	
	public static CotacaoDAO criaCotacao(){
		CotacaoHibernate cotacaoDAO = new CotacaoHibernate();
		cotacaoDAO.setSession(session);
		try{
			cotacaoDAO.begin();
		}catch(IOException | SQLException e){
			e.printStackTrace();
		}
		return cotacaoDAO;
	}
	
	public static ExtratoDAO criaExtratoConta(){
		ExtratoDAOHibernate extratoDAO = new ExtratoDAOHibernate();
		return extratoDAO;
	}
	
	public static TituloDAO criaTitulo(){
		TituloDAOHibernate tituloDAO = new TituloDAOHibernate();
		return tituloDAO;
	}
	
	public static CondPgtoDAO criaCondPgto(){
		CondPgtoDAOHibernate condPgto = new CondPgtoDAOHibernate();
		return condPgto;
	}
	
	public static FormaPgtoDAO formaPgtoDAO(){
		FormaPgtoHibernate formaPgto = new FormaPgtoHibernate();
		return formaPgto;
	}

	public static CaixaDAO criaCaixa() {
		CaixaDAOHibernate caixaDAO = new CaixaDAOHibernate();
		return caixaDAO;
	}

	public static BancoDAO criaBanco() {
		BancoDAOHibernate bancoDAO = new BancoDAOHibernate();
		return bancoDAO;
	}

	public static ContaBancariaDAO criaContaBancDAO() {
		ContaBancariaDAOHibernate contaDAO = new ContaBancariaDAOHibernate();
		return contaDAO;
	}

	public static ContaDAO criaContaDAO() {
		ContaDAOHibernate contaDAO = new ContaDAOHibernate();
		return contaDAO;
	}

	public static EmailDAO criaEmailDAO() {
		EmailDAOHibernate emailDAO = new EmailDAOHibernate();
		return emailDAO;
	}

	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		return participanteDAO;
	}

	public static TelefoneDAO criaTelefoneDAO() {
		TelefoneDAOHibernate telefoneDAO = new TelefoneDAOHibernate();
		return telefoneDAO;
	}

	public static UsuarioDAO criaUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		return usuarioDAO;
	}

	public static RegimeDAO criaVigenciaRegDAO() {
		RegimeDAOHibernate regimeDAO = new RegimeDAOHibernate();
		return regimeDAO;
	}

	public static EstadoDAO criaEstadoDAO() {
		EstadoDAOHibernate estadoDAO = new EstadoDAOHibernate();
		return estadoDAO;
	}

	public static MunicipioDAO criaMunicipioDAO() {
		MunicipioDAOHibernate municipioDAO = new MunicipioDAOHibernate();
		return municipioDAO;
	}

	public static EmpresaDAO criaEmpresaDAO() {
		EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
		return empresaDAO;
	}

	public static LogradouroDAO criaLogrDAO() {
		LogradouroDAOHibernate logrDAO = new LogradouroDAOHibernate();
		return logrDAO;
	}

	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOHibernate prodDAO = new ProdutoDAOHibernate();
		return prodDAO;
	}

	public static UnidMedDAO criaUnidMedDAO() {
		UnidMedDAOHibernate unidDAO = new UnidMedDAOHibernate();
		return unidDAO;
	}

	public static AliquotaDAO criaAliquotaDAO() {
		AliquotaDAOHibernate aliqDAO = new AliquotaDAOHibernate();
		return aliqDAO;
	}

	public static CodigoSituacaoTributariaDAO criaCodigoSituacaoTributariaDAO() {
		CodigoSituacaoTributariaDAOHibernate cstDAO = new CodigoSituacaoTributariaDAOHibernate();
		return cstDAO;
	}

	public static PautaMVADAO criaPautaMVADAO() {
		PautaMVADAOHibernate pautaDAO = new PautaMVADAOHibernate();
		return pautaDAO;
	}

	public static PautaDAO criaPautaDAO() {
		PautaDAOHibernate pautaDAO = new PautaDAOHibernate();
		return pautaDAO;
	}

	public static GradeTributariaDAO criaGradeTribDAO() {
		GradeTributariaDAOHibernate gradeDAO = new GradeTributariaDAOHibernate();
		return gradeDAO;
	}

	public static GradeTributariaVigenciaDAO criaGradeTribVigDAO() {
		GradeTributariaVigenciaDAOHibernate gradeVigDAO = new GradeTributariaVigenciaDAOHibernate();
		return gradeVigDAO;
	}

	public static FiguraFiscalDAO criaFiguraDAO() {
		FiguralFiscalDAOHibernate figuraDAO = new FiguralFiscalDAOHibernate();
		return figuraDAO;
	}
	
	public static TipoProdutoDAO criaTipoProdutoDAO(){
		TipoProdutoDAOHibernate tipoProdutoDAO = new TipoProdutoDAOHibernate();
		return tipoProdutoDAO;
	}
	
	public static CodTabelaGovDAO criaCodTabelaGovDAO(){
		CodTabelaGovDAOHibernate codTabelaGovDAO = new CodTabelaGovDAOHibernate();
		return codTabelaGovDAO;
	}
	
	public static SubGrupoDAO criaSubGrupoDAO(){
		SubGrupoDAOHibernate subGrupoDAO = new SubGrupoDAOHibernate();
		return subGrupoDAO;
	}
	
	public static CategoriaDAO criaCategoriaDAO(){
		CategoridoDAOHibernate categoriaDAO = new CategoridoDAOHibernate();
		return categoriaDAO;
	}
	
	public static GrupoDAO criaGrupoDAO(){
		GrupoDAOHibernate grupoDAO = new GrupoDAOHibernate();
		return grupoDAO;
	}
	
	public static SetorDAO criaSetorDAO(){
		SetorDAOHibernate setorDAO = new SetorDAOHibernate();
		return setorDAO;
	}
	
	public static InventarioDAO criaInventarioDAO(){
		InventarioDAOHibernate invenDAO = new InventarioDAOHibernate();
		return invenDAO;
	}
	
	public static ProdutoEstoqueDAO criaProdutoEstoqueDAO(){
		ProdutoEstoqueDAOHibernate prodEstDAO = new ProdutoEstoqueDAOHibernate();
		return prodEstDAO;
	}
}
