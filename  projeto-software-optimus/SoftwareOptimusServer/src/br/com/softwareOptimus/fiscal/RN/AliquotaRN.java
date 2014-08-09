package br.com.softwareOptimus.fiscal.RN;

import java.util.List;

import br.com.softwareOptimus.dao.fiscal.AliquotaDAO;
import br.com.softwareOptimus.fiscal.Aliquota;
import br.com.softwareOptimus.util.DAOFactory;

public class AliquotaRN {
	
	private AliquotaDAO aliquotaDAO;
	
	public AliquotaRN(){
		this.aliquotaDAO = DAOFactory.criaAliquotaDAO();
	}
	
	public void salva(Aliquota aliquota){
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

	public void altUnid(Aliquota aliquota) {
		this.aliquotaDAO.salva(aliquota);
	}
}
