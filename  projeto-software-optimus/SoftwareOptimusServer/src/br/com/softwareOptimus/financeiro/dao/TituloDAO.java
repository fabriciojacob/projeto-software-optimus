package br.com.softwareOptimus.financeiro.dao;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Titulo;

public interface TituloDAO {

	public void salvar(Titulo titulo) throws Exception;
	public void editar(Titulo titulo) throws Exception;
	public List<Titulo> pesquisaVencimento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;
	public List<Titulo> pesquisaPagamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;
	public List<Titulo> pesquisaLancamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;
	public List<Titulo> pesquisaPessoa(Pessoa p) throws Exception;
	public List<Pessoa> listaParticipante(String nome) throws Exception;
	public void excluir(Titulo titulo) throws Exception;
	public Pessoa participante(Long id) throws Exception;
	public void salvarParcelas(Long titulo) throws Exception;
	public Titulo retornaTitulo(Long id) throws Exception;
	public Titulo retornaTituloBaixado(Long id) throws Exception;
	public void checkStatusBaixaTitulo(Long id) throws Exception;
	public Titulo retornaTituloGeral(Long id) throws Exception;
}
