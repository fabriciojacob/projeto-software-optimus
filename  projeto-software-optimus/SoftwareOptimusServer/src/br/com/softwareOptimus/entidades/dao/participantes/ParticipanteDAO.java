package br.com.softwareOptimus.entidades.dao.participantes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public interface ParticipanteDAO {

	public void salvarPessoaJuridica(PessoaJuridica pessoa) throws Exception;

	public void salvarPessoaFisica(PessoaFisica pessoa) throws Exception;

	public void atualizarPessoaJuridica(PessoaJuridica pessoa) throws Exception;

	public void atualizarPessoaFisica(PessoaFisica pessoa) throws Exception;

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;

	public PessoaFisica carregarPF(Long codigo) throws Exception;

	public List<PessoaFisica> buscaCPF(String CPF) throws Exception;
	
	public List<PessoaFisica> buscaNomePF(String nome) throws Exception;

	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception;

	public List<PessoaJuridica> buscaNomePJ(String nome) throws Exception;

}
