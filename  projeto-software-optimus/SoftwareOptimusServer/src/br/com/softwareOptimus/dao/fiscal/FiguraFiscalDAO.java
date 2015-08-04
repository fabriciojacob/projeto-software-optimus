package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.produto.Produto;

public interface FiguraFiscalDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salva(FiguraFiscal figura);
	public void altFigura(FiguraFiscal figura);
	public void remover(FiguraFiscal figura);
	public List<FiguraFiscal> consultaId(long id);
	public List<FiguraFiscal> consultaDesc(String desc);
	public List<FiguraFiscal> listar();
	public FiguraFiscal editFigura(Long id);
	public List<Produto> verificaRemocao(FiguraFiscal figura);
	public int countFiguraFiscalPaginacao(FiguraFiscal figuraFiscal,GradeTributaria gradeTributaria);
	public List<FiguraFiscal> buscaFiguraFiscalPaginacao(FiguraFiscal figuraFiscal, GradeTributaria gradeTributaria,int first, int pageSize);
	public void defineCondicao(StringBuilder sql, FiguraFiscal figuraFiscal,GradeTributaria gradeTributaria);
	public void defineParametros(Query qry, FiguraFiscal figuraFiscal,GradeTributaria gradeTributaria);
}
