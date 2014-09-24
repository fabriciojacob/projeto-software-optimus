package br.com.softwareOptimus.financeiro.RN;

import java.util.Date;
import java.util.List;
import br.com.softwareOptimus.com.financeiro.dao.TituloDAO;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.DAOFactory;

public class TituloRN {

	private TituloDAO titulo;

	public TituloRN() {
		this.titulo = DAOFactory.criaTitulo();
	}

	public List<Titulo> pesquisaVencimento(Date dataIni, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		return this.titulo.pesquisaVencimento(dataIni, dataFim, empresa,
				participante, tipo, status);
	}

	public List<Titulo> pesquisaPagamento(Date dateIni, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		return this.pesquisaPagamento(dateIni, dataFim, empresa, participante,
				tipo, status);
	}

	public List<Titulo> pesquisaLancamento(Date dataIni, Date dataFim,
			Pessoa empresa, Pessoa particupante, Integer tipo, Integer status)
			throws Exception {
		return this.pesquisaLancamento(dataIni, dataFim, empresa, particupante,
				tipo, status);
	}

	public List<Titulo> pesquisaPessoa(Pessoa empresa) throws Exception {
		return this.pesquisaPessoa(empresa);
	}

	public void salvar(Titulo titulo) throws Exception {
		this.titulo.salvar(titulo);
	}

	public void excluir(Titulo titulo) throws Exception {
		this.titulo.excluir(titulo);
	}

	public void editar(Titulo titulo) throws Exception {
		this.titulo.editar(titulo);
	}

	public TituloDAO getTitulo() {
		return titulo;
	}

	public void setTitulo(TituloDAO titulo) {
		this.titulo = titulo;
	}

	public List<Pessoa> listaParticipante(String nome) throws Exception {
		return this.titulo.listaParticipante(nome);
	}

	public Pessoa participante(Long id) throws Exception {
		return this.titulo.participante(id);
	}

}
