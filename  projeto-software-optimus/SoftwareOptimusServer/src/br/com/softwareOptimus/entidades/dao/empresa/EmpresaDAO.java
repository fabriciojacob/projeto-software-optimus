package br.com.softwareOptimus.entidades.dao.empresa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public interface EmpresaDAO {
	
	public void salvar(PessoaJuridica empresa);
	public void atualizar(PessoaJuridica empresa);
	public void excluir(PessoaJuridica empresa);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void consultar() throws Exception;
	public PessoaJuridica carregar(Long codigo);
	public List<PessoaJuridica> listar();

}
