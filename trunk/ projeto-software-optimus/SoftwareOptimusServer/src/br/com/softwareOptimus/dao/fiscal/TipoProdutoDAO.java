package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.produto.Produto;


public interface TipoProdutoDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
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

}
