package br.com.softwareOptimus.fiscal.RN;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.dao.fiscal.GradeTributariaDAO;
import br.com.softwareOptimus.dao.fiscal.GradeTributariaVigenciaDAO;
import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.util.DAOFactory;

public class GradeTributariaRN {

	private GradeTributariaDAO gradeTribDAO;
	private GradeTributariaVigenciaDAO gradeTribVigDAO;

	public GradeTributariaRN() {
		this.gradeTribDAO = DAOFactory.criaGradeTribDAO();
		this.gradeTribVigDAO = DAOFactory.criaGradeTribVigDAO();
	}

	public Integer validaCampoNulo(GradeTributaria grade) {
		Integer retorno = 0;
		if (grade.getDescricao().equals("")) {
			retorno = 1;
		}
		return retorno;
	}

	public Integer validaCampoNuloVig(GradeTributariaVigencia gradeVig) {
		Integer retorno = 0;
		if (gradeVig.getDescricao().equals("")
				|| gradeVig.getAliquota() == null
				|| gradeVig.getDestino() == null
				|| gradeVig.getOrigem() == null || gradeVig.getIo() == null
				|| gradeVig.getTipoGrade() == null
				|| gradeVig.getVigencia() == null) {
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(GradeTributaria grade) {
		this.gradeTribDAO.salvar(grade);
	}

	public void altGrade(GradeTributaria grade) {
		this.gradeTribDAO.altGrade(grade);
	}

	public void remover(GradeTributaria grade) throws IOException, SQLException {
		this.gradeTribDAO.remover(grade);
	}

	public List<GradeTributariaVigencia> listarVig(GradeTributaria grade) {
		return this.gradeTribVigDAO.listaVig(grade);
	}

	public List<GradeTributaria> consultaId(long id) {
		return this.gradeTribDAO.listaConsultaId(id);
	}

	public List<GradeTributaria> consultaDesc(String busca) {
		return this.gradeTribDAO.listaConsultaDesc(busca);
	}

	public List<GradeTributaria> listar() {
		return this.gradeTribDAO.listar();
	}

	public GradeTributaria editGrade(Long id) {
		return this.gradeTribDAO.consultaId(id);
	}

	public void removerVig(Long idGradeVig) {
		this.gradeTribVigDAO.remover(idGradeVig);
	}

	public void salvaVig(GradeTributariaVigencia gradeVig) {
		this.gradeTribVigDAO.salvaVig(gradeVig);
	}

	public List<GradeTributariaVigencia> validaInclusao(Estado origem, Estado destino,
			Aliquota aliquota, IO io, TipoPessoaJuridica tipoGrade,
			Date vigencia, Pauta pauta) {
		return this.gradeTribVigDAO.validaInclusao(origem, destino, aliquota, io, tipoGrade,
				vigencia, pauta);
	}

	public Integer verificaRemocao(GradeTributaria grade) {
		List<GradeTributaria> gra = new ArrayList<GradeTributaria>();
		gra.add(grade);
		List<FiguraFiscal> fig = this.gradeTribDAO.verificaRemocao(gra);
		if(fig.size() != 0){
			return 1;
		}else{
			return 0;
		}
	}
}
