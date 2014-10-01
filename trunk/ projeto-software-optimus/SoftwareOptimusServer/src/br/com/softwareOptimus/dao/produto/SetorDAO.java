package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;

public interface SetorDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(Setor setor);
	public void altSet(Setor setor);
	public List<Produto> verProdSet(Setor setor);
	public void remove(Setor setor);
	public List<Setor> listar();
	public List<Setor> consultaId(long parseLong);
	public List<Setor> consultaDesc(String busca);
	public List<Produto> verRemRelGrup(Setor setor, Long idGrup);
	public Setor editSet(Long id);

}
