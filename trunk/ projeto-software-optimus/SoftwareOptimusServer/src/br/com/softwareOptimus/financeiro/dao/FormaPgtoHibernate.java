package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.FormaPgto;
import br.com.softwareOptimus.util.JpaUtil;

public class FormaPgtoHibernate extends JpaUtil implements FormaPgtoDAO {
	
	@Override
	public void salvar(FormaPgto formaPgto) throws Exception {
		beginTransaction();
		getEntityManager().persist(formaPgto);
		commitTransaction();
	}

	@Override
	public void excluir(FormaPgto formaPgto) throws Exception {
		beginTransaction();
		getEntityManager().remove(formaPgto);
		commitTransaction();
	}

	@Override
	public List<FormaPgto> lista(String descricao) throws Exception {
		String jpql = "Select e From FormaPgto e where e.descricao Like :parDesc";
		TypedQuery<FormaPgto> consulta = getEntityManager().createQuery(jpql, FormaPgto.class);
		consulta.setParameter("parDesc","%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public void editar(FormaPgto formaPgto) throws Exception {
		beginTransaction();
		getEntityManager().merge(formaPgto);
		commitTransaction();
	}

	@Override
	public FormaPgto selecionar(Long id) throws Exception {
		return getEntityManager().find(FormaPgto.class, id);
	}
}
