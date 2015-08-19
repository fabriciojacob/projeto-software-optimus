package br.com.softwareOptimus.entidades.dao.participantes;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.util.JpaUtil;

public class ParticipanteDAOHibernate extends JpaUtil implements ParticipanteDAO {

	@Override
	public void salvarPessoaJuridica(PessoaJuridica pessoa) throws Exception {
		beginTransaction();
		getEntityManager().persist(pessoa);
		commitTransaction();
	}

	@Override
	public void salvarPessoaFisica(PessoaFisica pessoa) throws Exception {
		beginTransaction();
		getEntityManager().persist(pessoa);
		commitTransaction();
	}

	@Override
	public void atualizarPessoaJuridica(PessoaJuridica pessoa) throws Exception {
		beginTransaction();
		getEntityManager().merge(pessoa);
		commitTransaction();
	}

	@Override
	public void atualizarPessoaFisica(PessoaFisica pessoa) throws Exception {
		beginTransaction();
		getEntityManager().merge(pessoa);
		commitTransaction();
	}

	@Override
	public PessoaFisica carregarPF(Long codigo) throws Exception {
		beginTransaction();
		return getEntityManager().find(PessoaFisica.class, codigo);
	}
	
	@Override
	public PessoaJuridica carregarPJ(Long codigo) throws Exception {
		beginTransaction();
		return getEntityManager().find(PessoaJuridica.class,codigo);
	}

	@Override
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception {
		String jpql = "Select p From PessoaJuridica p "
				+ " where p.fantasia = :parCnpj " + " and p.naturezaPessoa <> 2";
		TypedQuery<PessoaJuridica> consulta = getEntityManager().createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCnpj", cnpj);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaNomePJ(String nome) throws Exception {
		String jpql = "Select p From PessoaJuridica p "
				+ " where p.fantasia LIKE :parNome" + " and p.naturezaPessoa <> 2";
		TypedQuery<PessoaJuridica> consulta = getEntityManager().createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parNome","%" + nome + "%");
		return consulta.getResultList();
	}

	@Override
	public List<PessoaFisica> buscaCPF(String CPF) throws Exception {
		String jpql = "Select p From PessoaFisica p "
				+ " where p.cpf = :parCPF " + " and p.naturezaPessoa <> 2";
		TypedQuery<PessoaFisica> consulta = getEntityManager().createQuery(jpql,
				PessoaFisica.class);
		consulta.setParameter("parCPF",CPF);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaFisica> buscaNomePF(String nome) throws Exception {
		String jpql = "Select p From PessoaFisica p"
				+ " where p.fantasia LIKE :parPessoa"
				+ " and p.naturezaPessoa <> 2";
		TypedQuery<PessoaFisica> consulta = getEntityManager().createQuery(jpql,
				PessoaFisica.class);
		consulta.setParameter("parPessoa","%" + nome + "%");
		return consulta.getResultList();
	}

	@Override
	public int countPessoaFisicaPaginacao(PessoaFisica pessoaFisica) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicaoPF(sql, pessoaFisica);
		Query qryMaximo = getEntityManager().createQuery("select Count(p) from PessoaFisica p ".concat(sql.toString()));
		this.defineParametrosPF(qryMaximo, pessoaFisica);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaFisica> buscaPessoaFisicaPaginacao(PessoaFisica pessoaFisica, int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicaoPF(sql, pessoaFisica);
		Query qry = getEntityManager().createQuery("select p from PessoaFisica p ".concat(sql.toString()));
		this.defineParametrosPF(qry, pessoaFisica);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<PessoaFisica> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicaoPF(StringBuilder sql, PessoaFisica pessoaFisica){
		if(pessoaFisica.getFantasia() != null && pessoaFisica.getFantasia() != ""){
			sql.append(sql.length() == 0 ? " where p.fantasia like :fantasia ": " and p.fantasia like :fantasia ");
		}
		if(pessoaFisica.getCpf() != null && pessoaFisica.getCpf() != ""){
			sql.append(sql.length() == 0 ? " where p.cpf like :cpf ": " and p.cpf like :cpf ");
		}
		if(pessoaFisica.getRg() != null && pessoaFisica.getRg() != ""){
			sql.append(sql.length() == 0 ? " where p.rg like :rg ": " and p.rg like :rg ");
		}
	}
	
	@Override
	public void defineParametrosPF(Query qry, PessoaFisica pessoaFisica){
		if(pessoaFisica.getFantasia() != null && pessoaFisica.getFantasia() != ""){
			qry.setParameter("fantasia", "%" + pessoaFisica.getFantasia() + "%");
		}
		if(pessoaFisica.getCpf() != null && pessoaFisica.getCpf() != ""){
			qry.setParameter("cpf", "%" + pessoaFisica.getCpf() + "%");
		}
		if(pessoaFisica.getRg() != null && pessoaFisica.getRg() != ""){
			qry.setParameter("rg", "%" + pessoaFisica.getRg() + "%");
		}
	}
	
	@Override
	public int countPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica, String natureza) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicaoPJ(sql, pessoaJuridica, natureza);
		Query qryMaximo = getEntityManager().createQuery("select Count(p) from PessoaJuridica p ".concat(sql.toString()));
		this.defineParametrosPJ(qryMaximo, pessoaJuridica);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PessoaJuridica> buscaPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica, String natureza, int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicaoPJ(sql, pessoaJuridica, natureza);
		Query qry = getEntityManager().createQuery("select p from PessoaJuridica p ".concat(sql.toString()));
		this.defineParametrosPJ(qry, pessoaJuridica);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<PessoaJuridica> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicaoPJ(StringBuilder sql, PessoaJuridica pessoaJuridica, String natureza){
		if(pessoaJuridica.getFantasia() != null && pessoaJuridica.getFantasia() != ""){
			sql.append(sql.length() == 0 ? " where p.fantasia like :fantasia ": " and p.fantasia like :fantasia ");
		}
		if(pessoaJuridica.getRazaoSocial() != null && pessoaJuridica.getRazaoSocial() != ""){
			sql.append(sql.length() == 0 ? " where p.razaoSocial like :razaoSocial ": " and p.razaoSocial like :razaoSocial ");
		}
		if(pessoaJuridica.getCnpj() != null && pessoaJuridica.getCnpj() != ""){
			sql.append(sql.length() == 0 ? " where p.cnpj like :cnpj ": " and p.cnpj like :cnpj ");
		}
		if(pessoaJuridica.getIe() != null && pessoaJuridica.getIe() != ""){
			sql.append(sql.length() == 0 ? " where p.ie like :ie ": " and p.ie like :ie ");
		}
		//natureza pes retornar diferente de empresa
		//natureza emp retorna igual empresa
		if(natureza.equals("pes")){
			sql.append(sql.length() == 0 ? " where p.naturezaPessoa <> :naturezaPessoa ": " and p.naturezaPessoa <> :naturezaPessoa ");
		}else{
			sql.append(sql.length() == 0 ? " where p.naturezaPessoa = :naturezaPessoa ": " and p.naturezaPessoa = :naturezaPessoa ");
		}
	}
	
	@Override
	public void defineParametrosPJ(Query qry, PessoaJuridica pessoaJuridica){
		if(pessoaJuridica.getFantasia() != null && pessoaJuridica.getFantasia() != ""){
			qry.setParameter("fantasia", "%" + pessoaJuridica.getFantasia() + "%");
		}
		if(pessoaJuridica.getRazaoSocial() != null && pessoaJuridica.getRazaoSocial() != ""){
			qry.setParameter("razaoSocial", "%" + pessoaJuridica.getRazaoSocial() + "%");
		}
		if(pessoaJuridica.getCnpj() != null && pessoaJuridica.getCnpj() != ""){
			qry.setParameter("cnpj", "%" + pessoaJuridica.getCnpj() + "%");
		}
		if(pessoaJuridica.getIe() != null && pessoaJuridica.getIe() != ""){
			qry.setParameter("ie", "%" + pessoaJuridica.getIe() + "%");
		}
		qry.setParameter("naturezaPessoa", NaturezaPessoa.EMPRESA);
	}
}
