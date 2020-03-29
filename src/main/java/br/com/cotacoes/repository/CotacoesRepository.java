package br.com.cotacoes.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import br.com.cotacoes.model.CotacoesModel;

@ApplicationScoped
public class CotacoesRepository {

	@Inject
	EntityManager em;

	@Transactional
	public Response save(CotacoesModel cotacoes) {
		em.persist(cotacoes);
		return Response.ok(cotacoes).status(201).build();
	}

	public List<CotacoesModel> findAll() {
		TypedQuery<CotacoesModel> query = em.createNamedQuery("CotacoesModel.findAll", CotacoesModel.class);
		List<CotacoesModel> cotacoes = query.getResultList();
		return cotacoes;
	}
	
	public List<CotacoesModel> findByCotacaoData(String dataCotacao) {
		TypedQuery<CotacoesModel> query = em.createNamedQuery("CotacoesModel.findByCotacaoData", CotacoesModel.class);
		List<CotacoesModel> cotacoes = query.getResultList();
		return cotacoes;
	}
	
	public List<CotacoesModel> findByDataRequisicao(String dataRequisicao) {
		TypedQuery<CotacoesModel> query = em.createNamedQuery("CotacoesModel.findByDataRequisicao", CotacoesModel.class);
		List<CotacoesModel> cotacoes = query.getResultList();
		return cotacoes;
	}
	
	public List<CotacoesModel> findByCotacaoPeriodo(String dataCotacaoInicio, String dataCotacaoFim) {
		TypedQuery<CotacoesModel> query = em.createNamedQuery("CotacoesModel.findByCotacaoPeriodo", CotacoesModel.class);
		List<CotacoesModel> cotacoes = query.getResultList();
		return cotacoes;
	}
}
