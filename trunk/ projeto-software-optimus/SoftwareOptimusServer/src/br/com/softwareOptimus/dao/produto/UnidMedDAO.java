package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.produto.UnidMed;

public interface UnidMedDAO {

	public List<UnidMed> consultarUnid(String unid);
	public List<UnidMed> consultarDesc(String desc);
	public List<UnidMed> consultarId(Long id);
	public void altUnid(UnidMed unidMed) throws Exception;
	public UnidMed editBusc(Long id);
	public void remover(Long id) throws Exception;
	public List<UnidMed> lista();
	public void salvar(UnidMed unid);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public int countUnidadeMedidaPaginacao(UnidMed unidMed);
	public List<UnidMed> buscaUnidadeMedidaPaginacao(UnidMed unidMed,int first, int pageSize);
	public void defineCondicao(StringBuilder sql, UnidMed unidMed);
	public void defineParametros(Query qry, UnidMed unidMed);
}
