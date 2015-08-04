package br.com.softwareOptimus.fiscal.RN;

import java.util.List;
import br.com.softwareOptimus.dao.fiscal.FiguraFiscalDAO;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.util.DAOFactory;

public class FiguraFiscalRN {
	
	private FiguraFiscalDAO figuraDAO;
	
	public FiguraFiscalRN(){
		this.figuraDAO = DAOFactory.criaFiguraDAO();
	}

	public Integer validaCampoNulo(FiguraFiscal figura, List<GradeTributaria> listaGrade) {
		Integer retorno = 0;
		if (figura.getDescricao().equals("") || listaGrade.size() == 0){
			retorno = 1;
		}
		return retorno;
	}

	public void salvar(FiguraFiscal figura) {
		this.figuraDAO.salva(figura);
	}

	public void altFigura(FiguraFiscal figura) {
		this.figuraDAO.altFigura(figura);
	}

	public void remover(FiguraFiscal figura) {
		this.figuraDAO.remover(figura);
	}

	public List<FiguraFiscal> consultaId(long id) {
		return this.figuraDAO.consultaId(id);
	}

	public List<FiguraFiscal> consultaDesc(String desc) {
		return this.figuraDAO.consultaDesc(desc);
	}

	public List<FiguraFiscal> listar() {
		return this.figuraDAO.listar();
	}

	public FiguraFiscal editFigura(Long id) {
		return this.figuraDAO.editFigura(id);
	}

	public Integer verificaRemocao(FiguraFiscal figura) {
		List<Produto> listProd = this.figuraDAO.verificaRemocao(figura);
		if(listProd.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

	public int countFiguraFiscalPaginacao(FiguraFiscal figuraFiscal,GradeTributaria gradeTributaria) {
		return this.figuraDAO.countFiguraFiscalPaginacao(figuraFiscal,gradeTributaria) ;
	}

	public List<FiguraFiscal> buscaFiguraFiscalPaginacao(FiguraFiscal figuraFiscal, GradeTributaria gradeTributaria,int first, int pageSize) {
		return this.figuraDAO.buscaFiguraFiscalPaginacao(figuraFiscal, gradeTributaria, first, pageSize);
	}
}
