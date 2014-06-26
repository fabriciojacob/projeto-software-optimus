package br.com.softwareOptimus.util;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;


public class ConsultasGerais {

	public Municipio retornaCidade(final String municipioSelec,
			final String ufSelect, final EntityManager em) {

		String consultaCid = "Select m from Municipio m join m.uf u"
				+ " where m.descricao = :parCidade"
				+ "  and u.descricao = :parEstado";
		TypedQuery<Municipio> query = em.createQuery(consultaCid,
				Municipio.class);
		query.setParameter("parCidade", municipioSelec);
		query.setParameter("parEstado", ufSelect);

		Municipio result = query.getSingleResult();

		return result;
	}

	public <T> Long retornaCodigo(T tipo, final EntityManager em) {
		Long codigo = null;
		Object x = em.find(tipo.getClass(), 1l);
		return codigo;
	}

	public static List<String> filtroCidades(String ufSelect,
			final EntityManager em) {
		String cidades = "select c.descricao from Municipio c join c.uf u"
				+ " where u.descricao = :parEstado";
		TypedQuery<String> query = em.createQuery(cidades, String.class);
		query.setParameter("parEstado", ufSelect);
		return query.getResultList();
	}

	public Long qta(final EntityManager em, NaturezaPessoa tipoPessoa) {
		String count = "Select count(p) from PessoaJuridica p"
				+ " where p.naturezaPessoa = :parTipo";
		Query q = em.createQuery(count);
		q.setParameter("parTipo", tipoPessoa);
		Long qta = (Long) q.getSingleResult();
		return qta;
	}

	public Long checkCNPJ(String cnpj, final EntityManager em) {
		Long retorno = null;

		String consulta = "Select p.idPessoa from PessoaJuridica p"
				+ " where p.cnpj = :parCNPJ";
		TypedQuery<Long> query = em.createQuery(consulta, Long.class);
		query.setParameter("parCNPJ", cnpj);
		try {
			retorno = query.getSingleResult();
		} catch (Exception ex) {
			retorno = null;
		}

		return retorno;
	}

	public List<PessoaJuridica> pesquisaCNPJ(String cnpj, final EntityManager em) {
		List<PessoaJuridica> retorno = new ArrayList<PessoaJuridica>();
		String consulta = "Select p from PessoaJuridica p"
				+ " where p.cnpj = :parCNPJ";
		TypedQuery<PessoaJuridica> query = em.createQuery(consulta,
				PessoaJuridica.class);
		query.setParameter("parCNPJ", cnpj);
		try {
			retorno = query.getResultList();
		} catch (Exception ex) {
			retorno = null;
		}

		return retorno;
	}

	public List<PessoaFisica> pesquisaCPF(String cpf, final EntityManager em) {
		List<PessoaFisica> retorno = new ArrayList<PessoaFisica>();
		String consulta = "Select p from PessoaFisica f "
				+ " where f.cpf = :parCpf";
		TypedQuery<PessoaFisica> query = em.createQuery(consulta,
				PessoaFisica.class);
		query.setParameter("parCpf", cpf);
		try {
			retorno = query.getResultList();
		} catch (Exception ex) {
			retorno = null;
		}
		return retorno;
	}

	public List<PessoaJuridica> pesquisaNomePJ(String nome,
			final EntityManager em, int tipoPessoa) {

		NaturezaPessoa p;
		if (tipoPessoa == 0) {
			p = NaturezaPessoa.CLIENTE;
		} else if (tipoPessoa == 1) {
			p = NaturezaPessoa.FORNECEDOR;
		} else if (tipoPessoa == 2) {
			p = NaturezaPessoa.EMPRESA;
		} else {
			p = NaturezaPessoa.CONTADOR;
		}

		List<PessoaJuridica> retorno = new ArrayList<PessoaJuridica>();
		String consulta = "Select p from PessoaJuridica p"
				+ " where p.naturezaPessoa = :parTipo"
				+ " and p.fantasia LIKE :parNome";
		TypedQuery<PessoaJuridica> query = em.createQuery(consulta,
				PessoaJuridica.class);
		query.setParameter("parNome", "%" + nome + "%");
		query.setParameter("parTipo", p);
		try {
			retorno = query.getResultList();
		} catch (Exception ex) {
			retorno = null;
		}

		return retorno;
	}

	public List<PessoaFisica> pesquisaNomePF(String nome, final EntityManager em) {
		List<PessoaFisica> retorno = new ArrayList<PessoaFisica>();
		String consulta = "Select p from PessoaFisica p"
				+ " where p.fantasia = :parNome";
		TypedQuery<PessoaFisica> query = em.createQuery(consulta,
				PessoaFisica.class);
		query.setParameter("parNome", nome);
		try {
			retorno = query.getResultList();
		} catch (Exception ex) {
			retorno = null;
		}

		return retorno;
	}

	public String retornaNomeCidade(EntityManager em,
			PessoaJuridica pessoaJuridica) {
		String cidade = null;

		String consulta = "Select l.municipio From Logradouro l"
				+ " Where l.tipoLogr = 0" + " and l.pessoa = :parPessoa";

		TypedQuery<Municipio> query = em.createQuery(consulta, Municipio.class);
		query.setParameter("parPessoa", pessoaJuridica);
		try {
			Municipio m = query.getSingleResult();
			cidade = m.getDescricao();
		} catch (Exception e) {
			cidade = null;
		}

		return cidade;
	}

	public Logradouro retornaLogr(EntityManager em,
			PessoaJuridica pessoaJuridica) {
		Logradouro logr = null;
		String consulta = "Select l from Logradouro l "
				+ " where l.pessoa = :parPessoa" + " and l.tipoLogr = 0";
		TypedQuery<Logradouro> query = em.createQuery(consulta,
				Logradouro.class);
		query.setParameter("parPessoa", pessoaJuridica);
		try {
			logr = query.getSingleResult();
		} catch (Exception e) {
			logr = null;
		}
		return logr;
	}

	public Pessoa retornaPessoa(EntityManager em, Long codigo) {
		Pessoa pessoa;
		if(em.getTransaction().isActive() == false){
			em.getTransaction().begin();
		}
		String jpql = "select e from Pessoa e where e.idPessoa = :idPessoa";

		TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);

		query.setParameter("idPessoa", codigo);

		try {
			pessoa = query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		}

		return pessoa;
	}
}
