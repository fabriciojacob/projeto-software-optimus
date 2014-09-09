package br.com.softwareOptimus.fiscal.RN;

import java.util.Collection;
import java.util.List;
import br.com.softwareOptimus.dao.fiscal.AliquotaDAO;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.util.DAOFactory;

public class AliquotaRN {

	private AliquotaDAO aliquotaDAO;

	public AliquotaRN() {
		this.aliquotaDAO = DAOFactory.criaAliquotaDAO();
	}

	public void salva(Aliquota aliquota) throws Exception {
		this.aliquotaDAO.salva(aliquota);
	}

	public List<Aliquota> consultaId(long parseLong) {
		return aliquotaDAO.consultaId(parseLong);
	}

	public List<Aliquota> consultaAliq(Double busca) {
		return aliquotaDAO.consultaAliq(busca);
	}

	public List<Aliquota> lista() {
		return aliquotaDAO.lista();
	}

	public List<Aliquota> consultaRed(Double busca) {
		return aliquotaDAO.consultaRed(busca);
	}

	public Aliquota editUnid(Long id) {
		return aliquotaDAO.editBusc(id);
	}

	public void remove(Long idAliq) throws Exception {
		this.aliquotaDAO.remover(idAliq);
	}

	public void altAliq(Aliquota aliquota) throws Exception {
		this.aliquotaDAO.altAliq(aliquota);
	}
	
	public List<Aliquota> listaAliqIcms(){
		return this.aliquotaDAO.listaAliqIcms();
	}

	public Integer validaCampoNulo(Aliquota aliquota, Collection<CodigoSituacaoTributaria> colCst, String tipTrib, String tipCst) {
		Integer retorno = 0;
		if(aliquota.getAliquota() == null || aliquota.getReducao() == null || colCst.size() == 0){
			retorno = 1;
		}
		if(tipCst.equals("ICMS") && aliquota.getTipo() == null){
			retorno = 1;
		}
		return retorno;
	}

	public List<Aliquota> listaAliq(TipoCst tipo) {
		return this.aliquotaDAO.listaAliq(tipo);
	}
}
