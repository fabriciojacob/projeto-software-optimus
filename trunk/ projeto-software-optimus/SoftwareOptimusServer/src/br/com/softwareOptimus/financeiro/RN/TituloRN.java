package br.com.softwareOptimus.financeiro.RN;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.com.financeiro.dao.TituloDAO;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.DAOFactory;

public class TituloRN {

	private TituloDAO titulo;

	public TituloRN() {
		this.titulo = DAOFactory.criaTitulo();
	}

	public List<Titulo> pesquisaVencimento(Date dataIni, Date dataFim,
			Pessoa empresa, Pessoa participante, TipoTitulo tipo) throws Exception {
		return this.titulo.pesquisaVencimento(dataIni, dataFim, empresa,
				participante, tipo);
	}

	public List<Titulo> pesquisaPagamento(Date dateIni, Date dataFim,
			Pessoa empresa, Pessoa participante, TipoTitulo tipo) throws Exception {
		return this.pesquisaPagamento(dateIni, dataFim, empresa, participante, tipo);
	}

	public List<Titulo> pesquisaPessoa(Pessoa empresa) throws Exception {
		return this.pesquisaPessoa(empresa);
	}

	public TituloDAO getTitulo() {
		return titulo;
	}

	public void setTitulo(TituloDAO titulo) {
		this.titulo = titulo;
	}

}
