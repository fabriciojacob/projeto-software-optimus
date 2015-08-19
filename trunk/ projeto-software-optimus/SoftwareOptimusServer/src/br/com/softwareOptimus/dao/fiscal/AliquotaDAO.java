package br.com.softwareOptimus.dao.fiscal;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.PisCofins;
import br.com.softwareOptimus.fiscal.TipoCst;

public interface AliquotaDAO {

	public void altAliq(Aliquota aliquota) throws Exception;
	public Aliquota editBusc(Long id);
	public void remover(Long id) throws Exception;
	public List<Aliquota> lista();
	public void salva(Aliquota aliq) throws Exception;
	public List<Aliquota> consultaId(long parseLong);
	public List<Aliquota> consultaAliq(Double busca);
	public List<Aliquota> consultaRed(Double busca);
	public List<Aliquota> listaAliqIcms();
	public List<Aliquota> listaAliq(TipoCst tipo);
	public List<Aliquota> listaAliqPisCofins(TipoCst pisCofins, PisCofins tipoAliq);
	public List<CodTabelaGov> verificaRemocao1(Aliquota aliquota);
	public List<GradeTributariaVigencia> verificaRemocao2(Aliquota aliquota);
	public List<Aliquota> buscaAliquotaPaginacao(Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc, int first, int pageSize);
	public int countAliquotaPaginacao(Double maxAliquota, Double minAliquota, Double maxReduc, Double minReduc);
	public void defineCondicao(StringBuilder sql, Double maxAliquota,Double minAliquota, Double maxReduc, Double minReduc);
	public void defineParametros(Query qry, Double maxAliquota, Double minAliquota,Double maxReduc, Double minReduc);
}
