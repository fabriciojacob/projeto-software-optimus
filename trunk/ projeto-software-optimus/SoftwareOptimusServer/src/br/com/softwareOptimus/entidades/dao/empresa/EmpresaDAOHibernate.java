package br.com.softwareOptimus.entidades.dao.empresa;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;
import br.com.softwareOptimus.util.JpaUtil;

public class EmpresaDAOHibernate extends JpaUtil implements EmpresaDAO {

	@Override
	public void salvar(PessoaJuridica empresa) {
		empresa.setNaturezaPessoa(NaturezaPessoa.EMPRESA);
		beginTransaction();
		getEntityManager().persist(empresa);
		commitTransaction();

	}

	@Override
	public void atualizar(PessoaJuridica empresa) {
		beginTransaction();
		getEntityManager().merge(empresa);
		commitTransaction();
	}

	@Override
	public void excluir(PessoaJuridica empresa) {
		beginTransaction();
		getEntityManager().remove(empresa);
		commitTransaction();
	}

	@Override
	public PessoaJuridica carregar(Long codigo) {
		String jpql = "Select a from PessoaJuridica a where a.idPessoa = :parCodigo";
		TypedQuery<PessoaJuridica> consulta = getEntityManager().createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCodigo", codigo);
		return consulta.getSingleResult();
	}

	@Override
	public List<Pessoa> listar() {
		String jpql = "Select emp From Pessoa emp where emp.naturezaPessoa = 2";
		TypedQuery<Pessoa> consultaList = getEntityManager().createQuery(jpql,
				Pessoa.class);
		return consultaList.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception {
		String jpql = "Select a from PessoaJuridica a where a.cnpj = :parCNPJ";
		TypedQuery<PessoaJuridica> consulta = getEntityManager().createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCNPJ", cnpj);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaNome(String nome) throws Exception {
		String jpql = "Select a from PessoaJuridica a where a.fantasia LIKE :parNome "
				+ "and a.tipoPessoaJuridica = 1";
		TypedQuery<PessoaJuridica> consultaLista = getEntityManager().createQuery(
				jpql, PessoaJuridica.class);
		consultaLista.setParameter("parNome", "%" + nome + "%");
		return consultaLista.getResultList();
	}

	@Override
	public void salvarRegime(VigenciaRegime regime) throws Exception {
		beginTransaction();
		getEntityManager().persist(regime);
		commitTransaction();
	}

	@Override
	public void atualizarRegime(VigenciaRegime regime) {
		beginTransaction();
		getEntityManager().merge(regime);
		commitTransaction();
	}

	@Override
	public List<VigenciaRegime> validaRegime(PessoaJuridica empresa, Date data)
			throws Exception {
		String jpql = "Select vig From VigenciaRegime vig"
				+ " where vig.pessoaJuridica = :parPessoa "
				+ " and vig.dataInicio = :parVig";
		TypedQuery<VigenciaRegime> consulta = getEntityManager().createQuery(jpql,
				VigenciaRegime.class);
		consulta.setParameter("parPessoa", empresa);
		consulta.setParameter("parVig", data);
		return consulta.getResultList();
	}
}
