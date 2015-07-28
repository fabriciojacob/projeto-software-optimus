package br.com.softwareOptimus.entidades.dao.empresa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.fiscal.VigenciaRegime;

public class EmpresaDAOHibernate implements EmpresaDAO {

	private EntityManager session;
	private EntityTransaction transaction;

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public void salvar(PessoaJuridica empresa) {
		empresa.setNaturezaPessoa(NaturezaPessoa.EMPRESA);
		if(!this.transaction.isActive()){
			this.transaction.begin();
		}
		this.session.persist(empresa);
		this.transaction.commit();

	}

	@Override
	public void atualizar(PessoaJuridica empresa) {
		if(!this.transaction.isActive()){
			this.transaction.begin();
		}
		this.session.merge(empresa);
		this.transaction.commit();
	}

	@Override
	public void excluir(PessoaJuridica empresa) {
		if(!this.transaction.isActive()){
			this.transaction.begin();
		}
		this.session.remove(empresa);
		this.transaction.commit();

	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

	}

	@Override
	public void close() throws Exception {
		this.session.close();

	}

	@Override
	public PessoaJuridica carregar(Long codigo) {
		String jpql = "Select a from PessoaJuridica a where a.idPessoa = :parCodigo";
		TypedQuery<PessoaJuridica> consulta = this.session.createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCodigo", codigo);
		return consulta.getSingleResult();
	}

	@Override
	public List<Pessoa> listar() {
		String jpql = "Select emp From Pessoa emp where emp.naturezaPessoa = 2";
		TypedQuery<Pessoa> consultaList = this.session.createQuery(jpql,
				Pessoa.class);
		return consultaList.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception {
		String jpql = "Select a from PessoaJuridica a where a.cnpj = :parCNPJ";
		TypedQuery<PessoJuridicaaJuridica> consulta = this.session.createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCNPJ", cnpj);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaNome(String nome) throws Exception {
		String jpql = "Select a from PessoaJuridica a where a.fantasia LIKE :parNome "
				+ "and a.tipoPessoaJuridica = 1";
		TypedQuery<PessoaJuridica> consultaLista = this.session.createQuery(
				jpql, PessoaJuridica.class);
		consultaLista.setParameter("parNome", "%" + nome + "%");
		return consultaLista.getResultList();
	}

	@Override
	public void salvarRegime(VigenciaRegime regime) throws Exception {
		if(!this.transaction.isActive()){
			this.transaction.begin();
		}
		this.session.persist(regime);
		this.transaction.commit();
	}

	@Override
	public void atualizarRegime(VigenciaRegime regime) {
		this.session.merge(regime);

	}

	@Override
	public List<VigenciaRegime> validaRegime(PessoaJuridica empresa, Date data)
			throws Exception {
		String jpql = "Select vig From VigenciaRegime vig"
				+ " where vig.pessoaJuridica = :parPessoa "
				+ " and vig.dataInicio = :parVig";
		TypedQuery<VigenciaRegime> consulta = this.session.createQuery(jpql,
				VigenciaRegime.class);
		consulta.setParameter("parPessoa", empresa);
		consulta.setParameter("parVig", data);
		return consulta.getResultList();

	}

}
