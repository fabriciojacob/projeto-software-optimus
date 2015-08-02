package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

public interface GradeTributariaDAO {
	
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(GradeTributaria grade);
	public void altGrade(GradeTributaria grade);
	public void remover(GradeTributaria grade) throws IOException, SQLException;
	public List<GradeTributaria> listaConsultaId(long id);
	public List<GradeTributaria> listaConsultaDesc(String busca);
	public List<GradeTributaria> listar();
	public List<GradeTributaria> consGradVig();
	public GradeTributaria consultaId(Long id);
	public List<FiguraFiscal> verificaRemocao(GradeTributaria grade);
	public int countGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia);
	public List<GradeTributaria> buscaGradeTributariaPaginacao(GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia, int first,int pageSize);
	public void defineCondicao(StringBuilder sql, GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia);
	public void defineParametros(Query qry, GradeTributaria gradeTributaria,GradeTributariaVigencia gradeTributariaVigencia);
}
