package br.com.softwareOptimus.entidades.dao.participantes;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public interface ParticipanteDAO {

	public void salvarPessoaJuridica(PessoaJuridica pessoa) throws Exception;
	public void salvarPessoaFisica(PessoaFisica pessoa) throws Exception;
	public void atualizarPessoaJuridica(PessoaJuridica pessoa) throws Exception;
	public void atualizarPessoaFisica(PessoaFisica pessoa) throws Exception;
	public PessoaFisica carregarPF(Long codigo) throws Exception;
	public PessoaJuridica carregarPJ(Long codigo) throws Exception;
	public List<PessoaFisica> buscaCPF(String CPF) throws Exception;
	public List<PessoaFisica> buscaNomePF(String nome) throws Exception;
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception;
	public List<PessoaJuridica> buscaNomePJ(String nome) throws Exception;
	public int countPessoaFisicaPaginacao(PessoaFisica pessoaFisica);
	public List<PessoaFisica> buscaPessoaFisicaPaginacao(PessoaFisica pessoaFisica, int first, int pageSize);
	public void defineCondicaoPF(StringBuilder sql, PessoaFisica pessoaFisica);
	public void defineParametrosPF(Query qry, PessoaFisica pessoaFisica);
	public void defineParametrosPJ(Query qry, PessoaJuridica pessoaJuridica);
	public List<PessoaJuridica> buscaPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica, String natureza, int first, int pageSize);
	public int countPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica, String natureza);
	public void defineCondicaoPJ(StringBuilder sql, PessoaJuridica pessoaJuridica,String natureza);
}
