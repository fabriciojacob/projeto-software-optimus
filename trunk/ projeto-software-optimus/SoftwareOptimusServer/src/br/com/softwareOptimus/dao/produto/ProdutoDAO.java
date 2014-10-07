package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.produto.Produto;

public interface ProdutoDAO {
	
	public void salvar(Produto produto);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void alterar(Produto produto);
	public void remover(Produto produto);
	public List<Produto> consultaId(long id);
	public List<Produto> consultaDesc(String busca);
	public List<Produto> listar();
	public Produto editPro(Long id);
}
