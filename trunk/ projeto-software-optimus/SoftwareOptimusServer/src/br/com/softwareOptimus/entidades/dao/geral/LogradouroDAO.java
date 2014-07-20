package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.Logradouro;


public interface LogradouroDAO {
	
	public void salvar(Logradouro logradouro);
	public void atualizar(Logradouro logradouro);
	public void excluir(Logradouro logradouro);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void consultar() throws Exception;
	public Logradouro carregar(Long codigo);
	public List<Logradouro> listar();

}