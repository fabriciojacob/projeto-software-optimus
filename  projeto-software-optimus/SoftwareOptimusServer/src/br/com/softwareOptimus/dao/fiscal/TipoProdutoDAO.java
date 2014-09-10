package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.fiscal.TipoProduto;


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

}
