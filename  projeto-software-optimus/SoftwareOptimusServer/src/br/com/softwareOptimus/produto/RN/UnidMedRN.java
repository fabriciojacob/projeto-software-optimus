package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.UnidMedDAO;
import br.com.softwareOptimus.produto.UnidMed;
import br.com.softwareOptimus.util.DAOFactory;

public class UnidMedRN {

	private UnidMedDAO unidMedDAO;

	public UnidMedRN() {
		this.unidMedDAO = DAOFactory.criaUnidMedDAO();
	}

	public void salvar(UnidMed unidMed) {
		this.unidMedDAO.salvar(unidMed);
	}
	
	public List<UnidMed> consultaId(Long id){
		return this.unidMedDAO.consultarId(id);
	}
	
	public List<UnidMed> consultaUnid(String unid){
		return this.unidMedDAO.consultarUnid(unid);
	}
	
	public List<UnidMed> consultaDesc(String desc){
		return this.unidMedDAO.consultarDesc(desc);
	}
	
	public List<UnidMed> lista(){
		return this.unidMedDAO.lista();
	}
	
	public UnidMed editUnid(Long id){
		return this.unidMedDAO.editBusc(id);
	}
	
	public void altUnid(UnidMed unidMed) throws Exception{
		this.unidMedDAO.altUnid(unidMed);		
	}
	
	public void remove(Long idUnid) throws Exception {
		this.unidMedDAO.remover(idUnid);		
	}

	public Integer validaCampoNulo(UnidMed unidMed) {
		Integer retorno =0;
		if (unidMed.getDescUnid().equals("") || unidMed.getUnid().equals("")){
			retorno = 1;
		}
		return retorno;
	}

	public int countUnidadeMedidaPaginacao(UnidMed unidMed) {
		return this.unidMedDAO.countUnidadeMedidaPaginacao(unidMed);
	}

	public List<UnidMed> buscaUnidadeMedidaPaginacao(UnidMed unidMed,int first, int pageSize) {
		return this.unidMedDAO.buscaUnidadeMedidaPaginacao(unidMed, first, pageSize);
	}
}
