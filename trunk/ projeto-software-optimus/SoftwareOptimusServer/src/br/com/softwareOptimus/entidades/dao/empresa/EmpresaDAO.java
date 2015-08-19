package br.com.softwareOptimus.entidades.dao.empresa;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public interface EmpresaDAO {

	public void salvar(PessoaJuridica empresa);
	public void salvarRegime(VigenciaRegime regime) throws Exception;
	public void atualizar(PessoaJuridica empresa);
	public void atualizarRegime(VigenciaRegime regime);
	public void excluir(PessoaJuridica empresa);
	public PessoaJuridica carregar(Long codigo);
	public List<Pessoa> listar();
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception;
	public List<PessoaJuridica> buscaNome(String nome) throws Exception;
	public List<VigenciaRegime> validaRegime(PessoaJuridica empresa, Date data) throws Exception;
}
