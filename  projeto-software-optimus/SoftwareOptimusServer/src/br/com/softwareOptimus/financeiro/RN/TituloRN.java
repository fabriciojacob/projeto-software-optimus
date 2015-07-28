package br.com.softwareOptimus.financeiro.RN;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Rubrica;
import br.com.softwareOptimus.financeiro.StatusConta;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.financeiro.dao.TituloDAO;
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
		return this.titulo.pesquisaPagamento(dateIni, dataFim, empresa,
				participante, tipo, status);
	}

	public List<Titulo> pesquisaLancamento(Date dataIni, Date dataFim,
			Pessoa empresa, Pessoa particupante, Integer tipo, Integer status)
			throws Exception {
		return this.titulo.pesquisaLancamento(dataIni, dataFim, empresa,
				particupante, tipo, status);
	}

	public void atualizaTitulo(Titulo titulo) throws Exception {
		this.titulo.editar(titulo);
	}

	public List<Titulo> pesquisaPessoa(Pessoa empresa) throws Exception {
		return this.titulo.pesquisaPessoa(empresa);
	}

	public void salvar(Titulo titulo, int oper) throws Exception {
		Date data;
		Calendar c = Calendar.getInstance();
		if (titulo.getCondPgto().getIntervaloDias() > 0) {
			data = titulo.getDataLancamento();
			c.setTime(data);
			c.add(Calendar.DATE, titulo.getCondPgto().getIntervaloDias());
			titulo.setVencimento(c.getTime());
		} else {
			titulo.setVencimento(titulo.getDataLancamento());
		}
		this.titulo.salvar(titulo);
		if (oper != 0) {
			if (titulo.getCondPgto().getParcela() > 1) {
				this.titulo.salvarParcelas(titulo.getIdTitulo());
			}
		}
	}

	public int checkBaixaTitulo(Long id) {
		try {
			this.titulo.checkStatusBaixaTitulo(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int excluirTitulo(Titulo titulo) throws Exception {
		int ret = 0;
		if (titulo.getRubrica().equals(Rubrica.MANUAL)
				&& titulo.getStatus().equals(StatusConta.PENDENTE)) {
			this.titulo.excluir(titulo);
		} else {
			ret = 1;
		}
		return ret;
	}

	public void closed() throws Exception {
		this.titulo.closed();
	}

	public int editar(Titulo titulo) throws Exception {
		if(!titulo.getStatus().equals(StatusConta.BAIXADA)){
			this.titulo.editar(titulo);
			if(!titulo.getValor().equals(titulo.getValorTitulo())){
				Titulo tituloAlt = new Titulo();
				tituloAlt = titulo;
				tituloAlt.setIdTituloPai(titulo.getIdTitulo());
				tituloAlt.setIdTitulo(null);
				tituloAlt.setValor(titulo.getValorTitulo() - titulo.getValor());
				this.titulo.salvar(tituloAlt);
			}
			return 1;
		}else{
			return 0;
		}
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

	public Titulo retornaTitulo(Long id) throws Exception {
		return this.titulo.retornaTitulo(id);
	}
	
	public Titulo retornaTituloGeral(Long id) throws Exception {
		return this.titulo.retornaTituloGeral(id);
	}

	public Titulo retornaTituloBaixado(Long id) throws Exception {
		return this.titulo.retornaTituloBaixado(id);
	}

}
