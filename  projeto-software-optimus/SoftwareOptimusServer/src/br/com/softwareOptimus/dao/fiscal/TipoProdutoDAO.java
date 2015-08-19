package br.com.softwareOptimus.dao.fiscal;
import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.produto.Produto;


public interface TipoProdutoDAO {

	public void salva(TipoProduto tipo);
	public void altTipo(TipoProduto tipo);
	public void remover(TipoProduto tipo);
	public List<TipoProduto> lista();
	public List<TipoProduto> consultaId(long id);
	public List<TipoProduto> consultaDesc(String busca);
	public TipoProduto editaTipo(Long id);
	public List<Produto> verificaRemocao(TipoProduto tipo);
	public List<Ncm> consultaNCMCod(String busca);
	public List<Ncm> consultaNCMDesc(String busca);
	public List<Ncm> consultaNatDesc(String busca);
	public List<Ncm> consultaNatCod(String busca);
	public List<Ncm> consultaTbDesc(String busca);
	public Ncm consultaNCMId(Long idNcm);
	public List<TipoProduto> listarTipoVig();
	public int countTipoProdutoPaginacao(TipoProduto tipoProd);
	public List<TipoProduto> buscaTipoProdutoPaginacao(TipoProduto tipoProd,int first, int pageSize);
	public void defineCondicao(StringBuilder sql, TipoProduto tipoProd);
	public void defineParametros(Query qry, TipoProduto tipoProd);

}
