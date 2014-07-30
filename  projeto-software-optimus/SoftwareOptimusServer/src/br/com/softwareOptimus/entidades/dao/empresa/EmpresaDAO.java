package br.com.softwareOptimus.entidades.dao.empresa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public interface EmpresaDAO {
	
	public void salvar(PessoaJuridica empresa);
	public void salvarRegime(VigenciaRegime regime) throws Exception;
	public void atualizar(PessoaJuridica empresa);
	public void atualizarRegime(VigenciaRegime regime);
	public void excluir(PessoaJuridica empresa);
	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public PessoaJuridica carregar(Long codigo);
	public List<PessoaJuridica> listar();
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception;
	public List<PessoaJuridica> buscaNome(String nome) throws Exception;
}
