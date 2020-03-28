package br.com.cotacoes.service;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import br.com.cotacoes.model.CotacoesModel;
import br.com.cotacoes.repository.CotacoesRepository;

@ApplicationScoped
public class CotacoesService {
	
	@Inject
	CotacoesRepository repo;
	
	public Response save(CotacoesModel cotacoes) {
		return repo.save(cotacoes);
	}
	
	public List<CotacoesModel> findAll() {
		return repo.findAll();
	}
	
	public List<CotacoesModel> findByDataCotacao(Date dataCotacao) {
		return repo.findByDataCotacao(dataCotacao);
	}
	
	public List<CotacoesModel> findByDataRequisicao(Date dataRequisicao) {
		return repo.findByDataRequisicao(dataRequisicao);
	}
}
