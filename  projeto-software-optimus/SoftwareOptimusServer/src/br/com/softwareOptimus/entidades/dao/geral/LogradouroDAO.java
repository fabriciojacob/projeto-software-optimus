package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Pessoa;


public interface LogradouroDAO {
	
	public void salvar(Logradouro logradouro);
	public void atualizar(Logradouro logradouro);
	public void excluir(Long idLogr);
	public void consultar() throws Exception;
	public Logradouro carregar(Long codigo);
	public List<Logradouro> listar(Pessoa pessoa);

}
